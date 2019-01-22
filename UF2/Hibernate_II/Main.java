
import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class Main {
	public static void main(String[] args){
		//En primer lugar se obtiene la sesión creada por el Singleton. 
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		//Abrimos sesión e iniciamos una transacción
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("Inserto una fila en depart");
		//Creamos un nuevo objeto Depart y damos valor a sus atributos
		Emple emp = new Emple();
		Depart dep = new Depart();
		dep.setDeptNo(10);
		emp.setApellido("Fax");
		emp.setOficio("EMPLEADO");
		emp.setSalario(13);
		emp.setEmpNo(8000);
		emp.setDir(7902);
		emp.setComision(null);
		emp.setFechaAlt(null);
		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}