/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * A00351911
 * Universidad Icesi (Cali - Colombia)
 * Pet-Clubs
 * @author emanuelumana
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package model;

/**
 * Class that represents a pet.
 *
 */
public class Pet {
	
	/**
	 * the class's attributes.
	 */
	private String id, name, birthdate, gender, typePet;

	/**
	 * Constructor of the pet's class.
	 * @param id - the pet's identification document.
	 * @param name - the pet's name.
	 * @param birthdate - the pet's birth date.
	 * @param gender - the pet's gender.
	 * @param typePet - the pet's type. 
	 */
	public Pet(String id, String name, String birthdate, String gender, String typePet) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.typePet = typePet;
	} 
	
	

}
