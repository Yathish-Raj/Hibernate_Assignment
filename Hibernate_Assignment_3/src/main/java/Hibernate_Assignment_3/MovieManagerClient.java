package Hibernate_Assignment_3;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MovieManagerClient {
	
	public static void main(String[] args) {	
		 SessionFactory factory; 
		 try{
			 
			 Configuration configuration = new Configuration().configure(MovieManagerClient.class.getResource("/hibernate.cfg.xml"));			 
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
		 
		 //Insert operation
		 session.save(addMovie("Movie_Name_1", "Director_1", "Synopsis_1"));
		 session.save(addMovie("Movie_Name_2", "Director_2", "Synopsis_2"));
		 session.save(addMovie("Movie_Name_3", "Director_3", "Synopsis_3"));
		 session.save(addMovie("Movie_Name_4", "Director_4", "Synopsis_4"));
		 session.save(addMovie("Movie_Name_5", "Director_5", "Synopsis_5"));
		 session.save(addMovie("Movie_Name_6", "Director_6", "Synopsis_6"));
		 session.save(addMovie("Movie_Name_7", "Director_7", "Synopsis_7"));
		 
		 //Retrieve Operation
		 String hql = "SELECT M.movieName FROM Movie M";
		 Query query = session.createQuery(hql);
		 List results = query.list();
		 System.out.println("Movies list: \n"+results+"\n");
		 
		 transaction.commit();
		 session.close();	
}
		 private static Movie addMovie(String movieName, String directorName, String synopsis){
			 Movie movie = new Movie();
			 movie.setMovieName(movieName);
			 movie.setDirectorName(directorName);
			 movie.setSynopsis(synopsis);
			 return movie;
		 }
}