package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.project5.R;
import com.example.project5.RecyclerAdadpter;

public class ChicagoActivity extends AppCompatActivity {

    RecyclerView toppingRecycler;
    String availableToppings[];
    int images[] = {R.drawable.topping_sausage, R.drawable.topping_bbq_chicken,
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chicago);

        toppingRecycler = findViewById(R.id.chicagoToppingsRecycler);

        availableToppings = getResources().getStringArray(R.array.toppings);

        RecyclerAdadpter recyclerAdadpter = new RecyclerAdadpter(this, availableToppings, images);
        toppingRecycler.setAdapter(recyclerAdadpter);
        toppingRecycler.setLayoutManager(new LinearLayoutManager(this));

        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        large = findViewById(R.id.large);

        sizeGroup = findViewById(R.id.pizzaSize);
        pizzaFlavor = findViewById(R.id.pizzaFlavorChicago);

        crustType = findViewById(R.id.crustType);
        pizzaPrice = findViewById(R.id.pizzaPrice);

        pizzaImage = findViewById(R.id.chicagoImage);
    }

    @Override
    protected void onResume() {
        super.onResume();

        sizeGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            // how to access sizes
            //TODO: add price change association
           // if (checkedId == small.getId()) System.out.println("here");
        });
    }
}