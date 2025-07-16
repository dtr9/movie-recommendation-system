package com.learner.movieRecommendation.service.impl;

import com.learner.movieRecommendation.model.Movie;
import com.learner.movieRecommendation.model.TrieNode;
import com.learner.movieRecommendation.service.MovieRecommender;

import java.util.*;

public class TrieBasedMovieRecommender implements MovieRecommender {
    private final TrieNode root = new TrieNode();

    @Override
    public void addMovie(String name, int rank) {
        TrieNode node = root;
        for (char ch : name.toCharArray()) {
            node = node.getChildren().computeIfAbsent(ch, c -> new TrieNode());
        }
        node.setEndOfWord(true);
        node.setMovie(new Movie(name, rank));
    }

    @Override
    public List<String> getTopNMoviesWithPrefix(String prefix, int n) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            node = node.getChildren().get(ch);
            if (node == null) return Collections.emptyList();
        }

        PriorityQueue<Movie> topNHeap = new PriorityQueue<>(Comparator.comparingInt(Movie::getRank).thenComparing(Movie::getName));
        collectMovies(node, topNHeap, n);

        List<Movie> sortedMovies = new ArrayList<>(topNHeap);
        sortedMovies.sort((a, b) -> b.getRank() - a.getRank());

        List<String> result = new ArrayList<>();
        for (Movie m : sortedMovies) {
            result.add(m.getName());
        }
        return result;
    }

    @Override
    public List<Movie> getAllMovies() {
        List<Movie> allMovies = new ArrayList<>();
        collectAllMovies(root, allMovies);
        return allMovies;
    }

    private void collectAllMovies(TrieNode node, List<Movie> movies) {
        if (node == null) return;

        if (node.isEndOfWord() && node.getMovie() != null) {
            movies.add(node.getMovie());
        }

        for (TrieNode child : node.getChildren().values()) {
            collectAllMovies(child, movies);
        }
    }


    private void collectMovies(TrieNode node, PriorityQueue<Movie> heap, int n) {
        if (node == null) return;

        if (node.isEndOfWord() && node.getMovie() != null) {
            heap.offer(node.getMovie());
            if (heap.size() > n) heap.poll();
        }

        for (TrieNode child : node.getChildren().values()) {
            collectMovies(child, heap, n);
        }
    }
}
