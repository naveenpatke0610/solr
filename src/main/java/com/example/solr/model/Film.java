package com.example.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Field
    private String id;
    @Field(value = "directed_by")
    private ArrayList<String> directedBy;
    @Field(value = "initial_release_date")
    private ArrayList<Date> initialReleaseDate;
    @Field
    private ArrayList<String> genre;
    @Field
    private String name;
    @Field(value = "_version_")
    private long version;
}
