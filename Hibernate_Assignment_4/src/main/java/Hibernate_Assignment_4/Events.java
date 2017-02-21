package Hibernate_Assignment_4;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Events 
{
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name = "EVENT_ID")
			private Integer eventId;
			
			@Column(name = "EVENT_TITLE")
			private String eventTitle;
			
			@Column(name = "DESCRIPTION")
			private String description;
			
			@ManyToMany(mappedBy = "eventsList")
			private List<Employees> employeesList;

			public Events() {}

			public Events(Integer eventId, String eventTitle, String description) {
				super();
				this.eventId = eventId;
				this.eventTitle = eventTitle;
				this.description = description;
			}

			public Integer getEventId() {
				return eventId;
			}

			public void setEventId(Integer eventId) {
				this.eventId = eventId;
			}

			public String getEventTitle() {
				return eventTitle;
			}

			public void setEventTitle(String eventTitle) {
				this.eventTitle = eventTitle;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}

			public List<Employees> getEmployeesList() {
				return employeesList;
			}

			public void setEmployeesList(List<Employees> employeesList) {
				this.employeesList = employeesList;
			}			
}