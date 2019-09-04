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
					control.searchClubsId(i1);
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
		System.out.println("1. Aniadir un club?");
		System.out.println("2. Aniadir un duenio ");
		System.out.println("3. aniadir una mascota ");
		System.out.println("4. eliminar un club");
		System.out.println("5. eliminar un duenio");
		System.out.println("6. eliminar un club");
		System.out.println("7. ordenar club por fecha de creacion");
		System.out.println("7. ordenar club por nombre");
		System.out.println("9. ordenar club por id");
		System.out.println("10. ordenar club por tipo de mascota");
		System.out.println("x. Salir ");

		int valor=0;
		try {
			valor = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return valor;		
	}
	public static void main(String[] args) {
			Main m = new Main();

	}
	
}
