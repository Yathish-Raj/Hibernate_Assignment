package Hibernate_Assignment_4;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Employees 
{
			@Id
			@Column(name = "MID")
			private String mid;
			
			@Column(name = "NAME")
			private String name;
			
			@Column(name = "JOIN_DATE")
			private Date joinDate;
			
			@Column(name = "EMAIL_ID")
			private String emailId;
			
			@ManyToMany	
			private List<Events> eventsList;

			public Employees() {}

			public Employees(String mid, String name, Date joinDate, String emailId) {
				super();
				this.mid = mid;
				this.name = name;
				this.joinDate = joinDate;
				this.emailId = emailId;
			}

			public String getMid() {
				return mid;
			}

			public void setMid(String mid) {
				this.mid = mid;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			public Date getJoinDate() {
				return joinDate;
			}

			public void setJoinDate(Date joinDate) {
				this.joinDate = joinDate;
			}

			public String getEmailId() {
				return emailId;
			}

			public void setEmailId(String emailId) {
				this.emailId = emailId;
			}

			public List<Events> getEventsList() {
				return eventsList;
			}

			public void setEventsList(List<Events> eventsList) {
				this.eventsList = eventsList;
			}			
}