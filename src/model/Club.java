package model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Club {
	
	//attributes
	private String name, date, typePet;
	private int id;
	private ArrayList<Owner> owners;

	// methods
	public Club(String name, String date, int id, String typePet) {
		super();
		this.name = name;
		this.date = date;
		this.id = id;
		this.typePet = typePet;
		owners = new ArrayList<Owner>();
	}
	public void saveOwners(String h){
		File file = new File(h);
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			for (int i = 0; i < owners.size(); i++) {
				oos.writeObject(owners.get(i));
			}
			oos.close();
			}catch (IOException e) {
				e.printStackTrace();
		}
				
	}
	public void savePets(String h){
		for (int i = 0; i < owners.size(); i++) {
			owners.get(i).savePets(h);
		}
	}
	public void addOwner(int id, String fullName, String birthdate, String typePet) throws OwnerRepeatedException{
		Owner o = new Owner(id, fullName, birthdate, typePet);
		for (int h = 0; h < owners.size(); h++) {
			if(owners.get(h).getId()==id) {
				throw new OwnerRepeatedException("ya existe un duenio con ese id");
			}
			else {
				owners.add(o);
			}
		}
	}
	// *********************************************************************
	// *********************************************************************
	//
	// ordering the owners array list and creating the search methods.
	//
	// *********************************************************************
	// *********************************************************************

	// sequential search
	public Owner searchByName(String name) {
		boolean ended=false;
		Owner toPaint=null;
		for(int i=0;i<owners.size() && !ended;i++) {
			if(owners.get(i).getFullName().equalsIgnoreCase(name)) {
				ended=true;
				toPaint =(Owner) owners.get(i);
				}
		}
		return toPaint;
	}
	// binary search
	public Owner searchByDate(String date) {
		orderByDate();
		int init=0;
		boolean ended = false;
		int end = owners.size()-1;
		Owner toSearch = new Owner(0,"", date, "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Owner mid = (Owner)owners.get(middle);
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
	public Owner searchById(int id) {
		orderById();
		int init=0;
		boolean ended = false;
		int end = owners.size()-1;
		Owner toSearch = new Owner(id,"", "", "");
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Owner mid = (Owner)owners.get(middle);
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
	public Owner searchByTypeOfPet(String tp) {
		orderById();
		int init=0;
		boolean ended = false;
		int end = owners.size()-1;
		Owner toSearch = new Owner(0,"", "", tp);
		while(init<= end && !ended) {
			int middle=(init+end)/2;
			Owner mid = (Owner)owners.get(middle);
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
	public String searchByNamePet(String name) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < owners.size()&&!flag; i++) {
			s+=owners.get(i).searchByName(name);
			flag=true;
		}
		return s;
	}
	public String searchByIdPet(int id) {
		String s= "";
		for (int i = 0; i < owners.size(); i++) {
			s+=owners.get(i).searchById(id).toString();
		}
		return s;
	}
	public String searchByDatePet(String d) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < owners.size()&&!flag; i++) {
			s+=owners.get(i).searchByDate(d).toString();
		}
		return s;
	}
	public String searchBytypePet(String d) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < owners.size()&&!flag; i++) {
			s+=owners.get(i).searchByTypeOfPet(d).toString();
		}
		return s;
	}
	public String searchByGenderPet(String g) {
		String s= "";
		boolean flag =false;
		for (int i = 0; i < owners.size()&&!flag; i++) {
			s+=owners.get(i).searchByGender(g).toString();
		}
		return s;
	}
	public void orderByDate() {
		int init;
		for(init=0;init<owners.size();init++) {
			int lesser=init;
			Owner less = (Owner)owners.get(init);
			
			for(int i=init+1;i<owners.size();i++) {
				Owner f =(Owner)owners.get(i);
				if(f.compareByDate(less)<0) {
					less=f;
					lesser=i;
				}
			}
			if(lesser!=init) {
				Owner temp = (Owner)owners.get(init);
				owners.set(init, less);
				owners.set(lesser, temp);
			}
		}
	}
	//selection
	public void orderById() {
		int init;
		for(init=0;init<owners.size();init++) {
			int lesser=init;
			Owner less = (Owner)owners.get(init);
			
			for(int i=init+1;i<owners.size();i++) {
				Owner f =(Owner)owners.get(i);
				if(f.getId()<less.getId()) {
					less=f;
					lesser=i;
				}
			}
			if(lesser!=init) {
				Owner temp = (Owner)owners.get(init);
				owners.set(init, less);
				owners.set(lesser, temp);
			}
		}
	}
	// bubble
	public void orderByTypePet() {
		for (int i = owners.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Owner c1 = (Owner) owners.get(j);
				Owner c2 = (Owner) owners.get(j + 1);

				if (c1.compareByTypePet(c2) > 0) {
					owners.set(j, c2);
					owners.set(j + 1, c1);
				}
			}
		}
	}
	// bubble
	public void orderByNameOwners() {
		for (int i = owners.size(); i > 0; i--) {
			for (int j = 0; j < i - 1; j++) {
				Owner c1 = (Owner) owners.get(j);
				Owner c2 = (Owner) owners.get(j + 1);

				if (c1.compareByName(c2) > 0) {
					owners.set(j, c2);
					owners.set(j + 1, c1);
				}
			}
		}
	}
	public String removeOwnerById(int ido) {
		String msg="";
		owners.remove(searchById(ido));
		msg+="el duenio ha sido eliminado";
		return msg;	
	}
	public String removeOwnerByName(String n) {
		String msg="";
		owners.remove(searchByName(n));
		msg+="el duenio ha sido eliminado";
		return msg;	
	}
	public int compareByName(Club c) {
		int valueToComparate = name.compareToIgnoreCase(c.name);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	
	public int compareByDate(Club c) {
		int valueToComparate = date.compareToIgnoreCase(c.date);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public int compareByTypePet(Club c) {
		int valueToComparate = typePet.compareToIgnoreCase(c.typePet);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypePet() {
		return typePet;
	}

	public void setTypePet(String typePet) {
		this.typePet = typePet;
	}

	public ArrayList<Owner> getOwners() {
		return owners;
	}

	public void setOwners(ArrayList<Owner> owners) {
		this.owners = owners;
	}
	@Override
	public String toString() {
		return id +","+name+","+date+","+typePet;
				
	}
	
	
}
