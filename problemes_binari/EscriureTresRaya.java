package problemes_binari;

import java.io.*;

public class EscriureTresRaya {
	@SuppressWarnings("null")
	public static void main (String [] args) throws IOException {
		File fitxer = new File("FicherTresRaya.dat");
		FileOutputStream FileRaya = new FileOutputStream(fitxer);
		ObjectOutputStream DataOS = new ObjectOutputStream(FileRaya);
		int [][] posicio = new int[3][3];
		posicio[1][0]=2;
		posicio[1][2]=1;
		posicio[1][1]=2;
		TresRaya tresenraya = new TresRaya (posicio,2);
		DataOS.writeObject(tresenraya);
		DataOS.close();
	}
}
