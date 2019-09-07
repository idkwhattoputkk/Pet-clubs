package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {
	//attributes
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
		File file = new File("data"+File.separator+"pets.txt");
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for(int i=0;i<clubs.size();i++) {
				oos.writeObject(clubs.get(i).getOwners().get(i).getPets().toString());
				oos.close();
			}
		} catch (IOException e) {
		}
				
	}
	public void saveOwners(){
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		File file = new File("data"+File.separator+"owners.txt");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for(int i=0;i<clubs.size();i++) {
				oos.writeObject(clubs.get(i).getOwners().toString());
				oos.close();
			}
		} catch (IOException e) {
		}
				
	}
	public void saveClubs() {
		File data = new File("data");
		if(!data.exists())
			data.mkdir();
		
		File f= new File("data"+File.separator+"clubs.txt");
		try {
			PrintWriter pr = new PrintWriter(f);
			clubs.forEach((c)-> pr.write(c.toString()));
			pr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
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
	public Club searchClubsId(int id) {
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
	public Club searchByTypePet(String typePet) {
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
		// ***********************************************************************
		// ***********************************************************************
		//
		// ordering the owners array list and creating the owners search methods
		//
		// ***********************************************************************
		// ***********************************************************************
		
		// sequential search
		public Owner searchByNameOwner(String name) {
			boolean ended=false;
			Owner toPaint=null;
			for(int i=0;i<clubs.size() && !ended;i++) {
				for(int j=0;j<clubs.get(i).getOwners().size();j++) {
					if(clubs.get(j).getOwners().get(j).getFullName().equalsIgnoreCase(name)) {
						ended=true;
						toPaint = (Owner)clubs.get(j).getOwners().get(j);
						}
				}
			}
			return toPaint;
		}
		
		// binary search
		public Owner searchOwnersId(int id) {
			orderByIdOwner();
			int init=0;
			boolean ended = false;
			Owner toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().size()-1;
				toSearch = new Owner(id,"", "", "");
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Owner mid = (Owner) clubs.get(i).getOwners().get(middle);
					if(toSearch.getId()==mid.getId()) {
						ended=true;
					}else if(toSearch.getId()<mid.getId()) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		// binary search
		public Owner searchOwnersBD(String BD) {
			orderByBDOwners();
			int init=0;
			boolean ended = false;
			Owner toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().size()-1;
				toSearch = new Owner(0,"", BD, "");
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Owner mid = (Owner) clubs.get(i).getOwners().get(middle);
					if(mid.compareByDate(toSearch)==0) {
						ended=true;
					}else if(mid.compareByDate(toSearch)>0) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		// binary search
		public Owner searchOwnersTypePet(String TypePet) {
			orderByTypePetOwners();
			int init=0;
			boolean ended = false;
			Owner toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().size()-1;
				toSearch = new Owner(0,"", "", TypePet);
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Owner mid = (Owner) clubs.get(i).getOwners().get(middle);
					if(mid.compareByTypePet(toSearch)==0) {
						ended=true;
					}else if(mid.compareByTypePet(toSearch)>0) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		
		// bubble
		public void orderByfullNameOwners() {
			for(int h=0;h<clubs.size();h++) {
			for (int i = clubs.get(h).getOwners().size(); i > 0; i--) {
				for (int j = 0; j < i - 1; j++) {
					Owner o1 = (Owner) clubs.get(h).getOwners().get(j);
					Owner o2 = (Owner) clubs.get(h).getOwners().get(j + 1);

					if (o1.compareByName(o2) > 0) {
						clubs.get(h).getOwners().set(j, o2);
						clubs.get(h).getOwners().set(j + 1, o1);
					}
				}
			}
		}
		}
		//insertion
		public void orderByBDOwners() {
			for(int h=0;h<clubs.size();h++) {
				for(int i=1;i<clubs.get(h).getOwners().size();i++) {
					Owner toIterate = (Owner) clubs.get(h).getOwners().get(i);
					boolean finished =false;
					
					for(int j=i;j>0 && !finished;j--) {
						Owner fromNow=(Owner) clubs.get(h).getOwners().get(j-1);
						if(fromNow.compareByDate(toIterate)>0) {
							clubs.get(h).getOwners().set(j, fromNow);
							clubs.get(h).getOwners().set(j-1, toIterate);
						}else {
							finished=true;
						}
					}
				}
			}
		}
		//selection
		public void orderByIdOwner() {
			for(int h=0;h<clubs.size();h++) {
				int init;
				for(init=0;init<clubs.get(h).getOwners().size();init++) {
					int lesser=init;
					Owner less = (Owner)clubs.get(h).getOwners().get(init);
					
					for(int i=init+1;i<clubs.get(h).getOwners().size();i++) {
						Owner f =(Owner)clubs.get(h).getOwners().get(i);
						if(f.getId()<less.getId()) {
							less=f;
							lesser=i;
						}
					}
					if(lesser!=init) {
						Owner temp = (Owner)clubs.get(h).getOwners().get(init);
						clubs.get(h).getOwners().set(init, less);
						clubs.get(h).getOwners().set(lesser, temp);
					}
				}
			}
		}
		// bubble
		public void orderByTypePetOwners() {
			for(int h=0;h<clubs.size();h++) {
			for (int i = clubs.get(h).getOwners().size(); i > 0; i--) {
				for (int j = 0; j < i - 1; j++) {
					Owner o1 = (Owner) clubs.get(h).getOwners().get(j);
					Owner o2 = (Owner) clubs.get(h).getOwners().get(j + 1);

					if (o1.compareByTypePet(o2) > 0) {
						clubs.get(h).getOwners().set(j, o2);
						clubs.get(h).getOwners().set(j + 1, o1);
						}
					}
				}
			}
		}
		
		// *********************************************************************
		// *********************************************************************
		//
		// ordering the Pets array list and creating the search methods for pets
		//
		// *********************************************************************
		// *********************************************************************
		
		// sequential search
		public Pet searchByNamePet(String name) {
			boolean ended=false;
			Pet toPaint=null;
			for(int i=0;i<clubs.size() && !ended;i++) {
				for(int j=0;j<clubs.get(i).getOwners().get(j).getPets().size();j++) {
					if(clubs.get(j).getOwners().get(j).getPets().get(j).getName().equalsIgnoreCase(name)) {
						ended=true;
						toPaint = (Pet)clubs.get(j).getOwners().get(j).getPets().get(j);
						}
				}
			}
			return toPaint;
		}
		// binary search
		public Pet searchPetId(int id) {
			orderByIdPets();
			int init=0;
			boolean ended = false;
			Pet toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().get(i).getPets().size()-1;
				toSearch = new Pet(id,"", "", "", "");
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Pet mid = (Pet) clubs.get(i).getOwners().get(i).getPets().get(middle);
					if(toSearch.getId()==mid.getId()) {
						ended=true;
					}else if(toSearch.getId()<mid.getId()) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		// binary search
		public Pet searchPetBD(String bd) {
			orderByBDPets();
			int init=0;
			boolean ended = false;
			Pet toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().get(i).getPets().size()-1;
				toSearch = new Pet(0,"", bd, "", "");
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Pet mid = (Pet) clubs.get(i).getOwners().get(i).getPets().get(middle);
					if(mid.compareByDate(toSearch)==0) {
						ended=true;
					}else if(mid.compareByDate(toSearch)>0) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		
		// binary search
		public Pet searchPetGender(String gender) {
			orderByGender();
			int init=0;
			boolean ended = false;
			Pet toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().get(i).getPets().size()-1;
				toSearch = new Pet(0,"", "", gender, "");
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Pet mid = (Pet) clubs.get(i).getOwners().get(i).getPets().get(middle);
					if(mid.compareByGender(toSearch)==0) {
						ended=true;
					}else if(mid.compareByGender(toSearch)>0) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		// binary search
		public Pet searchTypePet(String typeP) {
			orderByTypePetPets();
			int init=0;
			boolean ended = false;
			Pet toSearch = null;
			for(int i=0;i<clubs.size();i++) {
				int end = clubs.get(i).getOwners().get(i).getPets().size()-1;
				toSearch = new Pet(0,"", "", "", typeP);
				while(init<= end && !ended) {
					int middle=(init+end)/2;
					Pet mid = (Pet) clubs.get(i).getOwners().get(i).getPets().get(middle);
					if(mid.compareByTypePet(toSearch)==0) {
						ended=true;
					}else if(mid.compareByTypePet(toSearch)>0) {
						end = middle-1;
					}else {
						end= middle+1;
					}
				}
			}
			return toSearch;
		}
		
		//bubble
		public void orderByNamePets() {
			for(int h=0;h<clubs.size();h++) {
				for (int i = clubs.get(h).getOwners().get(h).getPets().size(); i > 0; i--) {
					for (int j = 0; j < i - 1; j++) {
						Pet o1 = (Pet) clubs.get(h).getOwners().get(h).getPets().get(j);
						Pet o2 = (Pet) clubs.get(h).getOwners().get(h).getPets().get(j + 1);
	
						if (o1.compareByName(o2) > 0) {
							clubs.get(h).getOwners().get(h).getPets().set(j, o2);
							clubs.get(h).getOwners().get(h).getPets().set(j + 1, o1);
						}
					}
				}
			}
		}
		//insertion
		public void orderByBDPets() {
			for(int h=0;h<clubs.size();h++) {
				for(int i=1;i<clubs.get(h).getOwners().get(h).getPets().size();i++) {
					Pet toIterate = (Pet) clubs.get(h).getOwners().get(h).getPets().get(i);
					boolean finished =false;
					
					for(int j=i;j>0 && !finished;j--) {
						Pet fromNow=(Pet) clubs.get(h).getOwners().get(h).getPets().get(j-1);
						if(fromNow.compareByDate(toIterate)>0) {
							clubs.get(h).getOwners().get(h).getPets().set(j, fromNow);
							clubs.get(h).getOwners().get(h).getPets().set(j-1, toIterate);
						}else {
							finished=true;
						}
					}
				}
			}
		}
		//selection
		public void orderByIdPets() {
			for(int h=0;h<clubs.size();h++) {
				int init;
				for(init=0;init<clubs.get(h).getOwners().get(h).getPets().size();init++) {
					int lesser=init;
					Pet less = (Pet)clubs.get(h).getOwners().get(h).getPets().get(init);
					
					for(int i=init+1;i<clubs.get(h).getOwners().get(h).getPets().size();i++) {
						Pet f =(Pet)clubs.get(h).getOwners().get(h).getPets().get(i);
						if(f.getId()<less.getId()) {
							less=f;
							lesser=i;
						}
					}
					if(lesser!=init) {
						Pet temp = (Pet)clubs.get(h).getOwners().get(h).getPets().get(init);
						clubs.get(h).getOwners().get(h).getPets().set(init, less);
						clubs.get(h).getOwners().get(h).getPets().set(lesser, temp);
					}
				}
			}
		}
		//bubble
		public void orderByTypePetPets() {
			for(int h=0;h<clubs.size();h++) {
				for (int i = clubs.get(h).getOwners().get(h).getPets().size(); i > 0; i--) {
					for (int j = 0; j < i - 1; j++) {
						Pet o1 = (Pet) clubs.get(h).getOwners().get(h).getPets().get(j);
						Pet o2 = (Pet) clubs.get(h).getOwners().get(h).getPets().get(j + 1);
	
						if (o1.compareByTypePet(o2) > 0) {
							clubs.get(h).getOwners().get(h).getPets().set(j, o2);
							clubs.get(h).getOwners().get(h).getPets().set(j + 1, o1);
						}
					}
				}
			}
		}
		//bubble
		public void orderByGender() {
			for(int h=0;h<clubs.size();h++) {
				for (int i = clubs.get(h).getOwners().get(h).getPets().size(); i > 0; i--) {
					for (int j = 0; j < i - 1; j++) {
						Pet o1 = (Pet) clubs.get(h).getOwners().get(h).getPets().get(j);
						Pet o2 = (Pet) clubs.get(h).getOwners().get(h).getPets().get(j + 1);
	
						if (o1.compareByGender(o2) > 0) {
							clubs.get(h).getOwners().get(h).getPets().set(j, o2);
							clubs.get(h).getOwners().get(h).getPets().set(j + 1, o1);
						}
					}
				}
			}
		}
		
		

}
