package com.example.huylv.armanager.network;

import com.example.huylv.armanager.model.Post2Marker;
import com.example.huylv.armanager.model.ServerMarker;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by huylv on 22/02/2016.
 */
public interface MarkerService {
    @POST("/api/markers")
    Call<ServerMarker> create(@Body Post2Marker post2Marker);

    @GET("/api/markers")
    Call<ServerMarker[]> getAllMarker();
}
