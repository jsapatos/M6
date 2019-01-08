package jdbc_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2 {
	 public static void main(String[] args) {
		 try{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conexion=DriverManager.getConnection
		("jdbc:mysql://192.168.56.10/ejemplo","austria","austria");
		 Statement sentencia =conexion.createStatement();
		 String sql = "SELECT t1.apellido , t1.salario, t2.dnombre from emple as t1 inner join depart as t2 on t1.dept_no = t2.dept_no order by salario desc limit 1";
		 ResultSet result = sentencia.executeQuery(sql);
		 while (result.next()){
		 System.out.printf("%d, %s, %s, %n",
		 result.getInt(2),
		result.getString(3),
		result.getString(1));
		 }
		 result.close();
		 sentencia.close();
		 conexion.close();
		 } catch (ClassNotFoundException cn) { cn.printStackTrace();
		 } catch (SQLException e) {e.printStackTrace();
		 }
		}
		}