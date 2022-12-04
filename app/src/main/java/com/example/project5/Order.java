package com.example.project5;

import com.example.project5.interfaces.Customizable;

import java.util.ArrayList;

/**
 * Holds data and methods for an order of pizzas.
 * @author Aaron Newland, Dylan Pina
 */
public class Order implements Customizable {
    private static int _orderNumber;
    private static final double njSalesTaxPercentage = 0.06625;
    private int orderNumber;
    private ArrayList<Pizza> order;

    /**
     * Default constructor for a pizza Order.
     */
    public Order() {
        _orderNumber += 1;
        this.orderNumber = _orderNumber;
        this.order = new ArrayList<>();
    }

    /**
     * Constructor for pizza order using given list of pizzas.
     * @param order list of pizzas to add to order.
     */
    public Order(ArrayList<Pizza> order) {
        this();
        this.order = order;
    }

    /**
     * Retrieves order number.
     * @return order number.
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Retrieves pizza order.
     * @return order.
     */
    public ArrayList<Pizza> getOrder() {
        return order;
    }

    /**
     * Retrieves subtotal of pizza order.
     * @return subtotal of order.
     */
    public double getSubtotal() {
        int subtotal = 0;
        if (!order.isEmpty()) for (Pizza p : order) subtotal += p.price();
        return subtotal;
    }

    /**
     * Retrieves sales tax of pizza order.
     * @return sales tax of order.
     */
    public double getSalesTax() {
        return njSalesTaxPercentage * getSubtotal();
    }

    /**
     * Retrieves total cost of pizza order.
     * @return total cost of order.
     */
    public double getOrderTotal() {
        return getSubtotal() + getSalesTax();
    }

    /**
     * Adds Pizza object to pizza order.
     * @param obj Pizza to be added to order.
     * @return true if object is pizza and is added to order, false otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (!(obj instanceof Pizza)) return false;
        return order.add((Pizza) obj);
    }

    /**
     * Removes Pizza object from pizza order.
     * @param obj Pizza to be removed to order.
     * @return true if object is pizza and is removed from order, false otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if (!(obj instanceof Pizza)) return false;
        return order.remove((Pizza) obj);
    }

    /**
     * Provides a string representation of an Order object.
     * @return String of Order object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        order.forEach((pizza) -> sb.append(pizza + "\n"));
        int last = sb.lastIndexOf("\n");
        if (last >= 0) { sb.delete(last, sb.length()); }
        return sb.toString();
    }
}
