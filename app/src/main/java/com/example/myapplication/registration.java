package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.databinding.FragmentAddBinding;
import com.example.myapplication.databinding.FragmentRegistrationBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link registration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class registration extends Fragment {

FragmentRegistrationBinding __reg_binding;
 //   RecyclerView recyclerView = null;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public registration() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment registration.
     */
    // TODO: Rename and change types and number of parameters
    public static registration newInstance(String param1, String param2) {
        registration fragment = new registration();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //recyclerView = recyclerView.findViewById(R.id.Resours);
        __reg_binding= FragmentRegistrationBinding.inflate(inflater,container,false);
        __reg_binding.insert.setOnClickListener(view -> {


MyHandler reghand=new MyHandler();
String reg;
//ArrayList<Cars>Car=reghand.onClickRecycle();
            String g = reghand.onClickRecycle();
           /* for(int ii = 0; ii < Car.size()-1;ii++)
            {
                g+= Car.get(ii).Number + ";  ";
            }*/
//DannyeAdapter adapter=new DannyeAdapter(this,Car);

//recyclerView.setAdapter(adapter);


            // тестовое
           Toast toast = Toast.makeText(view.getContext(),
                     g, Toast.LENGTH_SHORT);
            toast.show();


        });
        // Inflate the layout for this fragment
        return __reg_binding.getRoot();
    }
}