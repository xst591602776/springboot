package com.ebchinatech.search.service.Impel;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

public class HttpSolrServerSington {
    private static HttpSolrServer server;

    public static HttpSolrServer getServer(){
        if (server==null){
            String url = "http://localhost:8983/solr/new_core/";
            server = new HttpSolrServer(url); //定义solr的server
            server.setParser(new XMLResponseParser()); // 设置响应解析器
            server.setMaxRetries(1); // 设置重试次数，推荐设置为1
            server.setConnectionTimeout(500); // 建立连接的最长时间
        }
        return server;
    }
}
