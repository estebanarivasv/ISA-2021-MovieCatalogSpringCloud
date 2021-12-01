package com.erivas.movieservice.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class MovieModel implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    @OneToMany(mappedBy="movie")
    private List<RatingModel> ratings;
}
