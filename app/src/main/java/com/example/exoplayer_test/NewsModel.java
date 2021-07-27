package com.example.exoplayer_test;

public class NewsModel {

    private String id;
    private String url;
    private String header;
    private String body;

    public NewsModel(String id, String url, String header, String body) {
        this.id = id;
        this.url = url;
        this.header = header;
        this.body = body;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
