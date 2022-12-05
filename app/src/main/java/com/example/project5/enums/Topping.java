package com.example.project5.enums;

/**
 * Holds enumeration data for pizza styles.
 * @author Aaron Newland, Dylan Pina
 */
public enum Topping {
    SAUSAGE("Sausage"),
    BBQ_CHICKEN("BBQ Chicken"),
    BEEF("Beef"),
    HAM("Ham"),
    PEPPERONI("Pepperoni"),
    GREEN_PEPPER("Green Pepper"),
    ONION("Onion"),
    MUSHROOM("Mushroom"),
    PINEAPPLE("Pineapple"),
    BLACK_OLIVES("Black Olives"),
    PROVOLONE("Provolone"),
    SPINACH("Spinach"),
    CHEDDAR("Cheddar");

    private final String toppingName;

    /**
     * Creates new topping enum object with given topping.
     * @param topping topping to create.
     */
    Topping(String topping) {
        this.toppingName = topping;
    }

    /**
     * Provides a string representation of a Topping object.
     * @return String of Topping object.
     */
    @Override
    public String toString() {
        return this.toppingName;
    }
}
