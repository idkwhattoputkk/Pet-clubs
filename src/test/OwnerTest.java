package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import model.Owner;
import model.Pet;
import model.PetRepeatedException;

import org.junit.jupiter.api.Test;

class OwnerTest {

	Owner o;
	
	void setUpScenery1(){
		o = new Owner(0, "yonier", "10/10/2019", "gatos");
		BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader("data"+File.separator+"pets.csv"));
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(cvsSplitBy);
                
                	int id = Integer.parseInt(lines[0]);
                	Pet p = new Pet(id, lines[1],lines[2],lines[3],lines[4]);
                	o.getPets().add(p);
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
	void testAddPet() {
	     setUpScenery1();
	     try {
			o.addPet(20,"Elroy","6/22/2018","Male","Khaki");
			fail("la excepcion no se lanzo");
		} catch (PetRepeatedException e) {
			assertEquals(e.getMessage(),"ya tiene una mascota con el mismo nombre ");
		}
	     
	}

	@Test
	void testSearchByName() {
		setUpScenery1();
		assertEquals(o.searchByName("Mercedes").getId(),761);
		assertEquals(o.searchByName("Trixi").getId(),760);
		assertEquals(o.searchByName("Kermy").getId(),773);
	}

	@Test
	void testSearchByDate() {
		setUpScenery1();
		assertEquals(o.searchByDate("6/19/2018").getId(),604);
		assertEquals(o.searchByDate("9/29/2018").getId(),748);
		assertEquals(o.searchByDate("4/5/2018").getId(),766);
	}

	@Test
	void testSearchById() {
		setUpScenery1();
		assertEquals(o.searchById(1).getName(), "Bernelle");
		assertEquals(o.searchById(500).getName(), "Jemmy");
		assertEquals(o.searchById(1000).getName(), "Merralee");
	}

	@Test
	void testSearchByTypeOfPet() {
		setUpScenery1();
		assertEquals(o.searchByTypeOfPet("Turquoise").getId(), 812);
		assertEquals(o.searchByTypeOfPet("Yellow").getId(), 985);
		assertEquals(o.searchByTypeOfPet("Red").getId(), 500);
	}

	@Test
	void testSearchByGender() {
		setUpScenery1();
		assertEquals(o.searchByGender("Male").getId(), 16);
		assertEquals(o.searchByGender("Female").getName(), "Amata");
		assertEquals(o.searchByGender("Female").getBirthdate(),"8/4/2018");
	}

	@Test
	void testOrderByDate() {
		setUpScenery1();
		o.orderByDate();
		assertEquals(o.getPets().get(0).getBirthdate(),"1/1/2018");
		assertEquals(o.getPets().get(499).getBirthdate(),"4/2/2018");
		assertEquals(o.getPets().get(999).getBirthdate(),"9/9/2018");
	}

	@Test
	void testOrderById() {
		setUpScenery1();
		o.orderById();
		assertEquals(o.getPets().get(0).getId(),1);
		assertEquals(o.getPets().get(499).getId(),500);
		assertEquals(o.getPets().get(999).getId(), 1000);
	}

	@Test
	void testOrderByTypePet() {
		setUpScenery1();
		o.orderByTypePet();  
		assertEquals(o.getPets().get(0).getTypePet(),"Aquamarine");
		assertEquals(o.getPets().get(499).getTypePet(),"Mauv");
		assertEquals(o.getPets().get(999).getTypePet(), "Yellow");
	}

	@Test
	void testOrderByNamepets() {
		setUpScenery1();
		o.orderByNamepets();
		assertEquals(o.getPets().get(0).getName(),"Abagael");
		assertEquals(o.getPets().get(499).getName(),"Jaquith");
		assertEquals(o.getPets().get(999).getName(), "Zuzana");
	}

	@Test
	void testOrderByGender() {
		setUpScenery1();
		o.orderByGender();
		assertEquals(o.getPets().get(0).getGender(),"Female");
		assertEquals(o.getPets().get(499).getGender(),"Male");
		assertEquals(o.getPets().get(999).getGender(),"Male");
	}

}
