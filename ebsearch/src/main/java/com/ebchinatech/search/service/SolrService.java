package com.ebchinatech.search.service;

import com.ebchinatech.search.model.Solr;

import java.util.List;

public interface SolrService {
    List<Solr> add();
    List<Solr> delete();
    List<Solr> search();

}
