package com.example.kassa_android.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kassa_android.R;
import com.example.kassa_android.listeners.CheckAddListener;
import com.example.kassa_android.models.Check;

import java.util.Calendar;
import java.util.Date;

public class CheckAddActivity extends AppCompatActivity {

    private final Check check = new Check();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_check);


        TextView currentDateTime = findViewById(R.id.dateButton);
        currentDateTime.setText(
                DateUtils.formatDateTime(this, new Date().getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR)
        );
        check.setDate(new Date().getTime());
        currentDateTime.setOnClickListener(
                //listener
                v -> {
                    Calendar dateAndTime = Calendar.getInstance();

                    new DatePickerDialog(CheckAddActivity.this,
                            // Listener
                            (view, year, monthOfYear, dayOfMonth) -> {
                                dateAndTime.set(Calendar.YEAR, year);
                                dateAndTime.set(Calendar.MONTH, monthOfYear);
                                dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                                check.setDate(dateAndTime.getTimeInMillis());
                                currentDateTime.setText(
                                        DateUtils.formatDateTime(this, dateAndTime.getTimeInMillis(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR)
                                );
                            },
                            dateAndTime.get(Calendar.YEAR),
                            dateAndTime.get(Calendar.MONTH),
                            dateAndTime.get(Calendar.DAY_OF_MONTH))
                            .show();
                }
        );


        TextView editTextCheckSum = (TextView) findViewById(R.id.editTextCheckSum);
        editTextCheckSum.setOnFocusChangeListener(
                (v, hasFocus) -> {
                    if (hasFocus) {
                        if (editTextCheckSum.getText().toString().trim().equals("0")) {
                            editTextCheckSum.setText("");
                        }
                    } else {
                        if (editTextCheckSum.getText() == null || editTextCheckSum.getText().toString().isEmpty()) {
                            editTextCheckSum.setText("0");
                        } else {
                            check.setSumAmount(Double.valueOf(editTextCheckSum.getText().toString()));
                        }
                    }
                }
        );

        TextView editTextShopName = (TextView) findViewById(R.id.editTextShopName);
        editTextShopName.setOnFocusChangeListener(
                (v, hasFocus) -> {
                    if (hasFocus) {
                        if (editTextShopName.getText().toString().trim().equals("Shop name")) {
                            editTextShopName.setText("");
                        }
                    } else {
                        if (editTextShopName.getText() == null || editTextShopName.getText().toString().isEmpty()) {
                            editTextShopName.setText("Shop name");
                        } else {
                            check.setShopName(editTextShopName.getText().toString());
                        }
                    }
                }
        );

        TextView editTextComment = (TextView) findViewById(R.id.editTextComment);
        editTextComment.setOnFocusChangeListener(
                (v, hasFocus) -> {
                    check.setComment(editTextComment.getText().toString());
                }
        );


        CheckAddListener checkAddListener = new CheckAddListener(check);

        Button buttonAddCheck = (Button) findViewById(R.id.buttonAddCheck);
        buttonAddCheck.setOnClickListener(checkAddListener);
    }

}