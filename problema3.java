
import java.io.*;

public class problema3 {
	public static void main (String[] args) {
			File f = new File(args[0]);
			File [] array;
			array = f.listFiles();
			
			for (File files:array){
					System.out.println(files);
			}
	}
}