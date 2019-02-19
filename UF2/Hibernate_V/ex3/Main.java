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
		Query q = session.createQuery("from Emple as emple inner join emple.depart as depart");
		List <?> lista =q.list();
		for(int i=0; i<lista.size(); i++) {
			Object[] row = (Object[]) lista.get(i);
			Emple emp = (Emple)row[0];
			Depart dep = (Depart)row[1];
			System.out.printf("Empleado %s, Departamento %s%n",emp.getApellido(),dep.getDeptNo());
		}
		session.close();
		System.exit(0);
	}
}
