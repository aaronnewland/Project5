package com.example.project5.interfaces;

import com.example.project5.Pizza;

/**
 * Holds interface data for PizzaFactory.
 * @author Aaron Newland, Dylan Pina
 */
public interface PizzaFactory {
    Pizza createDeluxe();
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
