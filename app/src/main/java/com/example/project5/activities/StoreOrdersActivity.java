package com.example.project5.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project5.Order;
import com.example.project5.Pizza;
import com.example.project5.R;
import com.example.project5.StoreOrder;
/**
 * Activity that allows user to manage all orders for store.
 * @author Aaron Newland, Dylan Pina
 */
public class StoreOrdersActivity extends AppCompatActivity {
    public static StoreOrder storeOrder;
    private Order order;

    Spinner orderNumber;
    ListView orderList;
    TextView orderTotal;
    Button cancelOrder;

    ArrayAdapter<Pizza> listAdapter;
    ArrayAdapter<Integer> spinnerAdapter;

    /**
     * Connects all UI fields to appropriate resources
     * and sets up adapters for list view and spinner.
     * @param savedInstanceState saved instance state of application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_orders);

        orderNumber = findViewById(R.id.orderNumberSpinner);
        orderList = findViewById(R.id.storeOrdersList);
        orderTotal = findViewById(R.id.storeOrderTotal);
        cancelOrder = findViewById(R.id.cancelOrderButton);

        if (storeOrder != null) {
            spinnerAdapter = new ArrayAdapter<>(
                    this,
                    R.layout.list_view_layout,
                    R.id.pizzaInOrderList,
                    storeOrder.getOrderNumbers());
            orderNumber.setAdapter(spinnerAdapter);

            listAdapter = new ArrayAdapter<>(
                    this, R.layout.list_view_layout,
                    R.id.pizzaInOrderList);
                    orderList.setAdapter(listAdapter);
            updatePrice();
        }
    }

    /**
     * Contains listeners for UI in the store order activity. General running state of activity.
     */
    @Override
    protected void onResume() {
        super.onResume();

        orderNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Displays order based on order number selected from spinner.
             * @param parentView parent adapter view.
             * @param selectedItemView current view.
             * @param position item position.
             * @param id id to be checked.
             */
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                order = storeOrder.getOrderById(Integer.valueOf((Integer) orderNumber.getSelectedItem()));

                listAdapter.clear();
                listAdapter.addAll(order.getOrder());
                listAdapter.notifyDataSetChanged();

                updatePrice();
            }

            /**
             * Method for what to handle when nothing is selected.
             * @param parentView parent adapter view.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {  }
        });

        cancelOrder.setOnClickListener(view -> cancelOrder());
    }

    /**
     * Updates price field for current order.
     */
    private void updatePrice() {
        if (!listAdapter.isEmpty()) {
            orderTotal.setText(String.format("%,.2f", order.getOrderTotal()));
        } else {
            orderTotal.setText("0.00");
        }
    }

    /**
     * Updates order numbers, and maintains order number list.
     */
    private void updateOrderNumbers() {
        if (noStoreOrders()) {
            spinnerAdapter.clear();
            spinnerAdapter.notifyDataSetChanged();
            return;
        }
        storeOrder.getOrderNumbers().clear();
        storeOrder.getOrders().forEach(order -> storeOrder.getOrderNumbers().add(order.getOrderNumber()));
        spinnerAdapter.clear();
        if (!storeOrder.getOrders().isEmpty()) spinnerAdapter.addAll(storeOrder.getOrderNumbers());
        spinnerAdapter.notifyDataSetChanged();

        if (!storeOrder.getOrders().isEmpty()) orderNumber.setSelection(0);
    }

    /**
     * Checks if there are any store orders.
     * @return True if there is at least one order in the store, false otherwise.
     */
    private boolean noStoreOrders() {
        return storeOrder == null || storeOrder.getOrders().isEmpty();
    }

    /**
     * Cancels the currently selected order.
     */
    private void cancelOrder() {
        new AlertDialog.Builder(this)
                .setTitle("WARNING")
                .setMessage("Are you sure you want to cancel this order?")

                .setPositiveButton(R.string.dialogYes, (dialog, which) -> {
                    int displayedOrderIndex = storeOrder.getOrders().indexOf(order);
                    if (displayedOrderIndex == storeOrder.getOrders().size() - 1) displayedOrderIndex -= 1;
                    storeOrder.getOrders().remove(order);

                    if (storeOrder.getOrders().isEmpty()) {
                        listAdapter.clear();
                        listAdapter.notifyDataSetChanged();
                    }

                    updateOrderNumbers();
                    updatePrice();
                })

                .setNegativeButton(R.string.dialogNo, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}