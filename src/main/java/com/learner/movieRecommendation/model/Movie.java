package com.learner.movieRecommendation.model;

import lombok.Data;

@Data
public class Movie {
    private final String name;
    private final int rank;

    public Movie(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }
}
