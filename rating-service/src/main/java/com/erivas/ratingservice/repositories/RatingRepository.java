package com.erivas.ratingservice.repositories;

import com.erivas.ratingservice.models.Rating;
import com.erivas.ratingservice.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {

    @Query("select r.id as id, r.description as description, r.rating as rating, r.userId as userId, r.movie.id as movieId from RatingModel r where r.userId = ?1")
    List<Rating> findRatingsFromUserId(Long userId);

}

