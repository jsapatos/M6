package xqj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

import net.xqj.exist.ExistXQDataSource;

public class xqj21 {
	public static void main(String[] args) throws IOException{
		BufferedReader teclat = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Quin departament? ");
		String missatge = teclat.readLine();
		if (!missatge.equals("A"))
		{
			if (!missatge.equals("B"))
			{
				System.out.println("Departament equivocat!");
				System.exit(0);
			}
		}
		try{
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;XQResultSequence resultado;
			consulta = conn.prepareExpression ("for $dep in doc('nueva/universidad.xml')/universidad/departamento[@tipo ='"+missatge+"'] return $dep");
			resultado = consulta.executeQuery();
			while (resultado.next()) {
				System.out.println(resultado.getItemAsString(null));
			}
			conn.close();
			} 
		catch (XQException ex) {
			System.out.println("Error al operar "+ex.getMessage());
		}
	}
}