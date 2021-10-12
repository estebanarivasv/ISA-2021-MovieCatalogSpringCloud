package com.erivas.ratingservice.controllers;

import com.erivas.ratingservice.models.RatingModel;
import com.erivas.ratingservice.models.UserRatingsModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    /*
    @RequestMapping("/{movieId}")
    public RatingModel getRating(@PathVariable Integer movieId) {
        return new RatingModel(movieId, 5.6);
    }
    */

    @RequestMapping("users/{userId}")
    public UserRatingsModel getUserRatings(@PathVariable Integer userId) {
        List<RatingModel> ratings = Arrays.asList(
                new RatingModel(1, 0.3),
                new RatingModel(2, 4.2),
                new RatingModel(3, 5.0)
        );
        UserRatingsModel userRatingsModel = new UserRatingsModel();
        userRatingsModel.setUserRatings(ratings);
        return userRatingsModel;
    }




}
