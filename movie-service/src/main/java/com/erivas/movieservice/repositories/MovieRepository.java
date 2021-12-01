package com.erivas.movieservice.repositories;

import com.erivas.movieservice.models.Movie;
import com.erivas.movieservice.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {

    @Query("select m.id as id, m.title as title from MovieModel m where m.id = ?1")
    Movie getMovie(Long Id);
}

