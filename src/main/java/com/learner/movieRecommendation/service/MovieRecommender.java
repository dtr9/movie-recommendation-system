package com.learner.movieRecommendation.service;

import com.learner.movieRecommendation.model.Movie;

import java.util.List;

public interface MovieRecommender {
    void addMovie(String name, int rank);
    List<String> getTopNMoviesWithPrefix(String prefix, int n);
    List<Movie> getAllMovies();
}
