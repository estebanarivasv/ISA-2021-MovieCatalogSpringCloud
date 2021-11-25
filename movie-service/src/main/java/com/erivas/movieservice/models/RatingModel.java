package com.erivas.movieservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class RatingModel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private Double rating;
    private String description;
    private Long userId;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private MovieModel movie;
}
