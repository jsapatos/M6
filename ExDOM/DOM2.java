package DOM;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*; 
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;
import java.util.ArrayList;


public class DOM2 {
    public static void main (String args[]) throws IOException {
        ArrayList<String> Empleado = new ArrayList<String>();
        BufferedReader file = new BufferedReader (new FileReader ("Empleados.txt"));
       
        int id, dep, i=0;
        Double salario;
        char nombre[] = new char[10], aux;
       
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
       
        String j="";
        while ((j = file.readLine()) != null){Empleado.add(j);
       
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument (null,"Empleados", null);
            document.setXmlVersion("1.0");
            int z=Empleado.size();
           
            for (i=0;i<z;i++){
               
                String[] Info = Empleado.get(i).split(":");
               
                id = Integer.parseInt(Info[0]);
                nombre = Info[1].toCharArray();
               
                String apellidos = new String (nombre);
               
                dep = Integer.parseInt(Info[2]);
                salario =Double.parseDouble(Info[3]);
               
                if (id>0) {
                    Element raiz = document.createElement ("empleado");
                    document.getDocumentElement().appendChild(raiz);
                    CrearElemento ("id", Integer.toString(id), raiz, document);
                    CrearElemento ("apellido",apellidos.trim(), raiz, document);
                    CrearElemento ("dep", Integer.toString(dep), raiz, document);
                    CrearElemento ("salario", Double.toString(salario),raiz, document);
                }

            }
           
            Source source = new DOMSource (document);
            Result result = new StreamResult (new java.io.File ("Empleados.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform (source, result);
           
        } catch (Exception e ) { e.printStackTrace();}

        }
    }
   
    static void CrearElemento (String datoEmpleado, String valor, Element raiz, Document document) {
        Element elem = document.createElement (datoEmpleado);
        Text text = document.createTextNode(valor);
        raiz.appendChild (elem);
        elem.appendChild (text);
       
    }
}

