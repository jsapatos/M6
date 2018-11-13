package problemes2;

import java.io.*;

public class Exercici_2_2 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		File fichero = new File("FicheroTexto.txt");
		FileWriter fic = new FileWriter (fichero);
		String cadena = " Esto es una prueba con FileWriter";
		char [] buf = cadena.toCharArray();
			fic.write (buf); // se va escribiendo carácter a carácter
		fic.append ("*"); // añadimos un asterisco al final
		fic.close ();   // cerramos fichero
		
	}
}
