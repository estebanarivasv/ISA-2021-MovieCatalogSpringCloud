package com.erivas.moviecatalogservice.client;

import com.erivas.moviecatalogservice.models.UserRatingsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="clientRatingService", url="http://rating-service")
public interface ClientRatingService {

    @RequestMapping("/ratings/users/{userId}")
    public UserRatingsModel getUserRatings(@PathVariable Integer userId);

}
