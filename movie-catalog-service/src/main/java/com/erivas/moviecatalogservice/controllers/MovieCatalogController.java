package com.erivas.moviecatalogservice.controllers;

import com.erivas.moviecatalogservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public UserCatalogModel getMoviesCatalog(@PathVariable Integer userId) {

        // Get all ratings data by userId from Ratings Microservice
        UserRatingsModel ratings = restTemplate
                .getForObject(
                        "http://rating-service/ratings/users/" + userId,
                        UserRatingsModel.class
                );

        // For each movie, we get its data.
        assert ratings != null;

        List<CatalogModel> userCatalog = ratings.getUserRatings().stream()
                .map(ratingModel -> {
                    // Get movie data from Movie Microservice
                    MovieModel movieModel = restTemplate.getForObject(
                            "http://movie-service/movies/" + ratingModel.getMovieId(),
                            MovieModel.class);
                    assert movieModel != null;
                    return new CatalogModel(movieModel.getName(), "Short movie", ratingModel.getRating());
                }).collect(Collectors.toList());

        UserCatalogModel userCatalogModel = new UserCatalogModel();
        userCatalogModel.setUserCatalog(userCatalog);
        return userCatalogModel;
    }
}

