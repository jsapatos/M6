package problemes2;

import java.io.*;

public class Exercici_1_3 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws IOException {
		System.out.print("Que ruta queires? ");
		String arxiu=buffer.readLine();
		File fichero = new File (arxiu);  // declaración fichero
		FileReader flu = new FileReader (fichero); // creamos flujo de entrada hacia el fichero
		int i;
		String b = "hola";
		
		 while (b.length()<21){     //Vamos leyendo carácter a carácter
			while ((i=flu.read())!=-1){
				b = b+((char) i); 
			}
		System.out.println(b);	
		}
		 
		flu.close();
		
	}
}
