package com.learner.movieRecommendation.simulator.dto;

import lombok.Data;

@Data
public class AddMovieRequest {
    private String name;
    private int rank;
}
