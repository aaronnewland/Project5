package com.example.project5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton chicagoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chicagoButton = (ImageButton) findViewById(R.id.chicagoButton);
        System.out.println("here");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, ChicagoActivity.class);
        chicagoButton.setOnClickListener(view -> startActivity(intent));
    }


}