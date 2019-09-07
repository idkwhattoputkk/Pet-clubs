package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

public class Controller {
	//attributes
	private final static String OWNERS_PATH="data"+File.separator+"owners.txt";
	private final static String CLUBS_PATH ="data"+File.separator+"clubs.txt";
	private final static String PETS_PATH ="data"+File.separator+"pets.txt";
	private ArrayList<Club> clubs;
	
	
	//methods
	public ArrayList<Club> getClubs() {
		return clubs;
	}
	public void setClubs(ArrayList<Club> clubs) {
		this.clubs = clubs;
	}
	public Controller() {
		clubs = new ArrayList<>();
	}
	
	public void savePets() {
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).savePets(PETS_PATH);
		}
				
	}
	public void saveOwners(){
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		for (int i = 0; i < clubs.size(); i++) {
			clubs.get(i).saveOwners(OWNERS_PATH);
		}
	}
	public void saveClubs() {
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		File f= new File(CLUBS_PATH);
		try {
			PrintWriter pr = new PrintWriter(f);
			clubs.forEach((c)-> pr.write(c.toString()));
			pr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	// sequential search
	public String searchByNameOwner(String name) {
		String s= "";
		for (int i = 0; i < clubs.size(); i++) {
			s+=clubs.get(i).searchByName(name).toString();
		}
		return s;
	}
	// *********************************************************************
	// *********************************************************************
	//
	// ordering the Clubs array list and creating the search methods.
	//
	// *********************************************************************
	// *********************************************************************

	// sequential search
	public Club searchByName(String name) {
		boolean ended=false;
		Club toPaint=null;
		for(int i=0;i<clubs.size() && !ended;i++) {
			if(clubs.get(i).getName().equalsIgnoreCase(name)) {
				ended=true;
				toPaint =(Club) clubs.get(i);
				}
		}
		return toPaint;
	}
	// binary search
	public Club searchByDate(String date) {
		orderByDateClubs();
		int init=0;
		boolean ended = false;
		int end = clubs.size()-1;
		Club toSearch = new Club("",date, 0, "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Club mid = (Club)clubs.get(middle);
			if(mid.compareByDate(toSearch)==0) {
				ended=true;
			}else if(mid.compareByDate(toSearch)>0) {
				end = middle-1;
			}else {
				end= middle+1;
			}
		}
		return toSearch;
	}
	// binary search
	public Club searchByIdClubs(int id) {
		orderByIdClubs();
		int init=0;
		boolean ended = false;
		int end = clubs.size()-1;
		Club toSearch = new Club("","", id, "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Club mid = (Club) clubs.get(middle);
			if(toSearch.getId()==mid.getId()) {
				ended=true;
			}else if(toSearch.getId()<mid.getId()) {
				end = middle-1;
			}else {
				end= middle+1;
			}
		}
		return toSearch;
	}
	// binary search
	public Club searchByTypePetClubs(String typePet) {
		orderByTypePetClubs();
		int init=0;
		boolean ended = false;
		int end = clubs.size()-1;
		Club toSearch = new Club("","", 0, typePet);
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Club mid = (Club)clubs.get(middle);
			if(mid.compareByTypePet(toSearch)==0) {
				ended=true;
			}else if(mid.compareByTypePet(toSearch)>0) {
				end = middle-1;
			}else {
				end= middle+1;
			}
		}
		return toSearch;
	}
	
	// bubble
	public void orderByNameClubs() {
		for (int i = clubs.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Club c1 = (Club) clubs.get(j);
				Club c2 = (Club) clubs.get(j + 1);

				if (c1.compareByName(c2) > 0) {
					clubs.set(j, c2);
					clubs.set(j + 1, c1);
				}
			}
		}
	}
	//insertion
	public void orderByDateClubs() {
		for(int i=1;i<clubs.size();i++) {
			Club toIterate = (Club) clubs.get(i);
			boolean finished =false;
			
			for(int j=i;j>0 && !finished;j--) {
				Club fromNow=(Club) clubs.get(j-1);
				if(fromNow.compareByDate(toIterate)>0) {
					clubs.set(j, fromNow);
					clubs.set(j-1, toIterate);
				}else {
					finished=true;
				}
			}
		}
	}
	//selection
	public void orderByIdClubs() {
		int init;
		for(init=0;init<clubs.size();init++) {
			int lesser=init;
			Club less = (Club)clubs.get(init);
			
			for(int i=init+1;i<clubs.size();i++) {
				Club f =(Club)clubs.get(i);
				if(f.getId()<less.getId()) {
					less=f;
					lesser=i;
				}
			}
			if(lesser!=init) {
				Club temp = (Club)clubs.get(init);
				clubs.set(init, less);
				clubs.set(lesser, temp);
			}
		}
	}
	// bubble
	public void orderByTypePetClubs() {
		for (int i = clubs.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Club c1 = (Club) clubs.get(j);
				Club c2 = (Club) clubs.get(j + 1);

				if (c1.compareByTypePet(c2) > 0) {
					clubs.set(j, c2);
					clubs.set(j + 1, c1);
				}
			}
		}
	}	
}
		