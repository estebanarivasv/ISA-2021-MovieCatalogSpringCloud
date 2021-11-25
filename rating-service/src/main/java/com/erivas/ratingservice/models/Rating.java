package com.erivas.ratingservice.models;

public interface Rating {
    Long getId();
    Double getRating();
    String getDescription();
    Long getUserId();
    Long getMovieId();

}
