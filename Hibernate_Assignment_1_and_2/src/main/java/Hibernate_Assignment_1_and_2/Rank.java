package Hibernate_Assignment_1_and_2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RANK_ID")
	private Integer rankId;
	
	@ManyToOne
	@JoinColumn(name = "OBSERVER_ID")
	private Person observer;
	
	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Person subject;	
	
	@ManyToOne
	@JoinColumn(name = "SKILL_ID")
	private Skills skills;
	
	@Column(name = "SCORE")
	private int score;

	public Rank() {}

	public Rank(int rankId, Person observer, Person subject, Skills skills, int score) {
		super();
		this.rankId = rankId;
		this.observer = observer;
		this.subject = subject;
		this.skills = skills;
		this.score = score;
	}

	public int getRankId() {
		return rankId;
	}

	public void setRankId(int rankId) {
		this.rankId = rankId;
	}

	public Person getObserver() {
		return observer;
	}

	public void setObserver(Person observer) {
		this.observer = observer;
	}

	public Person getSubject() {
		return subject;
	}

	public void setSubject(Person subject) {
		this.subject = subject;
	}

	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
