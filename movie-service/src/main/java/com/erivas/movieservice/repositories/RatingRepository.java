package com.erivas.movieservice.repositories;

import com.erivas.movieservice.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {

}

