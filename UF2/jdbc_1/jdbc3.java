package jdbc_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc3 {
	static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		try{
			System.out.print("Que localidad quieres buscar? ");
			String localidad=buffer.readLine();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion=DriverManager.getConnection
			("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
			Statement sentencia =conexion.createStatement();
			String sql = "SELECT t1.apellido , t2.dnombre , t2.loc from emple as t1 inner join depart as t2 on t1.dept_no = t2.dept_no where t2.loc='"+localidad+"'";
			ResultSet result = sentencia.executeQuery(sql);
			while (result.next()){
				System.out.printf("%s, %s, %s, %n",
				result.getString(1),
				result.getString(2),
				result.getString(3));
			}
			result.close();
		 	sentencia.close();
		 	conexion.close();
		 } catch (ClassNotFoundException cn) { cn.printStackTrace();
		 } catch (SQLException e) {e.printStackTrace();
		 }
	}
}
