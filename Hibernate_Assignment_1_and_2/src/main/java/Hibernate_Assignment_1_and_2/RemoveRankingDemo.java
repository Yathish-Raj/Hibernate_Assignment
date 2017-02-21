package Hibernate_Assignment_1_and_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class RemoveRankingDemo {
	
	 public static void main(String[] args) {	
		 SessionFactory factory; 
		 try{
			 
			 Configuration configuration = new Configuration().configure(RemoveRankingDemo.class.getResource("/hibernate.cfg.xml"));			 
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
		 
		 //Removing ranking for Observer Id 4
		 
		 Person Observer4 = (Person)session.get(Person.class, 4);
		 
		 Rank RankForObserver4 = new Rank();
		 RankForObserver4.setRankId(4);
		 RankForObserver4.setObserver(Observer4);
		 session.delete(RankForObserver4);
		 
		 transaction.commit();
		 session.close();	
	 }
}
