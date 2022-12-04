package com.example.project5.pizzastyles;

import com.example.project5.enums.Crust;
import com.example.project5.Pizza;
import com.example.project5.enums.PizzaStyle;
import com.example.project5.flavors.BBQChicken;
import com.example.project5.flavors.BuildYourOwn;
import com.example.project5.flavors.Deluxe;
import com.example.project5.flavors.Meatzza;
import com.example.project5.interfaces.PizzaFactory;

/**
 * Holds data and methods for NY pizza style.
 * @author Aaron Newland, Dylan Pina
 */
public class NYPizza implements PizzaFactory {
    /**
     * Creates Deluxe NY pizza with Brooklyn crust.
     * @return created Deluxe pizza.
     */
    @Override
    public Pizza createDeluxe() {
        Pizza NYStyleDeluxe = new Deluxe(PizzaStyle.NY);
        NYStyleDeluxe.setCrust(Crust.BROOKLYN);
        return NYStyleDeluxe;
    }

    /**
     * Creates Meatzza NY pizza with Stuffed crust.
     * @return created Meatzza pizza.
     */
    @Override
    public Pizza createMeatzza() {
       Pizza NYStyleMeatzza = new Meatzza(PizzaStyle.NY);
       NYStyleMeatzza.setCrust(Crust.STUFFED);
       return NYStyleMeatzza;
    }

    /**
     * Creates BBQ Chicken NY pizza with Hand Tossed crust.
     * @return created BBQ Chicken pizza.
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza NYStyleBBQChicken = new BBQChicken(PizzaStyle.NY);
        NYStyleBBQChicken.setCrust(Crust.HAND_TOSSED);
        return NYStyleBBQChicken;
    }

    /**
     * Creates Build Your Own NY pizza with Hand Tossed crust.
     * @return created Build Your Own pizza.
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza NYStyleBuildYourOwn = new BuildYourOwn(PizzaStyle.NY);
        NYStyleBuildYourOwn.setCrust(Crust.HAND_TOSSED);
        return NYStyleBuildYourOwn;
    }
}
