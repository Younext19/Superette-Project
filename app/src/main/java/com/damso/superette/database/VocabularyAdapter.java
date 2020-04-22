package com.damso.superette.database;


import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.damso.superette.details.More_Details;
import com.damso.superette.R;

import java.util.Collections;
import java.util.List;

public class VocabularyAdapter extends RecyclerView.Adapter<SetViewHolder> {
    private Activity activity;
    List<Item> items= Collections.emptyList();

    private OnTapListener onTapListener;

    public VocabularyAdapter(Activity activity, List<Item> items){
        this.activity = activity;
        this.items = items;
    }

    @NonNull
    @Override
    public SetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item, parent, false);


        return new SetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SetViewHolder holder, final int position) {
        // HNA MANZID WALO

        holder.Marque.setText(items.get(position).getMarque());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onTapListener.OnTapView(position);
                Intent intent = new Intent(activity, More_Details.class);
                // TODO HNA NZID LES AUTRES TEXTVIEWS TA3 LI YJO F BDD
                String Marque;
                String  id_produit,nom,poids,volume,prix,barcode,id_producteur;
                String id_compos,calcium,colesterol,fibre,energie,fer
                        ,glucide,sel,graisse,proteine,
                        sucre,sodium,sulphate,vitamine,magnesium;
                String toxic, alcool, status, ingredient,description;


                Marque = items.get(position).getMarque();
                id_produit = items.get(position).getIdProduit();
                nom = items.get(position).getNom();
                poids = items.get(position).getPoid();
                volume = items.get(position).getVolume();
                prix = items.get(position).getPrix();
                barcode = items.get(position).getBarCode();
                id_producteur = items.get(position).getIdProducteur();

                id_compos = items.get(position).getIdCompos();
                colesterol= items.get(position).getColesterol();
                fibre = items.get(position).getFibre();
                calcium = items.get(position).getCalcium();
                sucre = items.get(position).getSucre();
                energie = items.get(position).getEnergie();
                proteine = items.get(position).getProteine();
                magnesium = items.get(position).getMagnesium();
                sodium = items.get(position).getSodium();
                sulphate = items.get(position).getSulphate();
                vitamine = items.get(position).getVitamine();
                glucide = items.get(position).getGlucide();
                graisse = items.get(position).getGraisse();
                sel = items.get(position).getSel();
                fer = items.get(position).getFer();
                ingredient = items.get(position).getIngredients();
                alcool = items.get(position).getAlcool();
                toxic = items.get(position).getToxic();
                status = items.get(position).getStatus();
                description = items.get(position).getDescription();
                intent.putExtra("Marque",Marque);
                intent.putExtra("IdProduit",id_produit);
                intent.putExtra("Nom",nom);
                intent.putExtra("Poids",poids);
                intent.putExtra("Volume",volume);
                intent.putExtra("Prix",prix);
                intent.putExtra("Barcode",barcode);
                intent.putExtra("IdProducteur",id_producteur);

                intent.putExtra("IdCompos",id_compos);
                intent.putExtra("Colesterol",colesterol);
                intent.putExtra("Fibre",fibre);
                intent.putExtra("Calcium",calcium);
                intent.putExtra("Sucre",sucre);
                intent.putExtra("Energie",energie);
                intent.putExtra("Proteine",proteine);
                intent.putExtra("Magnesium",magnesium);
                intent.putExtra("Sodium",sodium);
                intent.putExtra("Sulphate",sulphate);
                intent.putExtra("Vitamine",vitamine);
                intent.putExtra("Glucides",glucide);
                intent.putExtra("Graisse",graisse);
                intent.putExtra("Sel",sel);
                intent.putExtra("Fer",fer);

                intent.putExtra("Ingredient",ingredient);
                intent.putExtra("Alcool",alcool);
                intent.putExtra("Toxic",toxic);
                intent.putExtra("Status",status);
                intent.putExtra("Description",description);

                //intent.putExtra("");

                activity.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setOnTapListener(OnTapListener onTapListener){
        this.onTapListener = onTapListener;
    }
}
