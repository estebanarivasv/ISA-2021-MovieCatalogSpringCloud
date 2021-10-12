package com.erivas.movieservice.controllers;

import com.erivas.movieservice.models.MovieModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @RequestMapping("/{movieId}")
    public MovieModel getMovieInformation(@PathVariable("movieId") Long movieId) {

        return new MovieModel(movieId, "Harry Potter");

    }


}
