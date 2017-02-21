package Hibernate_Assignment_1_and_2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class RankingSkillsDemo {
	
	 
	 public static void main(String[] args) {	
		 SessionFactory factory; 
		 try{
			 
			 Configuration configuration = new Configuration().configure(RankingSkillsDemo.class.getResource("/hibernate.cfg.xml"));			 
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
		 
		 for(int i=1; i<=20; i++){			 
			 session.save(addPerson("Person_"+i)); //Person Id is same as index i
		 }	
		 
		 session.save(addSkills("JAVA")); //Skill Id 1
		 session.save(addSkills(".NET")); //Skill Id 2
		 session.save(addSkills("UNIX")); //Skill Id 3
		 session.save(addSkills("SQL"));  //Skill Id 4
		 session.save(addSkills("SPRING")); //Skill Id 5
		 session.save(addSkills("HIBERNATE")); //Skill Id 6
		 
		 Person person1 = (Person)session.load(Person.class, 1);
		 Person person2 = (Person)session.load(Person.class, 2);
		 Person person3 = (Person)session.load(Person.class, 3);
		 Person person4 = (Person)session.load(Person.class, 4);
		 Person person5 = (Person)session.load(Person.class, 5);
		 Person person6 = (Person)session.load(Person.class, 6);
		 
		 Skills skill1 = (Skills)session.load(Skills.class, 1);
		 Skills skill2 = (Skills)session.load(Skills.class, 2);
		 Skills skill3 = (Skills)session.load(Skills.class, 3);
		 Skills skill4 = (Skills)session.load(Skills.class, 4);
		 Skills skill5 = (Skills)session.load(Skills.class, 5);
		 Skills skill6 = (Skills)session.load(Skills.class, 6);
		 
		 session.save(addRank(person1, person2, skill1, 8));
		 session.save(addRank(person2, person3, skill2, 7));
		 session.save(addRank(person3, person4, skill3, 6));
		 session.save(addRank(person4, person5, skill4, 5));
		 session.save(addRank(person5, person6, skill5, 4));
		 session.save(addRank(person6, person1, skill6, 3));
		 
		 transaction.commit();
		 session.close();		 
	 }	
	 
	 private static Person addPerson(String personName){
		 Person person = new Person();
		 person.setPersonName(personName);		
		 return person;
	 }	
	 
	 private static Skills addSkills(String skillName){			
		 Skills skills = new Skills();
		 skills.setSkillName(skillName);			
		 return skills;
	 }
	 
	 private static Rank addRank(Person observer, Person subject, Skills skills, int score){
		 Rank rank = new Rank();
		 rank.setObserver(observer);
		 rank.setSubject(subject);
		 rank.setSkills(skills);
		 rank.setScore(score);
		 return rank;
	 }
}
