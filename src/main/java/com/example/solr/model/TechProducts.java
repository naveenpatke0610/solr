package com.example.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechProducts {
    @Field
    private String id;
    @Field
    private ArrayList<String> cat;
    @Field
    private String name;
    @Field
    private double price;

    @Field(value = "price_c")
    private String priceC;
    @Field
    private boolean inStock;
    @Field
    private String author;

    @Field(value = "author_s")
    private String authorS;

    @Field(value = "series_t")
    private String seriesT;

    @Field(value = "sequence_i")
    private int sequenceI;

    @Field(value = "genre_s")
    private String genres;

    @Field(value = "_version_")
    private long version;

    @Field(value = "price_c____l_ns")
    private long priceCLNs;

    @Field(value = "name_exact")
    private String nameExact;

}