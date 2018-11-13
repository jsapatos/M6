package problemes2;

import java.io.*;

public class Exercici_2_1 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		File fichero = new File("/home/cf17jordi.casali/Baixades/data");
		FileWriter fic = new FileWriter (fichero);
		String cadena = "Esto es una prueba con FileWriter";
		char [] cad = cadena.toCharArray () ;
		for ( int i=0; i < cad.length ; i++) {
			fic.write (cad[i]); // se va escribiendo carácter a carácter
		}
		fic.append ("*"); // añadimos un asterisco al final
		fic.close ();   // cerramos fichero
		
	}
}
