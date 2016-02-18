package com.example.huylv.armanager.model;

import java.io.File;

/**
 * Created by huylv on 16-Feb-16.
 */
public class Marker {
    private File fset;
    private File fset3;
    private File iset;

    private String fsetLink;
    private String fset3Link;
    private String isetLink;

    private long id;
    private String name;

    public File getFset() {
        return fset;
    }

    public void setFset(File fset) {
        this.fset = fset;
    }

    public File getFset3() {
        return fset3;
    }

    public void setFset3(File fset3) {
        this.fset3 = fset3;
    }

    public File getIset() {
        return iset;
    }

    public void setIset(File iset) {
        this.iset = iset;
    }

    public String getFsetLink() {
        return fsetLink;
    }

    public void setFsetLink(String fsetLink) {
        this.fsetLink = fsetLink;
    }

    public String getFset3Link() {
        return fset3Link;
    }

    public void setFset3Link(String fset3Link) {
        this.fset3Link = fset3Link;
    }

    public String getIsetLink() {
        return isetLink;
    }

    public void setIsetLink(String isetLink) {
        this.isetLink = isetLink;
    }

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
}
