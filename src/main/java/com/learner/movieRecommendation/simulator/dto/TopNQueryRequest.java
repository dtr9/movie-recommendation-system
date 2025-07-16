package com.learner.movieRecommendation.simulator.dto;

import lombok.Data;

@Data
public class TopNQueryRequest {
    private String prefix;
    private int n;
}
