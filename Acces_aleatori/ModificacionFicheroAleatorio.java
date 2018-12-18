package accesoAleatorio;

import java.io.*;

public class ModificacionFicheroAleatorio {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		int id, dep ,posicion;
		boolean trobat = false;
		posicion=0;
		char apellido[]= new char[10], aux;
		System.out.print("ID: ");
		String resp=buffer.readLine();
		int numID = Integer.parseInt(resp);
		System.out.print("Import: ");
		String importe=buffer.readLine();
		double importeF = Integer.parseInt(importe);
		file.seek(posicion);
		for (;;) {
			id=file.readInt();
			if (id==numID) {
				posicion=posicion + 4;
				file.seek(posicion);
				for ( int i =0; i<apellido.length; i++) {
					aux = file.readChar(); 									// Voy leyendo carácter a carácter el apellido y lo guardo
					apellido[i]=aux;           								// en el array apellido
				}
				String apellidos = new String (apellido);
				posicion=posicion +24;
				file.seek(posicion);
				double salari_anterior=file.readDouble();
				System.out.println("El salari anterior era: "+salari_anterior);
				System.out.println("El cognom d'aquest usuari es"+apellidos);
				double nou_salari=salari_anterior+importeF;
				file.seek(posicion);
			}
		}
		
	}
}
