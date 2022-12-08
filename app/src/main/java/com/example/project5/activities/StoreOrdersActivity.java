package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project5.Order;
import com.example.project5.Pizza;
import com.example.project5.R;
import com.example.project5.StoreOrder;

public class StoreOrdersActivity extends AppCompatActivity {
    public static StoreOrder storeOrder;
    private Order order;

    Spinner orderNumber;
    ListView orderList;
    TextView orderTotal;
    Button cancelOrder;

    ArrayAdapter<Pizza> listAdapter;
    ArrayAdapter<Integer> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);

        orderNumber = findViewById(R.id.orderNumberSpinner);
        orderList = findViewById(R.id.storeOrdersList);
        orderTotal = findViewById(R.id.storeOrderTotal);
        cancelOrder = findViewById(R.id.cancelOrderButton);

        System.out.println(storeOrder);
        System.out.println(storeOrder.getOrders().get(0).getOrder());

        if (storeOrder != null) {
            spinnerAdapter = new ArrayAdapter<>(
                    this,
                    R.layout.list_view_layout,
                    R.id.pizzaInOrderList,
                    storeOrder.getOrderNumbers());
            orderNumber.setAdapter(spinnerAdapter);

//            listAdapter = new ArrayAdapter<>(
//                    this, R.layout.list_view_layout,
//                    R.id.pizzaInOrderList,
//                    storeOrder.getOrders().get(0).getOrder());
//            orderList.setAdapter(listAdapter);


            updatePrice();
        } else {
            orderTotal.setText("0.00");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void updatePrice() {
        orderTotal.setText(String.format("%,.2f", storeOrder.getOrders().get(0).getOrderTotal()));
    }

    private void updateOrderNumbers() {
        if (noStoreOrders()) return;
        storeOrder.getOrderNumbers().clear();

    }

    private boolean noStoreOrders() {
        return storeOrder == null || storeOrder.getOrders().isEmpty();
    }
}