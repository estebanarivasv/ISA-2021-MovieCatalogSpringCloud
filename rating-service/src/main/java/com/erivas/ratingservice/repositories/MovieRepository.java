package com.erivas.ratingservice.repositories;

import com.erivas.ratingservice.models.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}

