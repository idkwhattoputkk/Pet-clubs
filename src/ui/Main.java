package ui;
import java.io.File;
import java.util.Scanner;

import model.*;


public class Main {
	private Controller control;
	private Scanner reader;
	private long tInicial;

	public Main() {
		reader = new Scanner(System.in);
		showWelcoming();
		control = new Controller();
		appManagement();
		tInicial = System.currentTimeMillis();
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
				System.out.println("por favor digite el id del club");
				int aidi1 = Integer.parseInt(reader.nextLine());
				System.out.println("por favor digite el id del duenio");
				int aidi11 = Integer.parseInt(reader.nextLine());
				System.out.println("por favor digite el nombre");
				String na1 = reader.nextLine();
				System.out.println("por favor digite el id");
				int ide1 = Integer.parseInt(reader.nextLine());
				System.out.println("por favor digite la fecha de nacimiento");
				String da1 = reader.nextLine();
				System.out.println("por favor digite tipo de mascota");
				String ti1 = reader.nextLine();
				System.out.println("por favor digite el genero de la mascota");
				String gender = reader.nextLine();
				String msj1 = control.addPet(aidi1, aidi11, ide1, na1, da1, gender, ti1);
				System.out.println(msj1);
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
				String msgj= control.removeClubById(ido);
				System.out.println(msgj);
				break;
			case 8:
				System.out.println("digite la identificacion del club al que pertenece el duenio");
				int toRemove = Integer.parseInt(reader.nextLine());
				System.out.println("digite la identificacion del duenio");
				int o = Integer.parseInt(reader.nextLine());
				String msgg = control.searchById(toRemove).removeOwnerById(o);
				System.out.println(msgg);
				break;
			case 9:
				System.out.println("digite la identificacion del club al que pertenece el duenio");
				int toRemove1 = Integer.parseInt(reader.nextLine());
				System.out.println("digite la identificacion del duenio");
				int o1 = Integer.parseInt(reader.nextLine());
				System.out.println("digite la identificacion de la mascota");
				int mascot = Integer.parseInt(reader.nextLine());
				String petmsg= control.searchById(toRemove1).searchById(toRemove1).removePetById(mascot);
				System.out.println(petmsg);
				break;
			case 10:
				long t1=System.currentTimeMillis();
				control.orderByDateClubs();
				for (int i = 0; i < control.getClubs().size(); i++) {
					System.out.println(control.getClubs().get(i).toString());
				}
				long tf=System.currentTimeMillis();
				System.out.println(tf-t1);
				break;
			case 11:
				long t2=System.currentTimeMillis();
				control.orderByNameClubs();
				for (int i = 0; i < control.getClubs().size(); i++) {
					System.out.println(control.getClubs().get(i).toString());
				}
				long tf2=System.currentTimeMillis();
				System.out.println(tf2-t2);
				break;
			case 12:
				long t3=System.currentTimeMillis();
				control.orderByIdClubs();
				for (int i = 0; i < control.getClubs().size(); i++) {
					System.out.println(control.getClubs().get(i).toString());
				}
				long tf3=System.currentTimeMillis();
				System.out.println(tf3-t3);
				break;
			case 13:
				long t4=System.currentTimeMillis();
				control.orderByTypePetClubs();
				for (int i = 0; i < control.getClubs().size(); i++) {
					System.out.println(control.getClubs().get(i).toString());
				}
				long tf4=System.currentTimeMillis();
				System.out.println(tf4-t4);
				break;
			case 14:
				long t5=System.currentTimeMillis();
				control.orderByTypePetClubs();
				for (int i = 0; i < control.getClubs().size(); i++) {
					System.out.println(control.getClubs().get(i).toString());
				}
				long tf5 =System.currentTimeMillis();
				System.out.println(tf5-t5);
				break;
			case 15:
				long t6 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						control.getClubs().get(i).orderByNameOwners();
						System.out.println(control.getClubs().get(i).getOwners().get(j).toString());
					}
				}
				long tf6 =System.currentTimeMillis();
				System.out.println(tf6-t6);
				break;
			case 16:
				long t7 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						control.getClubs().get(i).orderById();
						System.out.println(control.getClubs().get(i).getOwners().get(j).toString());
					}
				}
				long tf7=System.currentTimeMillis();
				System.out.println(tf7-t7);
				break;
			case 17:
				long t8 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						control.getClubs().get(i).orderByDate();
						System.out.println(control.getClubs().get(i).getOwners().get(j).toString());
					}
				}
				long tf8 =System.currentTimeMillis();
				System.out.println(tf8-t8);
				break;
			case 18:
				long t9 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						control.getClubs().get(i).orderByTypePet();
						System.out.println(control.getClubs().get(i).getOwners().get(j).toString());
					}
				}
				long tf9 =System.currentTimeMillis();
				System.out.println(tf9-t9);
				break;
			case 19:
				long t10 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						for (int j2 = 0; j2 < control.getClubs().get(i).getOwners().get(i).getPets().size(); j2++) {
							control.getClubs().get(i).getOwners().get(i).orderByNamepets();
							System.out.println(control.getClubs().get(i).getOwners().get(j).getPets().get(j2).toString());
						}
					}
				}
				long tf10 =System.currentTimeMillis();
				System.out.println(tf10-t10);
				break;
			case 20:
				long t11 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						for (int j2 = 0; j2 < control.getClubs().get(i).getOwners().get(i).getPets().size(); j2++) {
							control.getClubs().get(i).getOwners().get(i).orderById();
							System.out.println(control.getClubs().get(i).getOwners().get(j).getPets().get(j2).toString());
						}
					}
				}
				long tf11 =System.currentTimeMillis();
				System.out.println(tf11-t11);
				break;
			case 21:
				long t12 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						for (int j2 = 0; j2 < control.getClubs().get(i).getOwners().get(i).getPets().size(); j2++) {
							control.getClubs().get(i).getOwners().get(i).orderByGender();
							System.out.println(control.getClubs().get(i).getOwners().get(j).getPets().get(j2).toString());
						}
					}
				}
				long tf12 =System.currentTimeMillis();
				System.out.println(tf12-t12);
				break;
			case 22:
				long t13 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						for (int j2 = 0; j2 < control.getClubs().get(i).getOwners().get(i).getPets().size(); j2++) {
							control.getClubs().get(i).getOwners().get(i).orderByDate();
							System.out.println(control.getClubs().get(i).getOwners().get(j).getPets().get(j2).toString());
						}
					}
				}
				long tf13 =System.currentTimeMillis();
				System.out.println(tf13-t13);
				break;
			case 23:
				long t14 =System.currentTimeMillis();
				for (int i = 0; i < control.getClubs().size(); i++) {
					for (int j = 0; j < control.getClubs().get(i).getOwners().size(); j++) {
						for (int j2 = 0; j2 < control.getClubs().get(i).getOwners().get(i).getPets().size(); j2++) {
							control.getClubs().get(i).getOwners().get(i).orderByTypePet();;
							System.out.println(control.getClubs().get(i).getOwners().get(j).getPets().get(j2).toString());
						}
					}
				}
				long tf14 =System.currentTimeMillis();
				System.out.println(tf14-t14);
				break;
			case 24:
				out =true;
				long tFinal=System.currentTimeMillis();
				System.out.println(tFinal-tInicial);
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
		System.out.println("9. eliminar una mascota");
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
