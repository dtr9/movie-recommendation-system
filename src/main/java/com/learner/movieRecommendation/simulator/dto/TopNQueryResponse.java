package com.learner.movieRecommendation.simulator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TopNQueryResponse {
    private List<String> topMovies;
}
