package sax;

import java.io.*;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/*
 * Crea un programa que devuelva el número de discos registrados en 
“discoteca.xml” de un determinado autor que le pasamos por consola. Si el 
autor carece de discos en el archivo, el programa devolverá un mensaje del 
estilo: “El autor <xxxxxx> no aparece en el archivo.
 */


public class SAX4 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main (String [] args) throws FileNotFoundException, IOException, SAXException {
		String nom = "";
		System.out.print("Quin es el nom de l'autor? ");
		nom=buffer.readLine();
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenido gestor = new GestionContenido(nom);
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource ("discoteca.xml");
		procesadorXML.parse(fileXML);
		}
	}
class GestionContenido extends DefaultHandler {
	
	private String nom;
	public int cont=0;
	public GestionContenido(String nom){
		super();
		this.nom=nom;
	}
	public void startDocument() {
		System.out.println("Comienzo del documento XML");
	}
	public void endDocument(){
		System.out.println("Final del documento XML");
		if (cont==0) {
			System.out.println("El autor "+nom+" no tiene ningún cd en el disco");
		}
		else {
			System.out.println("El autor "+nom+" tiene "+cont+" cds en el disco");
		}
	}
	public void startElement (String uri, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\tPrincipio Elemento: %s %n", nombre);
	}
	public void endElement (String uri, String nombre, String nombreC){
		System.out.printf("\tFin Elemento: %s %n",nombre);
	}
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String (ch, inicio, longitud);
		car = car.replaceAll("[\t\n]","");
		System.out.printf("\tCaracteres: %s %n", car);
		if(car.equals(nom)) {
			cont ++;
		}
	}
}
