package model;

import java.io.Serializable;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class Owner implements Serializable {
	
	//attributes
	private String id, fullName, birthdate, typePet;
	private ArrayList<Pet> pets;
	
	//methods
	public Owner(String id, String fullName, String birthdate, String typePet) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthdate = birthdate;
		this.typePet = typePet;
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
	public int compareById(Owner o) {
		int valueToComparate = id.compareToIgnoreCase(o.id);
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
	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "id: "+id +", nombre: "+ fullName+", fecha de nacimiento: "+birthdate+", tipo de mascota: "+typePet;
				
	}
	
	
}
