package com.example.project5.enums;

/**
 * Holds enumeration data for pizza sizes.
 * @author Aaron Newland, Dylan Pina
 */
public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String sizeName;

    /**
     * Creates new size enum object with given crust.
     * @param size pizza size to create.
     */
    Size(String size) {
        this.sizeName = size;
    }

    /**
     * Provides a string representation of a Size object.
     * @return String of Size object.
     */
    @Override
    public String toString() {
        return this.sizeName;
    }
}
