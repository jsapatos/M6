
import java.io.*;

public class problema4 {
	public static void main (String[] args) {
		try {
			File f = new File(args[0]);
			File [] array;
			array = f.listFiles();
			for (File files:array){
					System.out.println(files);
			}	
		}
		catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("Error, no existeix la ruta");
		}
		finally {
			System.out.println("adeu");
		}
	}
}

