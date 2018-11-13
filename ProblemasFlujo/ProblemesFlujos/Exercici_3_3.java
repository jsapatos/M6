package problemes2;

import java.io.*;

public class Exercici_3_3 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		System.out.print("Quin arxiu vols? ");
		String arxiu=buffer.readLine();
		File fichero = new File(arxiu);
		PrintWriter writer = new PrintWriter(fichero);
		for (int i=0;i<10;i++) {
			writer.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa \n");
		}
		writer.close();
	}
		

}
