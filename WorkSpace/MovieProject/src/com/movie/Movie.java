package com.movie;

public class Movie {
	

	private String name;
	
	private Actor actor;
	
	private Director director;
	
	private int releaseYear;
	
	private Genre genre;
	
	private double rating;
	
	
	public Movie()
	{
		
	}
	
	public Movie(String name, Actor actor, Director director, int releaseYear, Genre genre, double rating){
		this.name = name;
		this.actor = actor;
		this.director = director;
		this.releaseYear = releaseYear;
		this.genre = genre;
		this.rating = rating;
	}
	
	public String toString(){
		
		return this.name+" "+this.releaseYear;
	}
	
	@Override
	public boolean equals(Object movie) {
		if(movie != null && movie instanceof Movie && this.name.equals(((Movie)movie).getName())){
			return true;
		}
		return false;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the actor
	 */
	public Actor getActor() {
		return actor;
	}

	/**
	 * @param actor the actor to set
	 */
	public void setActor(Actor actor) {
		this.actor = actor;
	}

	/**
	 * @return the director
	 */
	public Director getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(Director director) {
		this.director = director;
	}

	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}

	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	public static enum Genre{
		Comedy,
		Horror,
		Romance,
		Drama,
		Action,
		Filmnoir,
		Documentary,
		Biography,
		ScienceFiction;
	}
	

}
