package com.erivas.moviecatalogservice.controllers;

import com.erivas.moviecatalogservice.models.CatalogModel;
import com.erivas.moviecatalogservice.models.MovieModel;
import com.erivas.moviecatalogservice.models.RatingModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogModel> getMoviesCatalog(@PathVariable Integer userId) {

        // todo: fix the rest template creation into a bean
        RestTemplate restTemplate = new RestTemplate();


        // This array would be changed when microservices communicate properly
        // Array of the movies the user has rated
        List<RatingModel> ratings = Arrays.asList(
                new RatingModel(1, 0.3),
                new RatingModel(2, 4.2),
                new RatingModel(3, 5.0)
        );

        // For each movie, we get its data.
        return ratings.stream()
                .map(ratingModel -> {
                    // Makes a GET method to the REST microservice call
                    // todo: fix url
                    MovieModel movieModel = restTemplate.getForObject(
                            "http://localhost:8082/movies/" + ratingModel.getMovieId(),
                            MovieModel.class);
                    assert movieModel != null;
                    return new CatalogModel(movieModel.getName(), "Short movie", ratingModel.getRating());
                }).collect(Collectors.toList());
    }
}
