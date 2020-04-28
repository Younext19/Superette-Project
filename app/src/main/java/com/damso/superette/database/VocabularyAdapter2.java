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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.List;

public class VocabularyAdapter2 extends RecyclerView.Adapter<SetViewHolder> {
    private Activity activity;
    List<Item> items= Collections.emptyList();
    DatabaseReference reff;
    private OnTapListener onTapListener;

    //  TODO : HNA ZID LOKHRIN
    String marque;
    public VocabularyAdapter2(Activity activity, List<Item> items){
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

        reff = FirebaseDatabase.getInstance().getReference().child("items").child("1");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //  TODO : HNA ZID LOKHRIN
                marque = dataSnapshot.child("marque").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        holder.Marque.setText(marque);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // NERSLOHAA LEL MORE DETAIL W PUTEXTRA B DATA JDIDA LI RAHI F FIREBASE
                Intent intent = new Intent(activity, More_Details.class);
                // TODO HNA TZID LOKHRIN
                // TOdo lazem ykoun andhom le meme name
                intent.putExtra("Marque",marque);

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
