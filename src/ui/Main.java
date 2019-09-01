package ui;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Club;
import model.Controller;


public class Main {
	private static final String PATH="/Users/emanuelumana/eclipse-workspace/Pet-clubs/data/MOCK_DATA.csv";
	private Controller control;
	private BufferedReader br;

	public Main() {
		br = new BufferedReader(new InputStreamReader(System.in));
		control = new Controller();
		}
	
	public static void main(String[] args) {
			Main m = new Main();

	}
	
}
