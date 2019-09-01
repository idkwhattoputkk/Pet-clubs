package model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Pet implements Serializable{
	
	//attributes
	private String name, birthdate, gender, typePet;
	private int id;
	
	//methods
	public Pet(int id, String name, String birthdate, String gender, String typePet) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.typePet = typePet;
	}

	public int compareByName(Pet p) {
		int valueToComparate = name.compareToIgnoreCase(p.name);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	
	public int compareByDate(Pet p) {
		int valueToComparate = birthdate.compareToIgnoreCase(p.birthdate);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public int compareByTypePet(Pet p) {
		int valueToComparate = typePet.compareToIgnoreCase(p.typePet);
		if (valueToComparate < 0) {
			valueToComparate = -1;
		} else if (valueToComparate == 0) {
			valueToComparate = 0;
		} else {
			valueToComparate = 1;
		}
		return valueToComparate;
	}
	public int compareByGender(Pet p) {
		int valueToComparate = gender.compareToIgnoreCase(p.gender);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getTypePet() {
		return typePet;
	}

	public void setTypePet(String typePet) {
		this.typePet = typePet;
	} 
	@Override
	public String toString() {
		return "nombre: "+name+", fecha de nacimiento: "+birthdate+", genero: "+gender+", tipo de mascota: "+typePet;
		
	}

}
