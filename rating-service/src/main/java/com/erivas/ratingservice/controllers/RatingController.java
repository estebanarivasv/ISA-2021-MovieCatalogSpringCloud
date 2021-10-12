package com.erivas.ratingservice.controllers;

import com.erivas.ratingservice.models.RatingModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @RequestMapping("/{movieId}")
    public RatingModel getRating(@PathVariable Integer movieId) {
        return new RatingModel(movieId, 5.6);
    }
}
