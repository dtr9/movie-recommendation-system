package com.learner.movieRecommendation.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
    Movie movie = null;
}
