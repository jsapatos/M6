package problemes2;

import java.io.*;

public class Exercici_2_3 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		File fichero = new File("FicheroTexto.txt");
		FileWriter fic = new FileWriter (fichero);
		String prov[] = {"Albacete", "Avila", "Badajoz", "Caceres", "Huelva", "Jaen", 
				"Madrid", "Segovia", "Soria", "Toledo", "Valladolid", "Zamora"};
		for (int i=0;i<prov.length;i++) {
			char [] buf = prov[i].toCharArray();
			fic.write(buf);
			fic.write(" ");
		}
		
		//fic.append ("*"); // añadimos un asterisco al final
		fic.close ();   // cerramos fichero
	}
}
