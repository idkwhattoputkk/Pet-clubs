package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
@SuppressWarnings("serial")
public class Owner implements Serializable {
	
	//attributes
	private int id;
	private String fullName, birthdate, typePet;
	private ArrayList<Pet> pets;
	
	//methods
	public Owner(int id, String fullName, String birthdate, String typePet) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthdate = birthdate;
		this.typePet = typePet;
		pets = new ArrayList<>();
	}
	public void savePets(String h){		
		File file = new File(h);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (int i = 0; i < pets.size(); i++) {
				oos.writeObject(pets.get(i));
			}
			oos.close();
			}catch (IOException e) {
				e.printStackTrace();
		}
	}
	public String addPet(int id, String name, String birthdate, String gender, String typePet) throws PetRepeatedException {
		String msg="";
		for (int i = 0; i < pets.size(); i++) {
			if(pets.get(i).getName().equalsIgnoreCase(name)) {
				throw new PetRepeatedException("ya tiene una mascota con el mismo nombre ");
			}else {
				Pet p = new Pet(id,name, birthdate, gender, typePet);
				pets.add(p);
			}
		}
		return msg;
	}
	public String removePetById(int ido) {
		String msg="";
		pets.remove(searchById(ido));
		msg+="la mascota ha sido eliminado";
		return msg;	
	}
	public String removePetByName(String nem) {
		String msg="";
		pets.remove(searchByName(nem));
		msg+="la mascota ha sido eliminado";
		return msg;	
	}
	// *********************************************************************
	// *********************************************************************
	//
	// ordering the Pets array list and creating the search methods.
	//
	// *********************************************************************
	// *********************************************************************

	// sequential search
	public Pet searchByName(String name) {
		boolean ended=false;
		Pet toPaint=null;
		for(int i=0;i<pets.size() && !ended;i++) {
			if(pets.get(i).getName().equalsIgnoreCase(name)) {
				ended=true;
				toPaint =(Pet) pets.get(i);
				}
		}
		return toPaint;
	}
	// binary search
	public Pet searchByDate(String date) {
		orderByDate();
		int init=0;
		boolean ended = false;
		int end = pets.size()-1;
		Pet toSearch = new Pet(0,"", date, "","");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Pet mid = (Pet)pets.get(middle);
			if(mid.compareByDate(toSearch)==0) {
				toSearch=mid;
				ended=true;
			}else if(mid.compareByDate(toSearch)>0) {
				end = middle-1;
			}else {
				init= middle+1;
			}
		}
		return toSearch;
	}
	// binary search
	public Pet searchById(int id) {
		orderById();
		int init=0;
		boolean ended = false;
		int end = pets.size()-1;
		Pet toSearch = new Pet(id,"", "", "", "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Pet mid = (Pet)pets.get(middle);
			if(mid.getId()==toSearch.getId()) {
				toSearch=mid;
				ended=true;
			}else if(mid.getId()>toSearch.getId()) {
				end = middle-1;
			}else {
				init= middle+1;
			}
		}
		return toSearch;
	}
	// binary search
	public Pet searchByTypeOfPet(String tp) {
		orderById();
		int init=0;
		boolean ended = false;
		int end = pets.size()-1;
		Pet toSearch = new Pet(0,"", "", "", tp);
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Pet mid = (Pet)pets.get(middle);
			if(mid.compareByTypePet(toSearch)==0) {
				toSearch=mid;
				ended=true;
			}else if(mid.compareByTypePet(toSearch)>0) {
				end = middle-1;
			}else {
				init= middle+1;
			}
		}
		return toSearch;
	}
	public Pet searchByGender(String g) {
		orderByGender();
		int init=0;
		boolean ended = false;
		int end = pets.size()-1;
		Pet toSearch = new Pet(0,"", "", g, "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Pet mid = (Pet)pets.get(middle);
			if(mid.compareByGender(toSearch)==0) {
				toSearch=mid;
				ended=true;
			}else if(mid.compareByGender(toSearch)>0) {
				end = middle-1;
			}else {
				end= middle+1;
			}
		}
		return toSearch;
	}
		
	//insertion
	public void orderByDate() {
		for(int i=1;i<pets.size();i++) {
			Pet toIterate = (Pet) pets.get(i);
			boolean finished =false;
			
			for(int j=i;j>0 && !finished;j--) {
				Pet fromNow=(Pet) pets.get(j-1);
				if(fromNow.compareByDate(toIterate)>0) {
					pets.set(j, fromNow);
					pets.set(j-1, toIterate);
				}else {
					finished=true;
				}
			}
		}
	}
	//selection
	public void orderById() {
		int init;
		for(init=0;init<pets.size();init++) {
			int lesser=init;
			Pet less = (Pet)pets.get(init);
			
			for(int i=init+1;i<pets.size();i++) {
				Pet f =(Pet)pets.get(i);
				if(f.getId()<less.getId()) {
					less=f;
					lesser=i;
				}
			}
			if(lesser!=init) {
				Pet temp = (Pet)pets.get(init);
				pets.set(init, less);
				pets.set(lesser, temp);
			}
		}
	}
	// bubble
	public void orderByTypePet() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet c1 = (Pet) pets.get(j);
				Pet c2 = (Pet) pets.get(j + 1);

				if (c1.compareByTypePet(c2) > 0) {
					pets.set(j, c2);
					pets.set(j + 1, c1);
				}
			}
		}
	}
	// bubble
	public void orderByNamepets() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet c1 = (Pet) pets.get(j);
				Pet c2 = (Pet) pets.get(j + 1);

				if (c1.compareByName(c2) > 0) {
					pets.set(j, c2);
					pets.set(j + 1, c1);
				}
			}
		}
	}
	// bubble
	public void orderByGender() {
		for (int i = pets.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Pet c1 = (Pet) pets.get(j);
				Pet c2 = (Pet) pets.get(j + 1);

				if (c1.compareByGender(c2) > 0) {
					pets.set(j, c2);
					pets.set(j + 1, c1);
				}
			}
		}
	}
	public int compareByName(Owner o) {
		int valueToComparate = fullName.compareToIgnoreCase(o.fullName);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	
	public int compareByDate(Owner o) {
		int valueToComparate = birthdate.compareToIgnoreCase(o.birthdate);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public int compareByTypePet(Owner o) {
		int valueToComparate = typePet.compareToIgnoreCase(o.typePet);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getTypePet() {
		return typePet;
	}

	public void setTypePet(String typePet) {
		this.typePet = typePet;
	}

	public ArrayList<Pet> getPets() {
		return pets;
	}

	public void setPets(ArrayList<Pet> pets) {
		this.pets = pets;
	}
	@Override
	public String toString() {
		return id +","+ fullName+","+birthdate+","+typePet;
				
	}
	
	
}
