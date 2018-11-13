package problemes2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercici_3_2 {
	
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		System.out.print("Quin arxiu vols? ");
		String arxiu=buffer.readLine();
		BufferedWriter writer = new BufferedWriter(new FileWriter(arxiu));
		for (int i = 0;i<10;i++) {
			writer.write("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			writer.newLine();
		}
		writer.close();
		
		
		
		
		
	}
 
}
