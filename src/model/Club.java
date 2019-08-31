package model;

import java.util.ArrayList;

public class Club {
	
	//attributes
	private String name, date, id, typePet;
	private ArrayList<Owner> owners;

	// methods
	public Club(String name, String date, String id, String typePet) {
		super();
		this.name = name;
		this.date = date;
		this.id = id;
		this.typePet = typePet;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
		return "id: "+id +", nombre: "+ name+", fecha creacion: "+date+", tipo de mascota: "+typePet;
				
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
	public int compareById(Club c) {
		int valueToComparate = id.compareToIgnoreCase(c.id);
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
	
	
}
