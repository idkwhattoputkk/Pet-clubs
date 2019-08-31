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
	public final static String CLUB_PATH="./data" + File.separator + "club.txt";
	public final static String OWNER_PATH="./data" + File.separator + "owner.txt";
	public final static String PET_PATH="./data" + File.separator + "pets.txt";
	private ArrayList<Club> clubs;
	
	//methods
	
	public Controller() {
		
	}
	public void saveAll() throws FileNotFoundException, IOException {
		saveOwners(OWNER_PATH);
		saveClubs(CLUB_PATH);
		savePets(PET_PATH);
	}
	private void savePets(String h) throws FileNotFoundException, IOException {
		File file = new File(h);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		for(int i=0;i<clubs.size();i++) {
			oos.writeObject(clubs.get(i).getOwners().get(i).getPets().toString());
			oos.close();
		}		
	}
	private void saveOwners(String h) throws FileNotFoundException, IOException{
		File file = new File(h);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		for(int i=0;i<clubs.size();i++) {
			oos.writeObject(clubs.get(i).getOwners().toString());
			oos.close();
		}		
	}
	public void saveClubs(String info) throws FileNotFoundException {
		File f= new File(info);
		PrintWriter pr = new PrintWriter(f);
		for(Club c: clubs) {
			pr.println(c.toString());
		}
		pr.close();
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
				}
		}
		return toPaint;
	}
	// binary search
	public void searchBYTime(String date) {
		orderByIdClubs();
		int init=0;
		boolean ended = false;
		int end = clubs.size()-1;
		Club toSearch = new Club("",date, "", "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Club mid = (Club)clubs.get(middle);
			if(mid.compareById(toSearch)==0) {
				ended=true;
			}else if(mid.compareById(toSearch)>0) {
				end = middle-1;
			}else {
				end= middle+1;
			}
		}
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
				if(f.compareByDate(less)<0) {
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
						if(f.compareById(less)<0) {
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
						if(f.compareById(less)<0) {
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
