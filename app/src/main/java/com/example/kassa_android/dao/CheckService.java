package com.example.kassa_android.dao;

import com.example.kassa_android.models.Check;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CheckService {
    @GET("/checks")
    Call<List<Check>> getAllChecks();

    @POST("/checks")
    Call<Check> addNewCheck(@Body Check check);
}
