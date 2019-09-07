package ui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.*;


public class Main {
	private static final String PATH="/data/MOCK_DATA.csv";
	private Controller control;
	private BufferedReader br;

	public Main() {
		br = new BufferedReader(new InputStreamReader(System.in));
		showWelcoming();
		control = new Controller();
		appManagement();
		}
	private void appManagement() {
		boolean out = false;

		while (!out) {
			
			int valorUsuario = appMenu();
			switch(valorUsuario) {
			case 1:
				try {
					System.out.println("por favor digite el nombre");
					String n = br.readLine();
					System.out.println("por favor digite el id");
					int id = Integer.parseInt(br.readLine());
					System.out.println("por favor digite la fecha de creacion");
					String d = br.readLine();
					System.out.println("por favor digite tipo de mascota");
					String t = br.readLine();
					Club e = new Club(n, d, id, t);
					control.getClubs().add(e);
				} catch (NumberFormatException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Digite el codigo el club para registrar el duenio");
					int i1=Integer.parseInt(br.readLine());
					System.out.println("por favor digite el nombre");
					String n = br.readLine();
					System.out.println("por favor digite el id");
					int id = Integer.parseInt(br.readLine());
					System.out.println("por favor digite la fecha de nacimiento");
					String d = br.readLine();
					System.out.println("por favor digite tipo de mascota");
					String t = br.readLine();
					Owner o = new Owner(id, n, d, t);
					control.searchClubsId(i1).getOwners().add(o);
				}catch(NumberFormatException | IOException | NullPointerException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println("Digite el codigo el club para registrar el duenio");
					int i1=Integer.parseInt(br.readLine());
					System.out.println("por favor digite el nombre");
					String n = br.readLine();
					System.out.println("por favor digite el id");
					int id = Integer.parseInt(br.readLine());
					System.out.println("por favor digite la fecha de nacimiento");
					String d = br.readLine();
					System.out.println("por favor digite tipo de mascota");
					String t = br.readLine();
					Owner o = new Owner(id, n, d, t);
					control.searchClubsId(i1).getOwners().add(o);
				}catch(NumberFormatException | IOException | NullPointerException e) {
				System.out.println(e.getMessage());
			}
				break;
			case 4:
					control.saveClubs();
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				try {
					System.out.println("digite la identificacion del club a eliminar");
					int id = Integer.parseInt(br.readLine());
					control.getClubs().remove(control.searchClubsId(id));
				}catch(NumberFormatException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8:
				try {
					System.out.println("digite la identificacion del club ");
					int id = Integer.parseInt(br.readLine());
					System.out.println("digite la identificacion del duenio a eliminar");
					int id2 = Integer.parseInt(br.readLine());
					boolean end = false;
					for (int index=0;index<control.getClubs().size();index++) {
						Owner o= control.searchOwnersId(id2);
						if(control.getClubs().get(index).getOwners().equals(o)&&end==false) {
							control.getClubs().get(index).getOwners().remove(o);
							end = true;
						}	
					}
				}catch(NumberFormatException | IOException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				control.orderByIdClubs();
				control.getClubs().forEach(System.out::println);
				break;
			case 13:
				break;
			case 14:
				break;
			case 15:
				break;
			case 16:
				break;
			case 17:
				break;
			case 18:
				break;
			case 19:
				break;
			case 20:
				break;
			case 21:
				break;
			case 22:
				break;
			case 23:
				break;
			case 24:
				out =true;
				break;
			}
		}
		
	}
	public void showWelcoming() {

		String mensaje = "";

		mensaje += "******************************************************************\n";
		mensaje += "****************** BIENVENIDO AL PET CLUBS  **********************\n";
		mensaje += "*************** Desarrollado por: Emmanuel Umana *****************\n";
		mensaje += "******************        A00351911         **********************\n";
		mensaje += "********************** Universidad Icesi  ************************\n";
		mensaje += "******************************************************************\n";
		System.out.println(mensaje);
	}
	public int appMenu(){
		System.out.println("Que deseas hacer ?");
		System.out.println("1. aniadir un club?");
		System.out.println("2. aniadir un duenio ");
		System.out.println("3. aniadir una mascota ");
		System.out.println("4. guardar clubes");
		System.out.println("5. guardar duenios");
		System.out.println("6. guardar mascotas");
		System.out.println("7. eliminar un club");
		System.out.println("8. eliminar un duenio");
		System.out.println("9. eliminar un club");
		System.out.println("10. ordenar club por fecha de creacion");
		System.out.println("11. ordenar club por nombre");
		System.out.println("12. ordenar club por id");
		System.out.println("13. ordenar club por tipo de mascota");
		System.out.println("14. ordenar duenios por nombre");
		System.out.println("15. ordenar duenios por id");
		System.out.println("17. ordenar duenios por fecha de nacimiento");
		System.out.println("18. ordenar duenios por tipo de mascota");
		System.out.println("19. ordenar mascotas por nombre");
		System.out.println("20. ordenar mascotas por id");
		System.out.println("21. ordenar mascotas por genero");
		System.out.println("22. ordenar mascotas por tipo de mascota");
		System.out.println("23. ordenar mascotas por fecha");
		System.out.println("24. Salir ");

		int valor=0;
		try {
			valor = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println(e.getMessage());
		}
		return valor;		
	}
	public static void main(String[] args) {
			Main m = new Main();

	}
	
}
