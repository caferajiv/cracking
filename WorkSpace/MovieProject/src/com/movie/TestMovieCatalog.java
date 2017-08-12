package com.movie;

import com.movie.Movie.Genre;

public class TestMovieCatalog {
	
	public static void main(String[] args) {
		
		addMovie();
		
		
		
		
	}

	private static void addMovie() {
		
		MovieCatalog movieCatalog = new MovieCatalog();
		Actor actor1 = new Actor("Mathew Mcaughny","M");
		Director director1 = new Director("Christopher Nolan", "M");
		Movie movie1 = new Movie("Interstellar",actor1, director1,2014,Genre.ScienceFiction,9.8);
		movieCatalog.addMovie(movie1);
		
		Actor actor2 = new Actor("Leonardo DiCaprio","M");
		Director director2 = new Director("Christopher Nolan", "M");
		Movie movie2 = new Movie("Inception",actor2, director2,2011,Genre.ScienceFiction,9.2);
		movieCatalog.addMovie(movie2);
		
		Actor actor3 = new Actor("Kate Winslet","F");
		Director director3 = new Director("James Cameron", "M");
		Movie movie3 = new Movie("Titanic",actor3, director3,1995,Genre.Romance,8.8);
		movieCatalog.addMovie(movie3);
		
		Actor actor4 = new Actor("Hrithik Roshan","M");
		Director director4 = new Director("Frahan Akhtar", "M");
		Movie movie4 = new Movie("Lakshya",actor4, director4,2004,Genre.Action,7.8);
		movieCatalog.addMovie(movie4);
		
		Actor actor5 = new Actor("Farhan Akhtar","M");
		Director director5 = new Director("Frahan Akhtar", "M");
		Movie movie = new Movie("Zindagi na milegi dobara",actor5, director5,2011,Genre.Drama,8.8);
		movieCatalog.addMovie(movie);
		
		Actor actor6 = new Actor("Shah Rukh Khan","M");
		Director director6 = new Director("Shimit Imin", "M");
		Movie movie6 = new Movie("Chak De India",actor6, director6,2007,Genre.Drama,7.8);
		movieCatalog.addMovie(movie6);
		
		System.out.println(movieCatalog.getMovieDB().get("Lakshya"));
		
		System.out.println(movieCatalog.searchMovie("Name", "Lakshya"));
		
		
	}
	
	

}
