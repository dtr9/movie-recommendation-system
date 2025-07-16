package com.learner.movieRecommendation.simulator.impl;

import com.learner.movieRecommendation.service.MovieRecommender;
import com.learner.movieRecommendation.simulator.MovieRecommendationSimulator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieRecommendationSimulatorImpl implements MovieRecommendationSimulator {

    @Override
    public void simulate(MovieRecommender recommender) {
        recommender.addMovie("Iron Man", 85);
        recommender.addMovie("Iron Man 2", 78);
        recommender.addMovie("Iron Lady", 65);
        recommender.addMovie("Ice Age", 88);
        recommender.addMovie("Inception", 95);
        recommender.addMovie("Icarus", 83);
        recommender.addMovie("Inside Out", 92);

        System.out.println("Top 3 for 'I': " + recommender.getTopNMoviesWithPrefix("I", 3));
        System.out.println("Top 2 for 'Iron': " + recommender.getTopNMoviesWithPrefix("Iron", 2));
        System.out.println("Top 5 for 'In': " + recommender.getTopNMoviesWithPrefix("In", 5));
    }
}
