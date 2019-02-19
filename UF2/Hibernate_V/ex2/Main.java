import primero.*;
import java.util.Iterator;
import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main{
	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("from Emple where APELLIDO='ARROYO'");
		List <Emple> lista = q.list();
		Iterator <Emple> iter = lista.iterator();
		System.out.printf("Número de empleados en el departamento 20: %d%n", lista.size());
		while (iter.hasNext()){
			Emple emp = (Emple)iter.next();
			System.out.printf("%d, %s%n", emp.getSalario(), emp.getApellido());	
		}
		session.close();
		System.exit(0);
	}
}
