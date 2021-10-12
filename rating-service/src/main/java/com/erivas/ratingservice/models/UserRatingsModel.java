package com.erivas.ratingservice.models;

import java.util.List;

public class UserRatingsModel {

    private List<RatingModel> userRatings;

    public List<RatingModel> getUserRatings() {
        return userRatings;
    }

    public void setUserRatings(List<RatingModel> userRatings) {
        this.userRatings = userRatings;
    }
}
