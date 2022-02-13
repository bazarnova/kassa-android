package com.example.kassa_android.listeners;

import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kassa_android.dao.CheckService;
import com.example.kassa_android.models.Check;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class CheckAddListener extends AppCompatActivity implements View.OnClickListener {

    private Check check;

    public CheckAddListener(Check check) {
        this.check = check;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View v) {
        Retrofit retrofit1 = new Retrofit.Builder()
                .baseUrl("http://192.168.1.124:8080/")
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)))
                .build();

        CheckService checkService = retrofit1.create(CheckService.class);
        Call<Check> checkCall = checkService.addNewCheck(check);
        checkCall.enqueue(new Callback<Check>() {
            @Override
            public void onResponse(Call<Check> call, Response<Check> response) {
                if (response.body() == null) {
                    Log.d("Response", response.toString());
                } else {
                    Log.d("Response", response.body().toString());
                }

            }

            @Override
            public void onFailure(Call<Check> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
