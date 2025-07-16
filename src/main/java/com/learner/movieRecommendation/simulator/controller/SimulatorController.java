package com.learner.movieRecommendation.simulator.controller;

import com.learner.movieRecommendation.model.Movie;
import com.learner.movieRecommendation.service.MovieRecommender;
import com.learner.movieRecommendation.service.impl.TrieBasedMovieRecommender;
import com.learner.movieRecommendation.simulator.dto.AddMovieRequest;
import com.learner.movieRecommendation.simulator.dto.TopNQueryRequest;
import com.learner.movieRecommendation.simulator.dto.TopNQueryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-recommendation/simulator")
public class SimulatorController {

    // Simulator-specific recommender instance (non-shared)
    private final MovieRecommender recommender = new TrieBasedMovieRecommender();

    @PostMapping("/movie")
    public String addMovie(@RequestBody AddMovieRequest request) {
        recommender.addMovie(request.getName(), request.getRank());
        return "Movie added successfully";
    }

    @PostMapping("/top")
    public TopNQueryResponse getTopNMovies(@RequestBody TopNQueryRequest request) {
        List<String> top = recommender.getTopNMoviesWithPrefix(request.getPrefix(), request.getN());
        return new TopNQueryResponse(top);
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return recommender.getAllMovies();
    }

}
