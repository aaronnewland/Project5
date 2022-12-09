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
/**
 * Holds adapter data and methods for Recycler View.
 * @author Aaron Newland, Dylan Pina
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] availableToppings;
    private ArrayList<Topping> selectedToppingsList;
    private SparseBooleanArray selectedToppings;
    private ToppingCheckboxClickListener toppingCheckboxClickListener;
    private int[] images;
    private Context context;
    private int toppingCount;
    private boolean hasCheckedBox;

    /**
     * Constructor for RecyclerAdapter.
     * @param context information about application to be provided.
     * @param availableToppings String array of toppings available to add to pizza.
     * @param images Array of images for toppings available.
     */
    public RecyclerAdapter(Context context, String[] availableToppings, int[] images) {
        this.context = context;
        this.availableToppings = availableToppings;
        this.selectedToppingsList = new ArrayList<>();
        this.selectedToppings = new SparseBooleanArray();
        this.images = images;
        this.toppingCount = 0;
        this.hasCheckedBox = true;
    }

    /**
     * Constructor for Recycler Adapter that contains checkboxes.
     * @param context information about application to be provided.
     * @param availableToppings String array of toppings available to add to pizza.
     * @param images Array of images for toppings available.
     * @param toppingCheckboxClickListener listener for checkbox for toppings.
     */
    public RecyclerAdapter(Context context, String[] availableToppings, int[] images,
                           ToppingCheckboxClickListener toppingCheckboxClickListener) {
        this(context, availableToppings, images);
        this.toppingCheckboxClickListener = toppingCheckboxClickListener;
    }

    /**
     * Creates a viewholder on creation of view.
     * @param parent parent ViewGroup.
     * @param viewType intger value of viewType.
     * @return viewholder containing view.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_view, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Refreshes the recycler view to populate when scrolled.
     * @param holder ViewHolder to be passed.
     * @param position position of item to be selected.
     */
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

    /**
     * Gets the length of the String array of available toppings.
     * @return integer length of available toppings array.
     */
    @Override
    public int getItemCount() {
        if (availableToppings == null) return 0;
        return availableToppings.length;
    }

    /**
     * Retrieves the list of selected toppings.
     * @return List of selected toppings.
     */
    public List<Topping> getSelectedToppingsList() {
        return selectedToppingsList;
    }

    /**
     * Inner class for dealing with ViewHolder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        CheckBox checkBox;
        ImageView image;
        int position;

        /**
         * Constructor for ViewHolder.
         * @param itemView provides views to be added to ViewHolder.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.toppingCheckBox);
            image = itemView.findViewById(R.id.toppingImageView);
            checkBox.setOnClickListener(this);
        }

        /**
         * Binds the checkbox at desired position.
         * @param position position to be bound.
         */
        public void bind(int position) {
            this.position = position;
            checkBox.setChecked(selectedToppings.get(position, false));
        }

        /**
         * Handles click for adding toppings to pizza.
         * @param v view that contains checkboxes.
         */
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

        /**
         * Retrieves topping based on String name.
         * @param toppingName String of topping to be retrieved.
         * @return Topping object.
         */
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

    /**
     * Unchecks all checkboxes.
     */
    public void unCheckAll() {
        hasCheckedBox = false;
        selectedToppingsList.clear();
        toppingCount = 0;
        notifyDataSetChanged();
    }

    /**
     * Interface for a listener for checkboxes for toppings.
     */
    public interface ToppingCheckboxClickListener {
        void onToppingCheckboxClick();
    }
}
