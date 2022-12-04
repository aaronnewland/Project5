package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import com.example.project5.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton chicagoButton;
    private ImageButton nyButton;
    private ImageButton currentOrderButton;
    private ImageButton storeOrdersButton;

    //Instantiate class-scope variables in onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chicagoButton = findViewById(R.id.chicagoButton);
        nyButton = findViewById(R.id.nyButton);
        currentOrderButton = findViewById(R.id.currentOrderButton);
        storeOrdersButton = findViewById(R.id.storeOrdersButton);
    }

    //State of user interaction
    @Override
    protected void onResume() {
        super.onResume();
        Intent chicagoIntent = new Intent(this, ChicagoActivity.class);
        Intent nyIntent = new Intent(this, NY_Activity.class);
        Intent currentOrderIntent = new Intent(this, CurrentOrderActivity.class);
        Intent storeOrdersIntent = new Intent(this, StoreOrdersActivity.class);
        chicagoButton.setOnClickListener(view -> startActivity(chicagoIntent));
        nyButton.setOnClickListener(view -> startActivity(nyIntent));
        currentOrderButton.setOnClickListener(view -> startActivity(currentOrderIntent));
        storeOrdersButton.setOnClickListener(view -> startActivity(storeOrdersIntent));
    }


}