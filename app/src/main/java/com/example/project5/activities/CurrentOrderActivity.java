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
import com.example.project5.StoreOrder;

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
            System.out.println(order.getOrder());
            orderNumber.setText(String.valueOf(order.getOrderNumber()));
            updatePrice();
        } else {
            orderNumber.setText("");
            subtotal.setText("0.00");
            salesTax.setText("0.00");
            total.setText("0.00");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        orderList.setOnItemClickListener(
                (adapterView, view, i, l) -> pizza = (Pizza) orderList.getItemAtPosition(i));

        removePizzaButton.setOnClickListener(view -> removePizza());
        clearOrderButton.setOnClickListener(view -> clearOrder());
        placeOrderButton.setOnClickListener(view -> placeOrder());
    }

    private void updatePrice() {
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

    private void clearOrder() {
        if (order == null) return;
        order = new Order();
        orderNumber.setText("");
        adapter.clear();
        updatePrice();
    }

    private void placeOrder() {
        if (order == null || order.getOrder() == null) return;
        if (StoreOrdersActivity.storeOrder == null) {
            StoreOrdersActivity.storeOrder = new StoreOrder();
        }
        StoreOrdersActivity.storeOrder.add(order);
        System.out.println(StoreOrdersActivity.storeOrder);
        System.out.println(StoreOrdersActivity.storeOrder.getOrders().get(0).getOrder());
        clearOrder();
        adapter.clear();
        updatePrice();
    }

}