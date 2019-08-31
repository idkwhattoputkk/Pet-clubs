package model;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Pet implements Serializable{
	
	//attributes
	private String id, name, birthdate, gender, typePet;
	
	//methods
	public Pet(String id, String name, String birthdate, String gender, String typePet) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.typePet = typePet;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
