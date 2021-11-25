package com.erivas.moviecatalogservice.controllers;

import com.erivas.moviecatalogservice.clients.MovieServiceFeignClient;
import com.erivas.moviecatalogservice.clients.RatingServiceFeignClient;
import com.erivas.moviecatalogservice.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private MovieServiceFeignClient movieServiceFeignClient;

    @Autowired
    private RatingServiceFeignClient ratingServiceFeignClient;

    private static final Logger logger = LoggerFactory.getLogger(MovieCatalogController.class);

    @GetMapping("/{userId}")
    public Object getMoviesCatalog(@PathVariable Long userId) {
        try {

            // Get all ratings data by userId from Ratings Microservice
            UserRatingsModel ratings = ratingServiceFeignClient.getUserRatings(userId);
            logger.info("New request MOVIE-CATALOG-SERVICE to RATING-SERVICE: " + ratings);
            assert ratings != null;

        /*
        // SYNCRONIC WAY
        UserRatingsModel ratings = restTemplate
                .getForObject(
                        "http://rating-service/ratings/users/" + userId,
                        UserRatingsModel.class
                );
         */

            List<CatalogModel> userCatalog = ratings.getUserRatings().stream()
                    .map(ratingModel -> {
                        // Get movie data from Movie Microservice
                        MovieModel movieModel = movieServiceFeignClient.getMovie(ratingModel.getMovieId());
                        assert movieModel != null;
                        return new CatalogModel(
                                movieModel.getTitle(),
                                ratingModel.getRating(),
                                ratingModel.getDescription(),
                                ratingModel.getUserId());
                    }).collect(Collectors.toList());
            UserCatalogModel userCatalogModel = new UserCatalogModel();
            userCatalogModel.setUserCatalog(userCatalog);
            return userCatalogModel;
        } catch (Exception e) {
            logger.error("Application error in: [" + e.getClass().getName() + "]", e);
            return ("Application error in: [" + e.getClass().getName() + "]" + e);
        }
    }
}

