package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project5.Order;
import com.example.project5.R;

public class CurrentOrderActivity extends AppCompatActivity {

    public static Order order;

    TextView orderNumber;
    TextView subtotal;
    TextView salesTax;
    TextView total;
    ListView orderList;
    Button removePizzaButton;
    Button clearOrderButton;
    Button placeOrderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        orderNumber = findViewById(R.id.orderNumber);
        subtotal = findViewById(R.id.subtotal);
        salesTax = findViewById(R.id.salesTax);
        total = findViewById(R.id.orderTotal);
        orderList = findViewById(R.id.currentOrderList);
        removePizzaButton = findViewById(R.id.removePizzaButton);
        clearOrderButton = findViewById(R.id.clearOrderButton);
        placeOrderButton = findViewById(R.id.placeOrderButton);

        System.out.println("----ORDER IN CURRENT ORDER---- " + order);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}