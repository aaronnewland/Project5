package com.example.project5.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.project5.R;
import com.example.project5.RecyclerAdadpter;

public class NY_Activity extends AppCompatActivity {

    RecyclerView toppingRecycler;
    String availableToppings[];
    int images[] = {R.drawable.topping_sausage, R.drawable.topping_bbq_chicken,
            R.drawable.topping_beef,R.drawable.topping_ham, R.drawable.topping_pepperoni,
            R.drawable.topping_green_pepper, R.drawable.topping_onion, R.drawable.topping_mushroom,
            R.drawable.topping_pineapple, R.drawable.topping_black_olives,
            R.drawable.topping_provolone, R.drawable.topping_spinach, R.drawable.topping_cheddar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny);

        toppingRecycler = findViewById(R.id.nyToppingsRecycler);

        availableToppings = getResources().getStringArray(R.array.toppings);

        RecyclerAdadpter recyclerAdadpter = new RecyclerAdadpter(this, availableToppings, images);
        toppingRecycler.setAdapter(recyclerAdadpter);
        toppingRecycler.setLayoutManager(new LinearLayoutManager(this));
    }
}