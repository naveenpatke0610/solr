package com.example.solr.service;

import com.example.solr.model.Film;
import com.example.solr.model.TechProducts;

import java.util.List;

public interface ISolrService {
    List<TechProducts> getTechProducts();

    List<Film> getFilmsByName(String category);

    String saveFilm(Film film);
}
