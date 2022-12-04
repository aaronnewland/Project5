package com.example.project5.enums;

/**
 * Holds enumeration data for pizza flavors.
 * @author Aaron Newland, Dylan Pina
 */
public enum Flavor {
    BUILD_YOUR_OWN("Build your own"),
    DELUXE("Deluxe"),
    BBQ_CHICKEN("BBQ Chicken"),
    MEATZZA("Meatzza");

    private final String flavorName;

    /**
     * Creates new flavor enum object with given flavor.
     * @param flavorName name of flavor to create.
     */
    Flavor(String flavorName) {
        this.flavorName = flavorName;
    }

    /**
     * Provides a string representation of a Flavor object.
     * @return String of Flavor object.
     */
    @Override
    public String toString() {
        return this.flavorName;
    }
}
