package Hibernate_Assignment_1_and_2;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Person 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PERSON_ID")
	private Integer personId;
	
	@Column(name = "PERSON_NAME")
	private String personName;
	
	/*@OneToMany(mappedBy = "observer")	
	private List<Rank> observerRanks;
	
	@OneToMany(mappedBy = "subject")	
	private List<Rank> subjectRanks;*/
	
	public Person(){}
	
	public Person(String personName) {
		this.personName = personName;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/*public List<Rank> getObserverRanks() {
		return observerRanks;
	}

	public void setObserverRanks(List<Rank> observerRanks) {
		this.observerRanks = observerRanks;
	}

	public List<Rank> getSubjectRanks() {
		return subjectRanks;
	}

	public void setSubjectRanks(List<Rank> subjectRanks) {
		this.subjectRanks = subjectRanks;
	}	*/
}
