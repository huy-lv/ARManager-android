package com.example.huylv.armanager.model;

/**
 * Created by huylv on 20-Feb-16.
 */
public class MarkersOnline {
    MarkerOnline[] markers;

    public MarkersOnline(MarkerOnline[] markers) {
        this.markers = markers;
    }

    public MarkerOnline[] getMarkers() {
        return markers;
    }

    public void setMarkers(MarkerOnline[] markers) {
        this.markers = markers;
    }
}
