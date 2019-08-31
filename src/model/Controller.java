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
}
