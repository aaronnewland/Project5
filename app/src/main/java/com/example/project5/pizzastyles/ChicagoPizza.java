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
 * Holds data and methods for Chicago pizza style.
 * @author Aaron Newland, Dylan Pina
 */
public class ChicagoPizza implements PizzaFactory {
    /**
     * Creates Deluxe Chicago pizza with Deep Dish crust.
     * @return created Deluxe pizza.
     */
    @Override
    public Pizza createDeluxe() {
        Pizza ChicagoStyleDeluxe = new Deluxe(PizzaStyle.CHICAGO);
        ChicagoStyleDeluxe.setCrust(Crust.DEEP_DISH);
        return ChicagoStyleDeluxe;
    }

    /**
     * Creates Meatzza Chicago pizza with Stuffed crust.
     * @return created Meatzza pizza.
     */
    @Override
    public Pizza createMeatzza() {
        Pizza ChicagoStyleMeatzza = new Meatzza(PizzaStyle.CHICAGO);
        ChicagoStyleMeatzza.setCrust(Crust.STUFFED);
        return ChicagoStyleMeatzza;
    }

    /**
     * Creates BBQ Chicken Chicago pizza with Pan crust.
     * @return created BBQ Chicken pizza.
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza ChicagoStyleBBQChicken = new BBQChicken(PizzaStyle.CHICAGO);
        ChicagoStyleBBQChicken.setCrust(Crust.PAN);
        return ChicagoStyleBBQChicken;
    }

    /**
     * Creates Build Your Own Chicago pizza with Pan crust.
     * @return created Build Your Own pizza.
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza ChicagoStyleBuildYourOwn = new BuildYourOwn(PizzaStyle.CHICAGO);
        ChicagoStyleBuildYourOwn.setCrust(Crust.PAN);
        return ChicagoStyleBuildYourOwn;
    }
}
