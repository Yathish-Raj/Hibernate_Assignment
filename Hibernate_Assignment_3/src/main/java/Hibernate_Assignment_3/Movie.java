package Hibernate_Assignment_3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie 
{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "MOVIE_ID")
		private Integer movieId;
		
		@Column(name = "MOVIE_NAME")
		private String movieName;
		
		@Column(name = "DIRECTOR_NAME")
		private String directorName;
		
		@Column(name = "SYNOPSIS")
		private String synopsis;

		public Movie() {}		

		public Movie(Integer movieId, String movieName, String directorName, String synopsis) {
			super();
			this.movieId = movieId;
			this.movieName = movieName;
			this.directorName = directorName;
			this.synopsis = synopsis;
		}

		public Integer getMovieId() {
			return movieId;
		}

		public void setMovieId(Integer movieId) {
			this.movieId = movieId;
		}

		public String getMovieName() {
			return movieName;
		}

		public void setMovieName(String movieName) {
			this.movieName = movieName;
		}

		public String getDirectorName() {
			return directorName;
		}

		public void setDirectorName(String directorName) {
			this.directorName = directorName;
		}

		public String getSynopsis() {
			return synopsis;
		}

		public void setSynopsis(String synopsis) {
			this.synopsis = synopsis;
		}		
}