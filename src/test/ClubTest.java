package test;

import static org.junit.jupiter.api.Assertions.*;
import model.Club;
import model.Owner;
import model.OwnerRepeatedException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class ClubTest {
	
	Club doggos;
	
	void setUpScenery1(){
		doggos = new Club("Cali doggueros", "2019/11/10", 0, "solo perros");
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader("data"+File.separator+"owners.csv"));
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(cvsSplitBy);
                
                	int id = Integer.parseInt(lines[0]);
                	Owner p = new Owner(id, lines[1], lines[2], lines[3]);
                	doggos.getOwners().add(p);
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
	void testAddOwner(){
		setUpScenery1();
	     try{
	    	 setUpScenery1();
	         doggos.addOwner(16,"Marty","2019/03/29","Orange");
	         fail("no se lanzo la excepcion");
	      }
	      catch(OwnerRepeatedException ex){
	         assertEquals(ex.getMessage(),"ya existe un duenio con ese id");
	      }
	       catch(Exception ex){
	    	   fail("no era la excepcion esperada");
	       }
	}

	@Test
	void testSearchByName(){
		setUpScenery1();
		assertTrue(doggos.searchByName("Merell").getId()==15);
	}

	@Test
	void testSearchByDate() {
		setUpScenery1();
		assertTrue(doggos.searchByDate("2019/07/27").getFullName().equalsIgnoreCase("Brander"));
	}

	@Test
	void testSearchById() {
		setUpScenery1();
		doggos.orderById();
		assertTrue(doggos.getOwners().get(999).getFullName().equalsIgnoreCase("Elora"));
		assertTrue(doggos.getOwners().get(500).getFullName().equalsIgnoreCase("Farrah"));
		assertTrue(doggos.getOwners().get(0).getFullName().equalsIgnoreCase("Laurena"));
	}

	@Test
	void testSearchByTypeOfPet() {
		setUpScenery1();
		assertTrue(doggos.searchByTypeOfPet("orange").getFullName().equalsIgnoreCase("Ezekiel"));
	
	}

	@Test
	void testOrderByDate() {
		setUpScenery1();
		doggos.orderByDate();
		assertTrue(doggos.getOwners().get(999).getBirthdate().equalsIgnoreCase("2019/09/10"));
		assertTrue(doggos.getOwners().get(500).getBirthdate().equalsIgnoreCase("2019/03/10"));
		assertTrue(doggos.getOwners().get(0).getBirthdate().equalsIgnoreCase("2018/09/11"));
	}

	@Test
	void testOrderById() {
		setUpScenery1();
		doggos.orderById();
		assertTrue(doggos.getOwners().get(0).getId()==1);
		assertTrue(doggos.getOwners().get(500).getId()==501);
		assertTrue(doggos.getOwners().get(999).getId()==1000);
		
	}

	@Test
	void testOrderByTypePet() {
		setUpScenery1();
		doggos.orderByTypePet();
		assertTrue(doggos.getOwners().get(0).getId()==9);
		assertTrue(doggos.getOwners().get(500).getId()==274);
		assertTrue(doggos.getOwners().get(999).getId()==1000);
		
	}

	@Test
	void testOrderByNameOwners() {
		setUpScenery1();
		doggos.orderByNameOwners();
		assertTrue(doggos.getOwners().get(0).getBirthdate().equalsIgnoreCase("2019/05/09"));
		assertTrue(doggos.getOwners().get(500).getBirthdate().equalsIgnoreCase("2019/03/22"));
		assertTrue(doggos.getOwners().get(999).getBirthdate().equalsIgnoreCase("2019/08/13"));
	}

	@Test
	void testRemoveOwnerById() {
		setUpScenery1();
		doggos.removeOwnerById(16);
		assertTrue(doggos.searchByName("Marty")==null);
	}

}
