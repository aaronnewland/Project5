package com.example.project5.enums;

/**
 * Holds enumeration data for crust styles.
 * @author Aaron Newland, Dylan Pina
 */
public enum Crust {
    DEEP_DISH("Deep Dish"),
    PAN("Pan"),
    STUFFED("Stuffed"),
    BROOKLYN("Brookyln"),
    THIN("Thin"),
    HAND_TOSSED("Hand Tossed");

    private final String crustName;

    /**
     * Creates new crust enum object with given crust.
     * @param crust crust style to create.
     */
    Crust(String crust) {
        this.crustName = crust;
    }

    /**
     * Provides a string representation of a Crust object.
     * @return String of Crust object.
     */
    @Override
    public String toString() {
        return this.crustName;
    }
}
