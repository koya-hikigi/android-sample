package com.example.layoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //     setContentView(R.layout.activity_main);

        TextView textView = new TextView(this);
        textView.setText("テキスト");
        textView.setTextSize(24.0F);
        textView.setTextColor(getResources().getColor(android.R.color.holo_orange_light));

        setContentView(textView);
    }
}
