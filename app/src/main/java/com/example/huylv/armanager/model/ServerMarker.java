package com.example.huylv.armanager.model;

/**
 * Created by huylv on 23-Feb-16.
 */
public class ServerMarker {
    long id;
    String name;
    ResponseImage url;
    ResponseImage iset;
    ResponseImage fset;
    ResponseImage fset3;
    String created_at;
    String updated_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResponseImage getUrl() {
        return url;
    }

    public void setUrl(ResponseImage url) {
        this.url = url;
    }

    public ResponseImage getIset() {
        return iset;
    }

    public void setIset(ResponseImage iset) {
        this.iset = iset;
    }

    public ResponseImage getFset() {
        return fset;
    }

    public void setFset(ResponseImage fset) {
        this.fset = fset;
    }

    public ResponseImage getFset3() {
        return fset3;
    }

    public void setFset3(ResponseImage fset3) {
        this.fset3 = fset3;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public ServerMarker(long id, String name, ResponseImage url, ResponseImage iset, ResponseImage fset, ResponseImage fset3, String created_at, String updated_at) {

        this.id = id;
        this.name = name;
        this.url = url;
        this.iset = iset;
        this.fset = fset;
        this.fset3 = fset3;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    private class ResponseImage {
        String url;
    }
}
