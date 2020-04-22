package com.damso.superette.details;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.damso.superette.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AdditiveFragment extends Fragment {

    public AdditiveFragment() {
        // Required empty public constructor
    }
    TextView INGREDIENT,ALCOOL,TOXIC,STATUS,DESCRIPTION;
    String ingredient,alcool,toxic,status,description;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_additive, container, false);

        INGREDIENT = view.findViewById(R.id.Id_Ingredient);
        ALCOOL = view.findViewById(R.id.Id_Alcool);
        TOXIC = view.findViewById(R.id.Id_Toxic);
        STATUS = view.findViewById(R.id.Id_Status);
        DESCRIPTION = view.findViewById(R.id.Id_Description);

        ingredient = getActivity().getIntent().getStringExtra("Ingredient");
        alcool = getActivity().getIntent().getStringExtra("Alcool");
        toxic = getActivity().getIntent().getStringExtra("Toxic");
        status = getActivity().getIntent().getStringExtra("Status");
        description = getActivity().getIntent().getStringExtra("Description");

        setData();
        return view;
    }
    public void setData(){
        INGREDIENT.setText("Ingredient : "+ingredient);
        ALCOOL.setText("Alcool : "+alcool);
        TOXIC.setText("Toxic : "+toxic);
        STATUS.setText("Status : "+status);
        DESCRIPTION.setText("Description : "+description);

    }
}
