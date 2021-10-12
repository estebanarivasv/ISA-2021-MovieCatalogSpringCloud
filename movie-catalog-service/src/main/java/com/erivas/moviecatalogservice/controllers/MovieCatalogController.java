package com.erivas.moviecatalogservice.controllers;

import com.erivas.moviecatalogservice.models.CatalogModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @RequestMapping("/{userId}")
    public List<CatalogModel> getCatalog(@PathVariable String userId) {

        return Collections.singletonList(
                new CatalogModel("Avengers", "Short movie", 3)
        );
    }
}
