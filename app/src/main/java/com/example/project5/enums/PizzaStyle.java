package com.example.project5.enums;

/**
 * Holds enumeration data for pizza styles.
 * @author Aaron Newland, Dylan Pina
 */
public enum PizzaStyle {
    NY("New York Style"),
    CHICAGO("Chicago Style");

    private final String styleName;

    /**
     * Creates new pizza style enum object with given pizza style name.
     * @param styleName pizza style to create.
     */
    PizzaStyle(String styleName) {
        this.styleName = styleName;
    }

    /**
     * Provides a string representation of a PizzaStyle object.
     * @return String of PizzaStyle object.
     */
    @Override
    public String toString() {
        return this.styleName;
    }
}
