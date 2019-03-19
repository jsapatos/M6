package xqj;

import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultItem;
import javax.xml.xquery.XQResultSequence;
import net.xqj.exist.ExistXQDataSource;

public class veremple10 {
	public static void main(String[] args){
		try{
			XQDataSource server = new ExistXQDataSource();
			server.setProperty ("serverName", "192.168.56.102");
			server.setProperty ("port","8080");
			server.setProperty ("user","admin");
			server.setProperty ("password","austria");
			XQConnection conn = server.getConnection();
			XQPreparedExpression consulta;XQResultSequence resultado;
			consulta = conn.prepareExpression ("for $emp in doc('nueva/empleados.xml')/EMPLEADOS/EMP_ROW[DEPT_NO = 10]/APELLIDO return $emp");
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