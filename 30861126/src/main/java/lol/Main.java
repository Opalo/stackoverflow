package lol;

import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {
		Main m = new Main();
		m.res1();
		m.res2();
	}

	public void res1() {
		System.out.println("res1");
		readResource("res1");
	}

	public void res2() {
		System.out.println("res2");
		readResource("img/res2");	
	}

	private void readResource(String path) {
		InputStream in = getClass().getClassLoader().getResourceAsStream(path); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		try (Scanner scanner = new Scanner(reader)) {
 
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				System.out.println("LINE: " + line);
			}
 
			scanner.close();
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
