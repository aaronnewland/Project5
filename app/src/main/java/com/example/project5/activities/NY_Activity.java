package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project5.Order;
import com.example.project5.Pizza;
import com.example.project5.R;
import com.example.project5.RecyclerAdapter;
import com.example.project5.enums.Crust;
import com.example.project5.enums.Flavor;
import com.example.project5.enums.Size;
import com.example.project5.interfaces.PizzaFactory;
import com.example.project5.pizzastyles.NYPizza;

public class NY_Activity extends AppCompatActivity {

    private PizzaFactory pizzaFactory;
    private Pizza pizza;
    private String[] availableToppings;
    private Flavor selectedFlavor;
    private Size selectedSize;

    RecyclerView toppingRecycler;
    RecyclerAdapter recyclerAdapter;
    int[] images = {R.drawable.topping_sausage, R.drawable.topping_bbq_chicken,
            R.drawable.topping_beef,R.drawable.topping_ham, R.drawable.topping_pepperoni,
            R.drawable.topping_green_pepper, R.drawable.topping_onion, R.drawable.topping_mushroom,
            R.drawable.topping_pineapple, R.drawable.topping_black_olives,
            R.drawable.topping_provolone, R.drawable.topping_spinach, R.drawable.topping_cheddar};
    ImageView pizzaImage;
    RadioButton small, medium, large;
    RadioGroup sizeGroup;
    Spinner pizzaFlavor;
    TextView crustType;
    TextView pizzaPrice;
    Button addToOrderButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ny);
        toppingRecycler = findViewById(R.id.nyToppingsRecycler);
        availableToppings = getResources().getStringArray(R.array.toppings);

        recyclerAdapter = new RecyclerAdapter(this, availableToppings, images, () -> {
            pizza.setToppings(recyclerAdapter.getSelectedToppingsList());
            getCalculatedPrice();
            System.out.println(pizza.getToppings());
        }
        );
        toppingRecycler.setAdapter(recyclerAdapter);
        toppingRecycler.setLayoutManager(new LinearLayoutManager(this));
        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);
        small.toggle();
        sizeGroup = findViewById(R.id.pizzaSize);
        pizzaFlavor = findViewById(R.id.pizzaFlavorNY);
        crustType = findViewById(R.id.NY_CrustType);
        pizzaPrice = findViewById(R.id.NY_PizzaPrice);
        pizzaImage = findViewById(R.id.nyImage);
        addToOrderButton = findViewById(R.id.NY_AddToOrderButton);

        resetPizza();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sizeGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> handleSizeChange(checkedId));
        pizzaFlavor.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch((int) id) {
                            case 0:
                                setBuildYourOwn();
                                break;
                            case 1:
                                setDeluxe();
                                break;
                            case 2:
                                setBBQChicken();
                                break;
                            case 3:
                                setMeatzza();
                                break;
                        }
                        setPizzaStyleImage();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {}
                });
        addToOrderButton.setOnClickListener(view -> addToOrder());
    }

    private void handleSizeChange(int checkedId) {
        switch(checkedId) {
            case R.id.small:
                selectedSize = Size.SMALL;
                break;
            case R.id.medium:
                selectedSize = Size.MEDIUM;
                break;
            case R.id.large:
                selectedSize = Size.LARGE;
                break;
        }
        pizza.setSize(selectedSize);
        getCalculatedPrice();
    }

    /**
     * Sets fields for Deluxe pizza as created by the pizzeria.
     */
    private void setDeluxe() {
        pizza = pizzaFactory.createDeluxe();
        selectedFlavor = Flavor.DELUXE;
        pizza.setCrust(Crust.BROOKLYN);
        pizza.setSize(selectedSize);
        crustType.setText(Crust.BROOKLYN.toString());
        hideToppings();
        recyclerAdapter.unCheckAll();
        getCalculatedPrice();
    }

    /**
     * Sets fields for Meatzza pizza as created by the pizzeria.
     */
    private void setMeatzza() {
        pizza = pizzaFactory.createMeatzza();
        selectedFlavor = Flavor.MEATZZA;
        pizza.setCrust(Crust.HAND_TOSSED);
        pizza.setSize(selectedSize);
        crustType.setText(Crust.HAND_TOSSED.toString());
        hideToppings();
        recyclerAdapter.unCheckAll();
        getCalculatedPrice();
    }

    /**
     * Sets fields for BBQ Chicken pizza as created by the pizzeria.
     */
    private void setBBQChicken() {
        pizza = pizzaFactory.createBBQChicken();
        selectedFlavor = Flavor.BBQ_CHICKEN;
        pizza.setCrust(Crust.THIN);
        pizza.setSize(selectedSize);
        crustType.setText(Crust.THIN.toString());
        hideToppings();
        recyclerAdapter.unCheckAll();
        getCalculatedPrice();
    }

    /**
     * Sets fields for Build Your Own pizza as created by the pizzeria.
     */
    private void setBuildYourOwn() {
        pizza = pizzaFactory.createBuildYourOwn();
        selectedFlavor = Flavor.BUILD_YOUR_OWN;
        pizza.setCrust(Crust.HAND_TOSSED);
        pizza.setSize(selectedSize);
        crustType.setText(Crust.HAND_TOSSED.toString());
        showToppings();
        getCalculatedPrice();
    }

    /**
     * Hides toppings recycler list
     */
    private void hideToppings() {
        toppingRecycler.setVisibility(View.INVISIBLE);
    }

    /**
     * Displays toppings recycler list
     */
    private void showToppings() {
        toppingRecycler.setVisibility(View.VISIBLE);
    }

    /**
     * Gets the pizza style image
     * @return Image of pizza style
     */
    private void setPizzaStyleImage() {
        switch (selectedFlavor) {
            case BUILD_YOUR_OWN:
                pizzaImage.setImageResource(R.drawable.nyc_style_pizza);
                return;
            case BBQ_CHICKEN:
                pizzaImage.setImageResource(R.drawable.nyc_style_pizza_bbq);
                return;
            case MEATZZA:
                pizzaImage.setImageResource(R.drawable.nyc_style_pizza_meatzza);
                return;
            case DELUXE:
                pizzaImage.setImageResource(R.drawable.nyc_style_pizza_deluxe);
                return;
        }
    }

    private void addToOrder() {
        if (CurrentOrderActivity.order == null) CurrentOrderActivity.order = new Order();
        CurrentOrderActivity.order.add(clonedPizza());
        resetPizza();
        recyclerAdapter.unCheckAll();
    }

    private void resetPizza() {
        pizzaFactory = new NYPizza();
        pizza = pizzaFactory.createBuildYourOwn();
        selectedFlavor = Flavor.BUILD_YOUR_OWN;
        selectedSize = Size.SMALL;
        small.toggle();
        setBuildYourOwn();
        pizzaFlavor.setSelection(0);
        setPizzaStyleImage();
    }

    /**
     * Sets text field for price of current pizza.
     */
    private void getCalculatedPrice() {
        pizzaPrice.setText(String.format("%,.2f", pizza.price()));
    }

    /**
     * @return Deep copy of pizza object
     */
    private Pizza clonedPizza() {
        Pizza clonedPizza = null;

        switch(selectedFlavor) {
            case BUILD_YOUR_OWN:
                clonedPizza = pizzaFactory.createBuildYourOwn();
                clonedPizza.getToppings().addAll(pizza.getToppings());
                break;
            case DELUXE:
                clonedPizza = pizzaFactory.createDeluxe();
                break;
            case BBQ_CHICKEN:
                clonedPizza = pizzaFactory.createBBQChicken();
                break;
            case MEATZZA:
                clonedPizza = pizzaFactory.createMeatzza();
                break;
        }

        clonedPizza.setCrust(pizza.getCrust());
        clonedPizza.setSize(pizza.getSize());

        return clonedPizza;
    }
}