package com.example.project5;

import com.example.project5.enums.Crust;
import com.example.project5.enums.Size;
import com.example.project5.enums.Topping;
import com.example.project5.interfaces.Customizable;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds abstract data and methods for a Pizza.
 * @author Aaron Newland, Dylan Pina
 */
public abstract class Pizza implements Customizable, Cloneable {
    private List<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();

    /**
     * Constructor for Pizza using toppings.
     */
    public Pizza() {
        this.toppings = new ArrayList<>();
    }

    /**
     * Retrieves pizza toppings.
     * @return list of toppings.
     */
    public List<Topping> getToppings() {
        return toppings;
    }

    /**
     * Sets list of pizza toppings.
     * @param toppings list of toppings to be set.
     */
    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    /**
     * Retrieves pizza crust style.
     * @return crust style.
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * Sets pizza crust style.
     * @param crust crust style to be set.
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    /**
     * Retrieves size of pizza.
     * @return size of pizza.
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets size of pizza.
     * @param size size of pizza to be set.
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Clones the pizza object.
     * @return the cloned pizza object.
     * @throws CloneNotSupportedException if clone is not supported
     */
    public Object clone() throws CloneNotSupportedException { return super.clone(); }
}
