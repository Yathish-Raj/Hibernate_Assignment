package Hibernate_Assignment_1_and_2;

import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.CountProjection;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class AveragePerSkillDemo {
	
	 public static void main(String[] args) {	
		 SessionFactory factory; 
		 try{
			 
			 Configuration configuration = new Configuration().configure(AveragePerSkillDemo.class.getResource("/hibernate.cfg.xml"));			 
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
				
		 Person person;
		 for(int i=1; i<=20; i++){			 
			 person = (Person)session.get(Person.class, i);	
			 Skills skill;
			 for(int j=1; i<=6; j++){			 
				 skill = (Skills)session.get(Skills.class, j);				
				
				 Criteria criteria = session.createCriteria(Rank.class);
				 Criterion subjectId = Restrictions.eq("subject", i);
				 Criterion skillsId = Restrictions.eq("skills", j);
					 
				 LogicalExpression andExp = Restrictions.and(subjectId,skillsId);
				 criteria.add(andExp);
				 criteria.addOrder(Order.desc("skills"));
				 CountProjection p = Projections.count("skills");
			        
			        ProjectionList pl = Projections.projectionList();
			        pl.add(Projections.rowCount());
			        pl.add(Projections.max("skills"));
			        criteria.setProjection(pl);		    
			        
			        Iterator it = criteria.list().iterator();
			        
			        while(it.hasNext()){
			        	Object obj[] = (Object[])it.next();
			        	System.out.println(obj[0] +" " + obj[1]);
			        }
				 }
			 }
		 transaction.commit();
		 session.close();	
	 }	
}
