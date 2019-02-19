
import primero.*;

import java.util.Iterator;
import java.util.Set;

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
		Depart dep = (Depart) session.get(Depart.class, 10);
		if (dep==null) {
			System.out.println("no existe ese empleado");
		} else {
			Set <Emple> listaemp = dep.getEmples();
			Iterator <Emple>it = listaemp.iterator();
			while (it.hasNext()) {
				Emple emp = it.next();
				System.out.println(emp.getApellido()+", "+emp.getSalario());
			}
			
			
		}
		//Guardamos en la base de datos y comprometemos la información
		session.save(dep);
		tx.commit();
		session.close();
		System.exit(0);
	}
}