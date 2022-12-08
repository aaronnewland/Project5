package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.project5.Order;
import com.example.project5.Pizza;
import com.example.project5.R;

import java.util.ArrayList;
import java.util.List;

public class CurrentOrderActivity extends AppCompatActivity {

    public static Order order;
    private Pizza pizza;

    TextView orderNumber;
    TextView subtotal;
    TextView salesTax;
    TextView total;
    ListView orderList;
    Button removePizzaButton;
    Button clearOrderButton;
    Button placeOrderButton;

    ArrayAdapter<Pizza> adapter;


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

        if (order != null) {
            adapter = new ArrayAdapter<>(
                    this,
                    R.layout.list_view_layout,
                    R.id.pizzaInOrderList, order.getOrder());
            orderList.setAdapter(adapter);

            updatePrice();
        } else {
            orderNumber.setText("0");
            subtotal.setText("0");
            salesTax.setText("0");
            total.setText("0");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        orderList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                pizza = (Pizza) orderList.getItemAtPosition(i);
            }
        });

        removePizzaButton.setOnClickListener(view -> removePizza());
    }

    private void updatePrice() {
        orderNumber.setText(String.valueOf(order.getOrderNumber()));
        subtotal.setText(String.format("%,.2f", order.getSubtotal()));
        salesTax.setText(String.format("%,.2f", order.getSalesTax()));
        total.setText(String.format("%,.2f", order.getOrderTotal()));
    }

    private void removePizza() {
        if (pizza == null) return;
        order.remove(pizza);
        adapter.notifyDataSetChanged();
        updatePrice();
    }

}