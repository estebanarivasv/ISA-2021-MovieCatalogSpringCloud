package com.erivas.movieservice.controllers;

import com.erivas.movieservice.models.Movie;
import com.erivas.movieservice.models.MovieModel;
import com.erivas.movieservice.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    public MovieRepository movieRepository;

    @RequestMapping("/{movieId}")
    public Movie getMovieInformation(@PathVariable("movieId") Long movieId) {

        return movieRepository.getMovie(movieId);

    }


}
