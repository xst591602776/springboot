package com.ebchinatech.search.model;

import java.sql.Date;

public class Mayday {
    private long id;
    private String title;
    private String content;
    private String href;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title= title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }



    public String getHref() {
        return href;
    }
    public void setHref(String href) {
        this.href = href;
    }





    @Override
    public String toString() {
        return "Mayday [id=" + id + ", title=" + title + ", content=" + content + ", href=" + href + "]";
    }

}

