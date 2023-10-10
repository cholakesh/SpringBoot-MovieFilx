package com.wipro.movFlix.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Movie {
	
	@Id
	private String movieId;
	private String movieName;
	private double collection;
	
	
	
	public String getMovieId() {
		return movieId;
	}



	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}



	public String getMovieName() {
		return movieName;
	}



	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}



	public double getCollection() {
		return collection;
	}



	public void setCollection(double collection) {
		this.collection = collection;
	}

	

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Movie(String movieId, String movieName, double collection) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.collection = collection;
	}



	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", collection=" + collection + "]";
	}
	
	

}
