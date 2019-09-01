package ui;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import model.Controller;


public class Main {
	private Controller control;
	private BufferedReader lector;

	public Main() {
		lector = new BufferedReader(new InputStreamReader(System.in));
		control = new Controller();
	}
	public static void main(String[] args) {
		Main m = new Main();

	}
	
}
