package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Club;
import model.Controller;
import org.junit.jupiter.api.Test;

class ControllerTest {
	Controller control;
	
	void setUpScenary1(){
		control = new Controller();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader("data"+File.separator+"clubs.cvs");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] parts = sCurrentLine.split(",");
				for (int j = 0; j < parts.length; j++) {
					int id = Integer.parseInt(parts[0]);
					Club c= new Club(parts[1], parts[2], id, parts[3]);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Test
	void testAddClub() {
		
	}

	@Test
	void testSearchByName() {
		
	}

	@Test
	void testSearchByDate() {
		
	}

	@Test
	void testSearchById() {
		
	}

	@Test
	void testSearchByTypePetClubs() {
		
	}

	@Test
	void testOrderByNameClubs() {
		
	}

	@Test
	void testOrderByDateClubs() {
		
	}

	@Test
	void testOrderByIdClubs() {
		
	}

	@Test
	void testOrderByTypePetClubs() {
		
	}

	@Test
	void testRemoveClubById() {
		
	}

}
