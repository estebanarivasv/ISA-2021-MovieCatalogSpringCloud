package com.erivas.moviecatalogservice.models;

public class RatingModel {
    private Long id;
    private String description;
    private Double rating;
    private Long userId;
    private Long movieId;

    public RatingModel() {
    }

    public RatingModel(Long id, String description, Double rating, Long userId, Long movieId) {
        this.id = id;
        this.description = description;
        this.rating = rating;
        this.userId = userId;
        this.movieId = movieId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
