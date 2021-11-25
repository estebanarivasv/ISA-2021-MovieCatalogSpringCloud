package com.erivas.ratingservice.controllers;

import com.erivas.ratingservice.models.Rating;
import com.erivas.ratingservice.models.RatingModel;
import com.erivas.ratingservice.models.UserRatings;
import com.erivas.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    public RatingRepository ratingRepository;

    @GetMapping("users/{userId}")
    public UserRatings getUserRatings(@PathVariable Long userId) {

        List<Rating> ratings = ratingRepository.findRatingsFromUserId(userId);
        UserRatings userRatingsModel = new UserRatings();
        userRatingsModel.setUserRatings(ratings);
        return userRatingsModel;
    }

}
