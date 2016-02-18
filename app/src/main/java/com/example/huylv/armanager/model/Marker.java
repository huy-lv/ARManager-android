package com.example.huylv.armanager.model;

import com.example.huylv.armanager.util.Util;

import java.io.File;

/**
 * Created by huylv on 16-Feb-16.
 */
public class Marker {
    private File fset;
    private File fset3;
    private File iset;

    public Marker(File fset, File fset3, File iset, long id, String name) {
        this.fset = fset;
        this.fset3 = fset3;
        this.iset = iset;
        this.id = id;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Marker{" +
                "fset=" + fset +
                ", fset3=" + fset3 +
                ", iset=" + iset +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
