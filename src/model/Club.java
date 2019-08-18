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
 * Class that represents a club.
 *
 */
public class Club {
	
	/**
	 * the attributes of the class
	 */
	private String name, date, id, typePet;

	/**
	 * Constructor of the Club class.
	 * @param name - the club's name.
	 * @param date - the club's foundation date.
	 * @param id - the identification document for the club
	 * @param typePet - the type of pet that the club works with.
	 */
	public Club(String name, String date, String id, String typePet) {
		super();
		this.name = name;
		this.date = date;
		this.id = id;
		this.typePet = typePet;
	}
	
	
	
}
