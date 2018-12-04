package problemes_binari;

import java.io.*;

public class GuardarYRecuperarEstado {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException, ClassNotFoundException {
		System.out.print("Vols guardar o recuperar partida? (1/2): ");
		String resp=buffer.readLine();
		if (resp.equals("1")){
			Guardar();
		}
		else if (resp.equals("2")) {
			Cargar();
		}
		else {
			System.out.println("Error, torna a iniciar el programa");
		}
	}
	
	public static void Guardar() throws IOException, ClassNotFoundException {
		File fitxer = new File("FicherTresRaya.dat");
		FileOutputStream FileRaya = new FileOutputStream(fitxer);
		ObjectOutputStream DataOS = new ObjectOutputStream(FileRaya);
		int [][] posicio = new int[3][3];
		TresRaya tresenraya = new TresRaya (posicio,2);
		DataOS.writeObject(tresenraya);
		DataOS.close();
	}
	
	public static void Cargar()  throws IOException, ClassNotFoundException{
		TresRaya tresraya;
		File fichero = new File("FicherTresRaya.dat");
		FileInputStream filein = new FileInputStream(fichero);
		ObjectInputStream DataIS = new ObjectInputStream (filein);
		try {
			while(true){
				tresraya = (TresRaya)DataIS.readObject();
				System.out.print("Toca al jugador: ");
				System.out.println(tresraya.getTurno());
			}
		}catch (EOFException eo) {
			System.out.print("Final de lectura");
		}
		DataIS.close();
	}
}




