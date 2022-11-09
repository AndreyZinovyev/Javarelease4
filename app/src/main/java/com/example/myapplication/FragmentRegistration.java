package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentRegistrationBinding;

import java.util.ArrayList;
import java.util.List;


public class FragmentRegistration extends Fragment {

FragmentRegistrationBinding __binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        __binding = FragmentRegistrationBinding.inflate(inflater, container, false);

        return __binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CarsListAdapter carsListAdapter = new CarsListAdapter();
        carsListAdapter.setCars(initCars());
        carsListAdapter.setListener(car -> {
            Toast.makeText(getContext(), car.Number, Toast.LENGTH_SHORT).show();
        });

        __binding.recyclerView.setAdapter(carsListAdapter);
    }

    private List<Car> initCars(){
        List<Car> result = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            result.add(new Car(i, "number" + i, "time" + i));
        }

        return result;

    }
}