package com.erivas.moviecatalogservice.clients;

import com.erivas.moviecatalogservice.models.UserRatingsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="rating-service", url="http://localhost:8083")
public interface RatingServiceFeignClient {

    @GetMapping("/ratings/users/{userId}")
    UserRatingsModel getUserRatings(@PathVariable Long userId);

}
