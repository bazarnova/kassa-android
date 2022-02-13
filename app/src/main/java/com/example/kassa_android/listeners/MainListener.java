package com.example.kassa_android.listeners;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.kassa_android.R;
import com.example.kassa_android.activities.CheckAddActivity;
import com.example.kassa_android.dao.CheckService;
import com.example.kassa_android.models.Check;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MainListener extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewAllChecks;

    public MainListener(TextView textViewAllChecks) {
        this.textViewAllChecks = textViewAllChecks;
    }

    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.buttonGetAllChecks:
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.1.124:8080/")
                        .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)))
                        .build();
                CheckService checkService = retrofit.create(CheckService.class);
                Call<List<Check>> call = checkService.getAllChecks();

                call.enqueue(new Callback<List<Check>>() {
                    @Override
                    public void onResponse(Call<List<Check>> call, Response<List<Check>> response) {
                        if (response.body() == null) {
                            textViewAllChecks.setText("response.body() is null");
                            Log.d("Response", response.toString());

                        } else {
                            textViewAllChecks.setText(response.body().toString());
                            Log.d("Response", response.body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Check>> call, Throwable t) {
                        textViewAllChecks.setText("Error");
                        t.printStackTrace();
                    }
                });
                break;

            case R.id.buttonAddNewCheck:
                Intent intent = new Intent(v.getContext(), CheckAddActivity.class);
                v.getContext().startActivity(intent);

                break;

            case R.id.buttonEditCheck:
                textViewAllChecks.setText("Нажата кнопка EditCheck");
                Log.d("Response", "pressed editCheck");

                break;

        }

    }
}
