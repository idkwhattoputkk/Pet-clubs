package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
	public String addClub(String n, String d, int id, String t) {
		String msg="";
		Club c = new Club(n, d, id, t);
		clubs.add(c);
		msg+="el club "+c.toString()+" se anadio corretcamente";
		return msg;
	}
	//adding a new owner
	public String addOwner(int ide, int id, String fullName, String birthdate, String typePet){
		String msg="el duenio se anadio correctamente";
		try {
			searchById(ide).addOwner(id, fullName, birthdate, typePet);;
		}catch(OwnerRepeatedException e){
			msg=e.getMessage();
		}
		return msg;
	}
	//adding a new pet
	public String addPet(int idC,int idO,int id, String name, String birthdate, String gender, String typePet) {
		String msg="la mascota se anadio con exito";
		try {
			searchById(idC).searchById(idO).addPet(id, name, birthdate, gender, typePet);
		}catch(PetRepeatedException e) {
			msg=e.getMessage();
		}
		return msg;
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
			clubs.forEach((c)-> pr.write(c.toString()+"\n"));
			pr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	public String searchByNameOwner(String name) {
		String s= "";
		for (int i = 0; i < clubs.size(); i++) {
			s+=clubs.get(i).searchByName(name).toString();
		}
		return s;
	}
	public String searchByIdOwner(int id) {
		String msg="";
		for (int i = 0; i < clubs.size(); i++) {
			msg+=clubs.get(i).searchById(id).toString();
		}
		return msg;
	}
	public String searchByDateOwner(String date) {
		String msg="";
		for (int i = 0; i < clubs.size(); i++) {
			msg+=clubs.get(i).searchByDate(date).toString();
		}
		return msg;
	}
	public String searchByTypePetOwner(String tp) {
		String msg="";
		for (int i = 0; i < clubs.size(); i++) {
			msg+=clubs.get(i).searchByTypeOfPet(tp);
		}
		return msg;
	}
	public String searchByNamePet(String name) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < clubs.size()&&!flag; i++) {
			s+=clubs.get(i).searchByNamePet(name);
			flag=true;
		}
		return s;
	}
	public String searchByIdPet(int id) {
		String s= "";
		for (int i = 0; i < clubs.size(); i++) {
			s+=clubs.get(i).searchByIdPet(id).toString();
		}
		return s;
	}
	public String searchByDatePet(String d) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < clubs.size()&&!flag; i++) {
			s+=clubs.get(i).searchByDatePet(d).toString();
		}
		return s;
	}
	public String searchBytypePet(String d) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < clubs.size()&&!flag; i++) {
			s+=clubs.get(i).searchByTypeOfPet(d).toString();
		}
		return s;
	}
	public String searchByGenderPet(String g) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < clubs.size()&&!flag; i++) {
			s+=clubs.get(i).searchByGenderPet(g).toString();
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
	public Club searchById(int id) {
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
	public String removeClubById(int ido) {
		String msg="";
		clubs.remove(searchById(ido));
		msg+="el club ha sido eliminado";
		return msg;	
	}
	public String removeClubByName(String n) {
		String msg="";
		clubs.remove(searchByName(n));
		msg+="el club ha sido eliminado";
		return msg;	
	}
}
		