package com.example.solr.config;

import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class solrConfig {

    @Bean
    public CloudSolrClient getSolrClient() {
        final List<String> zkServers = new ArrayList<>();
        zkServers.add("localhost:9983");
        return new CloudSolrClient.Builder(zkServers, Optional.empty()).build();
    }
}
