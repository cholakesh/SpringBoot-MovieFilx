package com.wipro.movFlix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.movFlix.entity.Movie;
import com.wipro.movFlix.repo.MovieRepo;

@Controller
public class MovieController {
	
	@Autowired
	MovieRepo movieRepo;
	
	@GetMapping("/searchByIdForm")
	public String formById() {
		return "movieId";
	}
	
	@GetMapping("/searchByNameForm")
	public String formByName() {
		return "movieName";
	}
	
	@GetMapping("/searchById")
	public ModelAndView getMovieDetailsByIdOrName(@ModelAttribute("id") String movieId) {
		List<Movie> movies=null;
		ModelAndView model=new ModelAndView();
		
		if(!movieId.isBlank()) {
			movies=movieRepo.findByMovieIdContainingIgnoreCase(movieId);
			if(!movies.isEmpty()) {
				model.addObject("movies", movies);
				model.setViewName("movieDetails");
			}
			else {
				model.setViewName("failure");
			}
		}
		else {
			model.setViewName("failure");
		}
		return model;
	}
	
	@GetMapping("/searchByName")
	public ModelAndView getMovieDetailsByName(@ModelAttribute("name") String movieName) {
		List<Movie> movies=null;
		ModelAndView model=new ModelAndView();
		
		if(!movieName.isBlank()) {
			movies=movieRepo.findByMovieNameContainingIgnoreCase(movieName);
			if(!movies.isEmpty()) {
				model.addObject("movies", movies);
				model.setViewName("movieDetails");
			}
			else {
				model.setViewName("failure");
			}
		}
		else {
			model.setViewName("failure");
		}
		return model;
	}
	
	@GetMapping("/showAdminLoginPage")
	public String showAdminLoginPage() {
		return "login";
	}
	
	@GetMapping("/checkloginDetails")
	public String checkLoginDetails(@ModelAttribute("userId")String userId,@ModelAttribute("password")String password) {
		if(userId.equals("stella@gmail.com")&& password.equals("stellar")) {
			return "adminPage";
		}
		return "loginFailure";
	}
	
	@GetMapping("/showMovieForm")
	public String showMovieForm() {
		return "movieForm";
	}
	
	@PostMapping("/saveMovieDetails")
	public String saveMoviedetails(@ModelAttribute("movieId")String movieId,@ModelAttribute("movieName")String movieName,@ModelAttribute("collection")double collection) {
		
		Movie newMovie=new Movie(movieId,movieName,collection);
		
		movieRepo.save(newMovie);
		
		return "movAddSucc";
	}
	
	@GetMapping("/modifyMovie")
	public String modifyMovie() {
		return "modifyMovie";
	}
	
	@GetMapping("/collectionForm")
	public String showCollectionForm() {
		return "collectionForm";
	}
	
	@GetMapping("/searchByCollection")
	public ModelAndView getMoviesByCollection(@ModelAttribute("lowerLimit")double lowerLimit,@ModelAttribute("upperLimit")double upperLimit) {
		List<Movie> movies=movieRepo.findByCollectionBetween(lowerLimit,upperLimit);
		ModelAndView model=new ModelAndView();
		
		if(!movies.isEmpty()) {
			model.addObject("movies", movies);
			model.setViewName("movieDetails");
		}
		else {
			model.setViewName("failure");
		}
		return model;
	}
}
