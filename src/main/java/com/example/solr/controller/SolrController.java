package com.example.solr.controller;

import com.example.solr.model.Film;
import com.example.solr.model.TechProducts;
import com.example.solr.serviceImpl.SolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolrController {

    @Autowired
    SolrService solrService;

    @GetMapping("/get-tech-products")
    public List<TechProducts> getTechProducts() {
        return solrService.getTechProducts();
    }

    @GetMapping("/get-films-by-name")
    public List<Film> getFilmsByName(@RequestParam String name) {
        return solrService.getFilmsByName(name);
    }

    @PostMapping("/film")
    public String saveFilm(@RequestBody Film film) {
        return solrService.saveFilm(film);
    }
}
