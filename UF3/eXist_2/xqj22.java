package xqj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class xqj22 {
	public static void main(String[] args) throws IOException{
		String zona = "";
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Quina zona? ");
		String zona1 = teclat.readLine();
		if (zona1.equals("10") || zona1.equals("20") || zona1.equals("30") || zona1.equals("40")) 
		{
			zona = "/home/cf17jordi.casali/Documents/zona"+zona1+".xml";
		}
		else {
			System.out.print("Zona equivocada");
			System.exit(0);
		}
		try{
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;XQResultSequence resultado;
			consulta = conn.prepareExpression ("for $zona in doc('nueva/zonas.xml')/zonas/zona[cod_zona='"+zona1+"'] return $zona");
			resultado = consulta.executeQuery();
			BufferedWriter writer = new BufferedWriter(new FileWriter(zona));
			writer.write("<?xml version='1.0' encoding='UTF-8'?>");
			writer.newLine();
			while (resultado.next()) {
				String cad = resultado.getItemAsString(null);
				writer.write(cad);
				writer.newLine();
				
			} 
			consulta = conn.prepareExpression ("for $prod in doc('nueva/productos.xml')/productos/produc[cod_zona='"+zona1+"'] return $prod");
			resultado = consulta.executeQuery();
			while (resultado.next()) {
				String cad = resultado.getItemAsString(null);
				writer.write(cad);
				writer.newLine();
				
			} 
			writer.close();
			conn.close();
		}
			
		catch (XQException ex) {
			System.out.println("Error al operar "+ex.getMessage());
		}
	}
}