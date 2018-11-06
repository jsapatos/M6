package exemple1;

import java.io.*;

public class problema5_1 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String[] args) throws IOException {
		File archiu = null;
		String nom, ruta_relativa, ruta_absoluta,permisos;
		boolean permis_escriure,permis_executar,permis_llegir;
		long tamañ;
		System.out.print("Que ruta queires? ");
		String arxiu=buffer.readLine();
		archiu= new File(arxiu);
		nom=archiu.getName();
		ruta_relativa=archiu.getPath();
		ruta_absoluta=archiu.getAbsolutePath();
		tamañ=archiu.length();
		permis_escriure=archiu.canWrite();
		permis_executar=archiu.canExecute();
		permis_llegir=archiu.canRead();
		System.out.println("El nom es: "+nom+" la ruta es: "+ruta_relativa+" la ruta absoluta es "+ruta_absoluta+" el tamañ es "+tamañ);
		System.out.println("Pot escriure? "+permis_escriure+" Pot llegir? "+permis_llegir+"Pot executar? "+permis_executar);
	}
}
