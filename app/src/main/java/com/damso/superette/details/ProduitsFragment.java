package com.damso.superette.details;

import android.database.Cursor;
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
public class ProduitsFragment extends Fragment {

    public ProduitsFragment() {
        // Required empty public constructor
    }

    int position=0;
    String id_produit,marque,nom,poids,volume,prix,barcode,id_producteur;
    TextView IDPRODUIT,MARQUE,NOM,POIDS,VOLUME,IDPRODUCTEUR,PRIX;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_produits, container, false);
        IDPRODUIT = view.findViewById(R.id.idProduit);
        MARQUE = view.findViewById(R.id.marque);
        NOM = view.findViewById(R.id.Nom);
        POIDS = view.findViewById(R.id.Poids);
        VOLUME = view.findViewById(R.id.Volume);
        PRIX = view.findViewById(R.id.Prix);
        IDPRODUCTEUR = view.findViewById(R.id.idProducteur);


//        id_produit = bundle.getString("IdProduit");
        marque = getActivity().getIntent().getStringExtra("Marque");
        id_produit = getActivity().getIntent().getStringExtra("IdProduit");
        nom = getActivity().getIntent().getStringExtra("Nom");
        poids = getActivity().getIntent().getStringExtra("Poids");
        volume = getActivity().getIntent().getStringExtra("Volume");
        prix = getActivity().getIntent().getStringExtra("Prix");
        barcode = getActivity().getIntent().getStringExtra("Barcode");
        id_producteur = getActivity().getIntent().getStringExtra("IdProducteur");



        setData();

        // TODO HNA NRECUPERER DATA LI JINI M RECYCLER VIEW


        return view;
    }

    public void getData(){

    }

    public void setData(){
        IDPRODUIT.setText("Id Produit : "+id_produit);
        MARQUE.setText("Marque : "+marque);
        NOM.setText("Nom : "+nom);
        POIDS.setText("Poids : "+poids);
        VOLUME.setText("Volume : "+volume);
        PRIX.setText("Prix : "+prix);
        IDPRODUCTEUR.setText("Id Producteur : "+id_producteur);

    }
}
