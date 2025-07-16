package com.learner.movieRecommendation;

import com.learner.movieRecommendation.service.MovieRecommender;
import com.learner.movieRecommendation.service.impl.TrieBasedMovieRecommender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRecommendationApplication.class, args);

		MovieRecommender recommender = new TrieBasedMovieRecommender();

	}

}
