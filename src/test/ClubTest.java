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
	
	void setUpScenary1() throws OwnerRepeatedException{
		doggos = new Club("Cali doggueros", "10/110/2019", 0, "solo perros");
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
	void testAddOwner() throws OwnerRepeatedException {
		setUpScenary1();
	     try{
	    	 setUpScenary1();
	         doggos.addOwner(311,"Brunhilde","9/2/2018","Orange");
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
		try {
		setUpScenary1();
		assertTrue(doggos.searchByName("Winnie").getId()==814);
		} catch (OwnerRepeatedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testSearchByDate() {
		try {
			setUpScenary1();
//			assertTrue(doggos.searchByDate("17/01/2018").getFullName().equalsIgnoreCase("Edita"));
			doggos.orderByDate();
		} catch (OwnerRepeatedException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testSearchById() {
		
	}

	@Test
	void testSearchByTypeOfPet() {
		
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
	void testOrderByNameOwners() {
		
	}

	@Test
	void testRemoveOwnerById() {
		
	}

}
