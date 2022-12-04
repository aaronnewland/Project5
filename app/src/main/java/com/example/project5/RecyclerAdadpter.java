package com.example.project5;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdadpter extends RecyclerView.Adapter<RecyclerAdadpter.ViewHolder> {

    String availableToppings[];
    int images[];
    Context context;

    public RecyclerAdadpter(Context ct, String availableToppings[], int images[]) {
        context = ct;
        this.availableToppings = availableToppings;
        this.images = images;
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
        holder.toppingsCheckBox.setText(availableToppings[position]);
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CheckBox toppingsCheckBox;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            toppingsCheckBox = itemView.findViewById(R.id.toppingCheckBox);
            image = itemView.findViewById(R.id.toppingImageView);
        }
    }
}
