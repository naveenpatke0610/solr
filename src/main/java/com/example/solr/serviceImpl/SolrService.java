package com.example.solr.serviceImpl;

import com.example.solr.model.Film;
import com.example.solr.model.TechProducts;
import com.example.solr.service.ISolrService;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SolrService implements ISolrService {

    @Autowired
    CloudSolrClient cloudSolrClient;

    public List<TechProducts> getTechProducts() {

        final SolrQuery query = new SolrQuery("*:*");
//        query.addField("id");
//        query.addField("name");
        query.setSort("id", SolrQuery.ORDER.asc);

        final QueryResponse response;
        try {
            response = cloudSolrClient.query("techproducts", query);
        } catch (SolrServerException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return response.getBeans(TechProducts.class);
    }

    public String saveFilm(Film film) {
        final SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", film.getId());
        doc.addField("name", film.getName());
        doc.addField("directed_by", film.getDirectedBy());
        doc.addField("initial_release_date", film.getInitialReleaseDate());
        doc.addField("genre", film.getGenre());

        try {
            final UpdateResponse updateResponse = cloudSolrClient.add("film", doc);
            cloudSolrClient.commit("film");
            return "Record saved successfully";
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Film> getFilmsByName(String name) {

        final Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", "name:" + name.trim() + "*");
        queryParamMap.put("fl", "id, name");
        queryParamMap.put("sort", "id asc");
        MapSolrParams queryParams = new MapSolrParams(queryParamMap);

        final QueryResponse response;
        try {
            response = cloudSolrClient.query("film", queryParams);
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException(e);
        }
        return response.getBeans(Film.class);
    }
}
