package com.example.project5;

import com.example.project5.interfaces.Customizable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Holds data and methods for all pizza orders.
 * @author Aaron Newland, Dylan Pina
 */
public class StoreOrder implements Customizable {
    private ArrayList<Order> orders;

    /**
     * Constuctor for StoreOder.
     */
    public StoreOrder() {
        this.orders = new ArrayList<>();
    }

    /**
     * Adds Order object to store orders.
     * @param obj Order to be added.
     * @return true if object is an order and is added, false otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof Order)) return false;
        return orders.add((Order) obj);
    }

    /**
     * Removes Order object to store orders.
     * @param obj Order to be removed.
     * @return true if object is an order and is removed, false otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof Order)) return false;
        return orders.remove((Order) obj);
    }

    /**
     * Retrieves all pizza orders.
     * @return list of orders.
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Retrieves all order numbers.
     * @return list of order numbers.
     */
    public ArrayList<Integer> getOrderNumbers() {
        ArrayList<Integer> orderNumbers = new ArrayList<>();
        if (!orders.isEmpty()) orders.forEach(order -> orderNumbers.add(order.getOrderNumber()));
        return orderNumbers;
    }

}
