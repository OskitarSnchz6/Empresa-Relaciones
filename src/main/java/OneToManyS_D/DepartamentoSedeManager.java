package OneToManyS_D;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DepartamentoSedeManager {
	public static void main(String[] args) {
		StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();

		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		// obtains the session
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Sede sede1 = new Sede("Real");
		Sede sede2 = new Sede("Atletico");	
		
		Departamento dpto1 = new Departamento("LaLiga");
		Departamento dpto2 = new Departamento("Champions League");
		Departamento dpto3 = new Departamento("Europa League");
		
		sede1.addDepartamento(dpto1);
		sede2.addDepartamento(dpto2);
		sede1.addDepartamento(dpto3);
		sede2.addDepartamento(dpto1);
		sede1.addDepartamento(dpto2);
		sede2.addDepartamento(dpto3);
		sede2.addDepartamento(dpto1);
		sede1.addDepartamento(dpto2);
		sede2.addDepartamento(dpto3);
		
		dpto1.addSede(sede1);
		dpto2.addSede(sede1);
		dpto3.addSede(sede1);
		dpto1.addSede(sede2);
		dpto2.addSede(sede2);
		dpto3.addSede(sede2);

		session.save(sede1);
		session.save(sede2);

		session.getTransaction().commit();
		session.close();
	}
}