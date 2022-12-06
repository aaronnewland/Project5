package com.example.project5;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project5.enums.Topping;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] availableToppings;
    private ArrayList<Topping> selectedToppingsList;
    private SparseBooleanArray selectedToppings;
    private ToppingCheckboxClickListener toppingCheckboxClickListener;
    private int[] images;
    private Context context;
    private int toppingCount;
    private boolean hasCheckedBox;

    public RecyclerAdapter(Context context, String availableToppings[], int images[]) {
        this.context = context;
        this.availableToppings = availableToppings;
        this.selectedToppingsList = new ArrayList<>();
        this.selectedToppings = new SparseBooleanArray();
        this.images = images;
        this.toppingCount = 0;
        this.hasCheckedBox = true;
    }

    public RecyclerAdapter(Context context, String availableToppings[], int images[],
                           ToppingCheckboxClickListener toppingCheckboxClickListener) {
        this(context, availableToppings, images);
        this.toppingCheckboxClickListener = toppingCheckboxClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
        holder.checkBox.setText(availableToppings[position]);
        holder.image.setImageResource(images[position]);

        if (!hasCheckedBox) {
            holder.checkBox.setChecked(false);
            for (int i = 0; i < selectedToppings.size(); i++) {
                selectedToppings.put(i, false);
            }
            hasCheckedBox = true;
        }

    }

    @Override
    public int getItemCount() {
        if (availableToppings == null) return 0;
        return availableToppings.length;
    }

    public List<Topping> getSelectedToppingsList() {
        return selectedToppingsList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CheckBox checkBox;
        ImageView image;
        int position;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.toppingCheckBox);
            image = itemView.findViewById(R.id.toppingImageView);
            checkBox.setOnClickListener(this);
        }

        public void bind(int position) {
            this.position = position;
            if (!selectedToppings.get(position, false)) {
                checkBox.setChecked(false);
            } else {
                checkBox.setChecked(true);
            }
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            String toppingName = availableToppings[adapterPosition];

            if (!selectedToppings.get(adapterPosition, false)) {
                if (toppingCount < 7) {
                    checkBox.setChecked(true);
                    selectedToppingsList.add(getTopping(toppingName));
                    selectedToppings.put(adapterPosition, true);
                    toppingCount++;
                }
            } else  {
                checkBox.setChecked(false);
                selectedToppingsList.remove(getTopping(toppingName));
                selectedToppings.put(adapterPosition, false);
                toppingCount--;
            }
            toppingCheckboxClickListener.onToppingCheckboxClick();
            notifyDataSetChanged();
        }

        private Topping getTopping(String toppingName) {
            switch(toppingName) {
                case "Sausage": return Topping.SAUSAGE;
                case "BBQ Chicken": return Topping.BBQ_CHICKEN;
                case "Beef": return Topping.BEEF;
                case "Ham": return Topping.HAM;
                case "Pepperoni": return Topping.PEPPERONI;
                case "Green Pepper": return Topping.GREEN_PEPPER;
                case "Onion": return Topping.ONION;
                case "Mushroom": return Topping.MUSHROOM;
                case "Pineapple": return Topping.PINEAPPLE;
                case "Black Olives": return Topping.BLACK_OLIVES;
                case "Provolone": return Topping.PROVOLONE;
                case "Spinach": return Topping.SPINACH;
                case "Cheddar": return Topping.CHEDDAR;
                default: return null;
            }
        }
    }

    public void unCheckAll() {
        hasCheckedBox = false;
        selectedToppingsList.clear();
        toppingCount = 0;
        notifyDataSetChanged();
    }

    public interface ToppingCheckboxClickListener {
        void onToppingCheckboxClick();
    }
}
