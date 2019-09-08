package ui;
import java.io.File;
import java.util.Scanner;

import model.*;


public class Main {
	private Controller control;
	private Scanner reader;

	public Main() {
		reader = new Scanner(System.in);
		showWelcoming();
		control = new Controller();
		appManagement();
		}
	private void appManagement() {
		boolean out = false;

		while (!out) {
			
			int valorUsuario = appMenuPrincipal();
			switch(valorUsuario) {
			case 1:
				System.out.println("por favor digite el nombre");
				String n = reader.nextLine();
				System.out.println("por favor digite el id");
				int id = Integer.parseInt(reader.nextLine());
				System.out.println("por favor digite la fecha de creacion");
				String d = reader.nextLine();
				System.out.println("por favor digite tipo de mascota");
				String t = reader.nextLine();
				String msg =control.addClub(n, d, id, t);
				System.out.println(msg);
				break;
			case 2:
				System.out.println("por favor digite el id del club");
				int aidi = Integer.parseInt(reader.nextLine());
				System.out.println("por favor digite el nombre");
				String na = reader.nextLine();
				System.out.println("por favor digite el id");
				int ide = Integer.parseInt(reader.nextLine());
				System.out.println("por favor digite la fecha de nacimiento");
				String da = reader.nextLine();
				System.out.println("por favor digite tipo de mascota");
				String ti = reader.nextLine();
				String msj = control.addOwner(aidi, ide, na, da, ti);
				System.out.println(msj);
				break;
			case 3:
				
				break;
			case 4:
				control.saveClubs();
				break;
			case 5:
				control.saveOwners();
				break;
			case 6:
				control.savePets();
				break;
			case 7:
				System.out.println("digite la identificacion del club a eliminar");
				int ido = Integer.parseInt(reader.nextLine());
				control.removeClubById(ido);
				break;
			case 8:
				System.out.println("digite la identificacion del club al que pertenece el duenio");
				int toRemove = Integer.parseInt(reader.nextLine());
				System.out.println("digite la identificacion del duenio");
				int o = Integer.parseInt(reader.nextLine());
				control.searchById(toRemove).removeOwnerById(o);
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 12:
				control.orderByIdClubs();
				for (int i = 0; i < control.getClubs().size(); i++) {
					System.out.println(control.getClubs().get(i).toString());
				}
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
	public int appMenuPrincipal(){
		int valor=0;
		System.out.println("Que deseas hacer ?");
		System.out.println("1. aniadir un club");
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
		valor = Integer.parseInt(reader.nextLine());
		return valor;		
	}
	public static void main(String[] args) {
			Main m = new Main();

	}
	
}
