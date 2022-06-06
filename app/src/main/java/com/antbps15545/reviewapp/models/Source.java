package com.antbps15545.reviewapp.models;

import java.io.Serializable;

public class Source implements Serializable {
    private int id;
    private String title;
    private String link;
    private String s_link;

    public Source(String title, String link, String s_link) {
        this.title = title;
        this.link = link;
        this.s_link = s_link;
    }

    public Source() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getS_link() {
        return s_link;
    }

    public void setS_link(String s_link) {
        this.s_link = s_link;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
