package accesoAleatorio;

import java.io.*;

public class ConsultarFicheroAleatorio {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero, "r");
		int id, dep ,posicion;
		System.out.print("Quin id vols cercar? ");
		String resp=buffer.readLine();
		int numID = Integer.parseInt(resp);
		Double salario;
		char apellido[]= new char[10], aux;
		posicion =0;
		boolean trobat = false;
		file.seek(posicion);
		for (;;) {
			id=file.readInt();
			posicion=posicion+1;
			if (id==numID) {
				trobat=true;
				System.out.println("Aquest es l'usuari que cercaves");
				for ( int i =0; i<apellido.length; i++) {
					aux = file.readChar(); 									
					apellido[i]=aux;           								
				}
				String apellidos = new String (apellido);
				dep = file.readInt();              							
				salario = file.readDouble();
				if (id >0) {
					System.out.printf("ID: %s, Apellido: %s, Departamento: %d, Salario: %.2f %n", id,apellidos.trim(), dep, salario);
				}
			}
			else {
				posicion = posicion +35;
				file.seek(posicion);
			}
			if (file.getFilePointer() ==file.length()) break;
		}
		if (trobat==false) {
			System.out.println("No se ha trobat a l'usuari amb aquesta id");
		}
	}
}
