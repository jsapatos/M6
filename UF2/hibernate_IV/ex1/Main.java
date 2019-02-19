
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
		Emple emp = (Emple) session.get(Emple.class, 7369);
		if (emp==null) {
			System.out.println("no existe ese empleado");
		} else {
			System.out.println("Apellido del empleado: "+emp.getApellido()+" y el salario: "+emp.getSalario());	
		}
		//Guardamos en la base de datos y comprometemos la información
		session.save(emp);
		tx.commit();
		session.close();
		System.exit(0);
	}
}