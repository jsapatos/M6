package problemes2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercici_3_1 {

	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		System.out.print("Quin arxiu vols? ");
		String arxiu=buffer.readLine();
		BufferedReader reader = new BufferedReader(new FileReader(arxiu));
		String line;
		line = reader.readLine();
		while (line != null) {
			System.out.println(line);
			line=reader.readLine();
		}
		
	}
}
