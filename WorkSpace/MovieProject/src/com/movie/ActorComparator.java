package com.movie;

import java.util.Comparator;

public class ActorComparator implements Comparator<Movie>{

	@Override
	public int compare(Movie movie1, Movie movie2) {
		
		return movie1.getActor().getName().compareTo(movie2.getActor().getName());
	}

}
