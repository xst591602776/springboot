package com.ebchinatech.search.model;

import org.apache.solr.client.solrj.beans.Field;


public class Solr {

    @Field("date")
    private String date;

    @Field("tstamp")
    private  String tstamp;

    @Field("digest")
    private String digest;

    @Field("boost")
    private String boost;

    @Field("id")
    private String id;

    @Field("title")
    private String title;



    @Field("content")
    private String content;

    @Field("url")
    private String url;


    private String _version_;







    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }



    public String getContent(){return content; }
    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTstamp() {
        return tstamp;
    }

    public void setTstamp(String tstamp) {
        this.tstamp = tstamp;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getBoost() {
        return boost;
    }

    public void setBoost(String boost) {
        this.boost = boost;
    }

    public String get_version_() {
        return _version_;
    }

    public void set_version_(String _version_) {
        this._version_ = _version_;
    }

    @Override
    public String toString() {
        return "{" +
                "date=" + date  +
                ", \ntstamp='" + tstamp +
                ", \ndigest='" + digest  +
                ", \nboost='" + boost +
                ", \nid='" + id  +
                ", \ntitle='" + title +
                ", \ncontent='" + content  +
                ", \nurl='" + url  +
                ", \n_version_='" + _version_  +
                '}';
    }

}
