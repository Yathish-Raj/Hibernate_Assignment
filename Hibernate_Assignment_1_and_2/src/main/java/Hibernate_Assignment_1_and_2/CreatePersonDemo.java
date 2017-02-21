package Hibernate_Assignment_1_and_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CreatePersonDemo {
	
	 private static SessionFactory factory; 
	 public static void main(String[] args) {	
		 try{
			 
			 Configuration configuration = new Configuration().configure(CreatePersonDemo.class.getResource("/hibernate.cfg.xml"));			 
			 StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
			 serviceRegistryBuilder.applySettings(configuration.getProperties());		
			 ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
			 factory = configuration.configure().buildSessionFactory(serviceRegistry);        
		 }
		 catch (Throwable ex) { 
			 System.err.println("Failed to create sessionFactory object." + ex);
			 throw new ExceptionInInitializerError(ex); 
		 }
		 
		 Session session = factory.openSession();
		 Transaction transaction = session.beginTransaction();
		 
		 /*Person p1 = new Person("Person_1");
		 session.save(p1);
		 Person p2 = new Person("Person_2");
		 session.save(p2);*/
		 
		 Person person;
		 for(int i=1; i<=20; i++){
			 String personName = "Person_"+i;
			 person = new Person(personName);
			 session.save(person);
		 }		 
		 transaction.commit();
		 session.close();		 
	 }
}
