package com.wipro.movFlix.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.movFlix.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,String>{
	
	public List<Movie> findByMovieIdContainingIgnoreCase(String movieId);
	
	public List<Movie> findByMovieNameContainingIgnoreCase(String movieName);

	public List<Movie> findByCollectionBetween(double lowerLimit, double upperLimit);

}
