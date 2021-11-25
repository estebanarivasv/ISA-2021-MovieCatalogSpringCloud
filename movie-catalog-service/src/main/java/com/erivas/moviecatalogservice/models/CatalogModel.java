package com.erivas.moviecatalogservice.models;

public class CatalogModel {
    private String movie;
    private Double rating;
    private String description;
    private Long userId;

    public CatalogModel(String movie, Double rating, String description, Long userId) {
        this.movie = movie;
        this.rating = rating;
        this.description = description;
        this.userId = userId;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
