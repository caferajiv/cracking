package com.movie;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.movie.Movie.Genre;

public class MovieCatalog {
	
	private Map<String, Movie> movieDB = new ConcurrentHashMap<String, Movie>();
	
	
	public void addMovie(Movie movie){
	
		movieDB.put(movie.getName(), movie);
	}
	
	public Movie searchMovie(String searchCriteria, String name){
		
		if(searchCriteria.equals(SearchCriteria.Name.value)){
			return movieDB.get(name);
		}
		return null;
	}
	
	/**
	 * @return the movieDB
	 */
	public Map<String, Movie> getMovieDB() {
		return movieDB;
	}


	public Movie getTopRatedMovie(Genre genre, int limit){
		
		return null;
	}
	
	public static enum SearchCriteria{
		Name("Name"),
		Director("Director"),
		Actor("Actor");
		
		private String value;
		
		 SearchCriteria(String value){
			this.value= value;
		}
	}

}
