package com.example.huylv.armanager.model;

/**
 * Created by huylv on 20-Feb-16.
 */
public class MarkerOnline {
    String name;
    String fset;
    String fset3;
    String iset;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFset() {
        return fset;
    }

    public void setFset(String fset) {
        this.fset = fset;
    }

    public String getFset3() {
        return fset3;
    }

    public void setFset3(String fset3) {
        this.fset3 = fset3;
    }

    public String getIset() {
        return iset;
    }

    public void setIset(String iset) {
        this.iset = iset;
    }

    public MarkerOnline(String name, String fset, String fset3, String iset) {
        this.name = name;

        this.fset = fset;
        this.fset3 = fset3;
        this.iset = iset;
    }
}
