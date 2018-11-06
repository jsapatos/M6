package exemple1;

import java.io.*;

public class problema2 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args) throws IOException {
			System.out.print("Que ruta queires? ");
			String line=buffer.readLine();
			File f = new File(line);
			String[] archivos = f.list();
			System.out.printf("Ficheros en el directorio actual: %d %n", archivos.length);
			for (int i=0; i<archivos.length; i++){
					File f2 = new File(f, archivos[i]);
					System.out.printf("Nombre: %s , es fichero?: %b, es directorio?:%b %n", archivos[i], f2.isFile(), f2.isDirectory());
			}
	}
}