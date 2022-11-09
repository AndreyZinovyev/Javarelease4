package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;


public class CarsListAdapter extends RecyclerView.Adapter<CarsListAdapter.ViewHolder> {

    private  List<Car> cars = new ArrayList<>();
    private ItemClickListener listener;

    @FunctionalInterface
    public interface ItemClickListener{
        void onClick(Car c);
    }


    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
        notifyDataSetChanged();
    }

    @Override
    public CarsListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CarsListAdapter.ViewHolder holder, int position) {
        Car car = cars.get(position);
        holder.flagView.setText(car.Number);
        holder.nameView.setText(car.TimeStart);
        holder.capitalView.setText(String.valueOf(car.Id));

        holder.itemView.setOnClickListener(view -> listener.onClick(car));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView flagView;
        final TextView nameView, capitalView;
        ViewHolder(View view){
            super(view);
            flagView = view.findViewById(R.id.flag);
            nameView = view.findViewById(R.id.name);
            capitalView = view.findViewById(R.id.capital);
        }
    }

}
