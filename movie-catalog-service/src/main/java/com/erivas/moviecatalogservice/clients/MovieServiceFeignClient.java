package com.erivas.moviecatalogservice.clients;

import com.erivas.moviecatalogservice.models.MovieModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="movieService", url="http://localhost:8082")
public interface MovieServiceFeignClient {

    @GetMapping("/movies/{movieId}")
    MovieModel getMovie(@PathVariable Long movieId);

}
