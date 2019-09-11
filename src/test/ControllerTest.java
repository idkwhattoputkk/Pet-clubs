package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Club;
import model.Controller;
import model.Owner;

import org.junit.jupiter.api.Test;

class ControllerTest {
	Controller control;
	
	void setUpScenery1(){
		control = new Controller();
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader("data"+File.separator+"clubs.csv"));
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(cvsSplitBy);
                
                	int id = Integer.parseInt(lines[0]);
                	control.addClub(lines[1], lines[2], id, lines[3]);
            }
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        }finally {
			try {
				if (br != null)
					br.close();

			} catch (IOException ex) {
				ex.printStackTrace();
			}

        }
	}

	@Test
	void testAddClub() {
		setUpScenery1();
		assertTrue(control.addClub("Cali doggueros", "2019/11/10", 0, "solo perros").equalsIgnoreCase(" se anadio corretcamente"));
	}

	@Test
	void testSearchByName() {
		setUpScenery1();
		assertTrue(control.searchByName("Chaddy").getDate().equalsIgnoreCase("2019/06/23"));
		assertTrue(control.searchByName("Millard").getDate().equalsIgnoreCase("2019/01/01"));
		assertTrue(control.searchByName("Brennan").getDate().equalsIgnoreCase("2019/07/27"));
	}

	@Test
	void testSearchByDate() {
		setUpScenery1();
		assertTrue(control.searchByDate("2019/06/23").getName().equalsIgnoreCase("Whitby"));
		assertTrue(control.searchByDate("2019/01/01").getName().equalsIgnoreCase("Kelila"));
		assertTrue(control.searchByDate("2019/09/10").getName().equalsIgnoreCase("Adrian"));
		
	}
	@Test
	void testSearchById() {
		setUpScenery1();
		assertTrue(control.searchById(1).getName().equalsIgnoreCase("Diannne"));
		assertTrue(control.searchById(500).getName().equalsIgnoreCase("Norris"));
		assertFalse(control.searchById(999).getName().equalsIgnoreCase("Brennan"));
	}

	@Test
	void testSearchByTypePetClubs() {
		setUpScenery1();
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
