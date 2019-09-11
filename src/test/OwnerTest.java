package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Owner;
import org.junit.jupiter.api.Test;

class OwnerTest {

	Owner o;
	
	void setUpScenary1(){
		o = new Owner(0, "yonier", "10/10/2019", "gatos");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader("data"+File.separator+"pets.cvs");
			br = new BufferedReader(fr);

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				String[] parts = sCurrentLine.split(",");
				for (int j = 0; j < parts.length; j++) {
					int id = Integer.parseInt(parts[0]);
					
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
	void testAddPet() {
		     
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
	void testSearchByTypeOfPet() {
		     
	}

	@Test
	void testSearchByGender() {
		     
	}

	@Test
	void testOrderByDate() {
		     
	}

	@Test
	void testOrderById() {
		     
	}

	@Test
	void testOrderByTypePet() {
		     
	}

	@Test
	void testOrderByNamepets() {
		     
	}

	@Test
	void testOrderByGender() {
		     
	}

}
