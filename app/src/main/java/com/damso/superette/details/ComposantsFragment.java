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
public class ComposantsFragment extends Fragment {

    public ComposantsFragment() {
        // Required empty public constructor
    }
    TextView ID_COMPOSANT,COLESTEROL,FIBRE,CALCIUM,SUCRE,ENERGIE,PROTEINE
            ,MAGNESIUM,SODIUM,SULPHATE,VITAMINE,GLUCIDE,GRAISSE,SEL,FER;
    String idcomposanT,colesteroL,fibrE,calciuM,sucrE,energiE,proteinE,
        magnesiuM,sodiuM,sulphatE,vitaminE, glucidE,graissE,seL,feR;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_composants, container, false);
        ID_COMPOSANT =view.findViewById(R.id.Id_IdCompos);
        COLESTEROL=view.findViewById(R.id.Id_Colesterol);
        FIBRE=view.findViewById(R.id.Id_Fibre);
        CALCIUM=view.findViewById(R.id.Id_Calcium);
        SUCRE=view.findViewById(R.id.Id_Sucre);
        ENERGIE=view.findViewById(R.id.Id_Energie);
        PROTEINE=view.findViewById(R.id.Id_Proteine);
        MAGNESIUM=view.findViewById(R.id.Id_Magnesium);
        SODIUM=view.findViewById(R.id.Id_Sodium);
        SULPHATE=view.findViewById(R.id.Id_Sulphate);
        VITAMINE=view.findViewById(R.id.Id_Vitamine);
        GLUCIDE=view.findViewById(R.id.Id_Glucide);
        GRAISSE=view.findViewById(R.id.Id_Graisse);
        SEL=view.findViewById(R.id.Id_Sel);
        FER=view.findViewById(R.id.Id_Fer);
        //marque = getActivity().getIntent().getStringExtra("Marque");

        idcomposanT = getActivity().getIntent().getStringExtra("IdCompos");
        colesteroL = getActivity().getIntent().getStringExtra("Colesterol");
        fibrE = getActivity().getIntent().getStringExtra("Fibre");
        calciuM = getActivity().getIntent().getStringExtra("Calcium");
        sucrE = getActivity().getIntent().getStringExtra("Sucre");
        energiE =getActivity().getIntent().getStringExtra("Energie");
        proteinE = getActivity().getIntent().getStringExtra("Proteine");
        magnesiuM = getActivity().getIntent().getStringExtra("Magnesium");
        sodiuM = getActivity().getIntent().getStringExtra("Sodium");
        sulphatE =getActivity().getIntent().getStringExtra("Sulphate");
        vitaminE = getActivity().getIntent().getStringExtra("Vitamine");
        glucidE = getActivity().getIntent().getStringExtra("Glucides");
        seL = getActivity().getIntent().getStringExtra("Sel");
        feR = getActivity().getIntent().getStringExtra("Fer");

        setData();
        return view;


    }
    public void setData(){
        ID_COMPOSANT.setText("Id Compostant : "+idcomposanT);
        COLESTEROL.setText("Colesterol : "+colesteroL);
        FIBRE.setText("Fibre : "+fibrE);
        CALCIUM.setText("Calcium : "+calciuM);
        SUCRE.setText("Sucre : "+sucrE);
        ENERGIE.setText("Energie : "+energiE);
        PROTEINE.setText("Proteine : "+proteinE);
        MAGNESIUM.setText("Magnesium : "+magnesiuM);
        SODIUM.setText("Sodium : "+sodiuM);
        SULPHATE.setText("Sulphate : "+sulphatE);
        VITAMINE.setText("Vitamine : "+vitaminE);
        GLUCIDE.setText("Glucide : "+glucidE);
        GRAISSE.setText("Graisse : "+graissE);
        SEL.setText("Sel : "+seL);
        FER.setText("Fer : "+feR);
    }

}
