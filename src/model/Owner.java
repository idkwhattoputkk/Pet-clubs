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
 * Class that represents the owner of a pet.
 * @author emanuelumana
 */
public class Owner {
	
	/**
	 * the attributes of the class
	 */
	private String id, fullName, birthdate, typePet;
	
	/**
	 * Constructor of the owner class.
	 * @param id - the identification document.
	 * @param fullName - the name of the owner.
	 * @param birthdate - the owner's birth date.
	 * @param typePet - the type of pet that the owner likes. 
	 */
	public Owner(String id, String fullName, String birthdate, String typePet) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthdate = birthdate;
		this.typePet = typePet;
	}
	
	
}
