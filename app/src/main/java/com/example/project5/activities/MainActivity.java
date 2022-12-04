package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.project5.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton chicagoButton;
    private ImageButton nyButton;

    //Instantiate class-scope variables in onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chicagoButton = findViewById(R.id.chicagoButton);
        nyButton = findViewById(R.id.nyButton);
    }

    //State of user interaction
    @Override
    protected void onResume() {
        super.onResume();
        Intent chicagoIntent = new Intent(this, ChicagoActivity.class);
        Intent nyIntent = new Intent(this, NY_Activity.class);
        chicagoButton.setOnClickListener(view -> startActivity(chicagoIntent));
        nyButton.setOnClickListener(view -> startActivity(nyIntent));
    }


}