package com.example.project5.flavors;

import com.example.project5.Pizza;
import com.example.project5.enums.PizzaStyle;
import com.example.project5.enums.Topping;

/**
 * Holds data and methods for Build Your Own pizza flavor.
 * @author Aaron Newland, Dylan Pina
 */
public class BuildYourOwn extends Pizza {
    private static final double SMALL_PRICE = 8.99;
    private static final double MEDIUM_PRICE = 10.99;
    private static final double LARGE_PRICE = 12.99;
    private static final double TOPPING_PRICE = 1.59;
    private PizzaStyle pizzaStyle;

    /**
     * Constructor for Build Your Own pizza using given pizza style.
     * @param pizzaStyle pizzaStyle for Build Your Own pizza to be created with.
     */
    public BuildYourOwn(PizzaStyle pizzaStyle) {
        setPizzaStyle(pizzaStyle);
    }

    /**
     * Adds topping to pizza.
     * @param obj topping to be added to pizza.
     * @return true if topping is added to pizza, false otherwise.
     */
    @Override
    public boolean add(Object obj) {
        if (getToppings().size() >= 7) return false;
        else if (getToppings().add((Topping) obj)) return true;
        return false;
    }

    /**
     * Removes topping to pizza.
     * @param obj topping to be removed from pizza.
     * @return true if topping is removed from pizza, false otherwise.
     */
    @Override
    public boolean remove(Object obj) {
        if (getToppings().remove((Topping) obj)) return true;
        return false;
    }

    /**
     * Retrieves price for pizza depending on selected size and toppings.
     * @return price for selected pizza size.
     */
    @Override
    public double price() {
        double toppingsPrice = getToppings().size() * TOPPING_PRICE;
        switch (getSize()) {
            case SMALL:
                return SMALL_PRICE + toppingsPrice;
            case MEDIUM:
                return MEDIUM_PRICE + toppingsPrice;
            case LARGE:
                return LARGE_PRICE + toppingsPrice;
            default:
                return 0;
        }
    }

    /**
     * Retrieves pizza style. Chicago or NY.
     * @return pizza style for pizza.
     */
    public PizzaStyle getPizzaStyle() {
        return this.pizzaStyle;
    }

    /**
     * Sets pizza style. Chicago or NY.
     * @param pizzaStyle pizzaStyle to be set to.
     */
    public void setPizzaStyle(PizzaStyle pizzaStyle) {
        this.pizzaStyle = pizzaStyle;
    }

    /**
     * Provides a string representation of a BuildYourOwn object.
     * @return String of BuildYourOwn object.
     */
    @Override
    public String toString() {
        StringBuilder toppings = new StringBuilder();
        getToppings().forEach(topping -> toppings.append(topping + ", "));
        return "Build your own (" + getPizzaStyle() + " - " + getCrust() + "), " +
                toppings + getSize() + ", $" + String.format("%,.2f", price());
    }
}
