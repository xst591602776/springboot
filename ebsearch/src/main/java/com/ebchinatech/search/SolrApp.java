package com.ebchinatech.search;

import com.ebchinatech.search.model.Solr;

import com.ebchinatech.search.service.Impel.SolrServiceImpl;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class SolrApp {
//    @Autowired
//    private SolrClient solrClient;

    private HttpSolrServer httpSolrServer;

    @Autowired
    private SolrServiceImpl solrServiceImpl;



    public void Add() throws Exception {
        Solr solr = new Solr();
        solr.setId(System.currentTimeMillis() + "");
        solr.setId("1416537175446");
        solr.setTitle("轻量级Java EE企业应用实战（第3版）：Struts2＋Spring3＋Hibernate整合开发（附CD光盘）");

        solr.setId("20190821-14：29");
        solr.setTitle("Java入门到实践（第3版）：（附CD光盘）");

        solr.setId("20190821-14：57");
        solr.setTitle("光大证券官方网站");
        solr.setUrl("http://www.ebscn.com/main/index.html");
        solr.setContent("光大证券官方网站、资金账户目录、阳光E账通目录");

        this.solrServiceImpl.add(solr);
    }


    public void Delete() throws Exception {
        this.solrServiceImpl.delete(Arrays.asList("1416537175446"));
    }


    public void Search() throws Exception {
        List<Solr> solrs = this.solrServiceImpl.search("光大", 1, 10);
        System.out.println(solrs.size());
        for (Solr solr : solrs) {
            System.out.println(solr);
        }
    }


    public void testDeleteByQuery() throws Exception{
//        httpSolrServer.deleteByQuery("*:*");
        httpSolrServer.deleteByQuery("id:1416537175446");
        httpSolrServer.commit();
    }

}
