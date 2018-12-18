package accesoAleatorio;

import java.io.*;

public class InsertarFicheroAleatorio {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		File fichero = new File ("AleatorioEmpleado.dat");
		RandomAccessFile file = new RandomAccessFile (fichero , "rw");
		int id, dep ,posicion;
		posicion = 0;
		boolean trobat = false;
		StringBuffer buffer2 = null;
		System.out.print("Quina sera la id?");
		String resp=buffer.readLine();
		int numID = Integer.parseInt(resp);
		System.out.print("Qual sera el apellido?");
		String apellidoR=buffer.readLine();
		System.out.print("Qual sera el departamento?");
		String depR=buffer.readLine();
		dep = Integer.parseInt(depR);
		System.out.println("Qual sera el salario?");
		String SalarioR=buffer.readLine();
		double salario= Integer.parseInt(SalarioR);
		file.seek(posicion);
		for (;;) {
			id=file.readInt();
			if (id==numID) {
				System.out.println("Ja hi ha un usuari amb aquesta id creat");
				trobat=true;
			}
			else {
				posicion=posicion+36;
				file.seek(posicion);
			}
			if (file.getFilePointer()==file.length()) break;
		}
		if (trobat==false) {
			file.writeInt(numID);
			buffer2 = new StringBuffer (apellidoR);
			buffer2.setLength(10);
			file.writeChars(buffer2.toString());
			file.writeInt(dep);
			file.writeDouble(salario);
			System.out.println("Se ha creat l'usuari");
		}
		file.close();
	}
}
