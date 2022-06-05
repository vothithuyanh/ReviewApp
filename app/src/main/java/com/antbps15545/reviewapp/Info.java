package com.antbps15545.reviewapp;

import java.io.Serializable;

public class Info implements Serializable {
    private String id;
    private String title;
    private String server;
    private String link;

    public Info(String id, String title, String server, String link) {
        this.id = id;
        this.title = title;
        this.server = server;
        this.link = link;
    }

    public Info() {

    }

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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
