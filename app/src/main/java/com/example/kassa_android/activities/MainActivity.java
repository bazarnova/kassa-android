package com.example.kassa_android.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.kassa_android.R;
import com.example.kassa_android.listeners.MainListener;

public class MainActivity extends AppCompatActivity {

    Button buttonGetAllChecks;
    Button buttonAddNewCheck;
    Button buttonEditCheck;

    private MainListener listener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listener = new MainListener((TextView) findViewById(R.id.textViewChecks));
        buttonGetAllChecks = (Button) findViewById(R.id.buttonGetAllChecks);
        buttonAddNewCheck = (Button) findViewById(R.id.buttonAddNewCheck);
        buttonEditCheck = (Button) findViewById(R.id.buttonEditCheck);

        buttonGetAllChecks.setOnClickListener(listener);
        buttonAddNewCheck.setOnClickListener(listener);
        buttonEditCheck.setOnClickListener(listener);
    }
}