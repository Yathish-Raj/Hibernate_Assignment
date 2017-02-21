package Hibernate_Assignment_4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class EventRegistrationMenuDemo {
	
	public static void main(String[] args) {	
		 SessionFactory factory; 
		 try{
			 
			 Configuration configuration = new Configuration().configure(EventRegistrationMenuDemo.class.getResource("/hibernate.cfg.xml"));			 
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
	
		 Scanner in = new Scanner(System.in);
         int userChoice;
         boolean quit = false;
         
         do {
               System.out.println("1. Register employee for events");
               System.out.println("2. Display all employees");  
               System.out.println("3. Display all events");  
               System.out.print("Your choice, 0 to quit: ");
               userChoice = in.nextInt();
               switch (userChoice) {
               case 1:
                     String mid;
                     String employeeName;
                     Date joinDate;
                     String emailId;
                     Integer eventId;
                     Employees employee= new Employees();
                     List<Events> eventsList = new ArrayList<Events>();
                     in.nextLine();
                     System.out.println("Please enter Employee MID: ");
                     mid = in.nextLine();
                     employee.setMid(mid);
                     System.out.println("Please enter Employee name: ");
                     employeeName = in.nextLine();
                     employee.setName(employeeName);
                     System.out.println("Please enter Employee join date in YYYY-MM-DD format: ");
                     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                     String dateInString = in.nextLine();
                     try {
                         Date date = formatter.parse(dateInString);                        
                     //  System.out.println(formatter.format(date));
                         joinDate = date;
                         employee.setJoinDate(joinDate);
                     } catch (ParseException e) {
                         e.printStackTrace();
                     }
                     System.out.println("Please enter Employee email-id: ");
                     emailId = in.nextLine();
                     employee.setEmailId(emailId);
                     System.out.println("Please enter event Id to which employee should be registered: ");
                     eventId = in.nextInt();            
                     eventsList.add((Events)session.load(Events.class, eventId));
                     employee.setEventsList(eventsList);
                     session.save(employee);
                     transaction.commit();
                     break;
               case 2:
            	   	 List<Employees> employees  = (List<Employees>) session.createQuery("from Employees").list();
                     System.out.print("List of All Employees: ");
                     for(Employees employeeEntry : employees) {
                         System.out.println("\nMID: "+employeeEntry.getMid()+" Employee_Name "+employeeEntry.getName()
                         +" Join_Date: "+employeeEntry.getJoinDate()+" Email_id: "+employeeEntry.getEmailId());
                     }                    
                     break;
               case 3:
            	   List<Events> events  = (List<Events>) session.createQuery("from Events").list();
                   System.out.print("List of All Events: ");
                   for(Events eventsEntry : events) {
                       System.out.println("\nEventId: "+eventsEntry.getEventId()+" Event_Title "+eventsEntry.getEventTitle()
                       +" Event_Description: "+eventsEntry.getDescription());
                   }                    
                   break;
               case 0:
                     quit = true;
                     break;
               default:
                     System.out.println("Wrong choice.");
                     break;
               }
               System.out.println();
         } while (!quit);
         System.out.println("Bye!");
		 
		 transaction.commit();
		 session.close();	
	}
}
