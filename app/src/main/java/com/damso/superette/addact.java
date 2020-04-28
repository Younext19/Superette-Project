package com.damso.superette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.damso.superette.database.Item;
import com.damso.superette.database.ItemFb;
import com.damso.superette.details.More_Details;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class addact extends AppCompatActivity {
    private DatabaseReference mDatabase, reff;
    Button Send;
    Button src;
    //  TODO : HNA ZID LOKHRIN
    EditText marque;
    String marq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addact);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        //TODO GA3 DIRELHOM HAKA KI HNA KI F XML TA3HA LAZEM TZIDHOM GA3
        //  TODO : HNA ZID LOKHRIN
        marque = findViewById(R.id.marque_input);
        marq = marque.getText().toString();

        // derwak marq rah fiha les données ta3 la marque
        // HNA TA3 LI TZID DATA
        Send = findViewById(R.id.send);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // HNA NERSLO DATA L FIREBASE
                // kayen marq nerselha l firebase
                addprod();
            }
        });

        src = findViewById(R.id.search_id);
        src.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });
    }
    //when click on Add Product button
    private void writeNewProduct(String marque) {
//  TODO : HNA ZID LOKHRIN

        ItemFb item = new ItemFb(marque);
        //  TODO : HNA ZID LOKHRIN HNA ROH L ITEMFB.JAVA
        mDatabase.child("products").child(marque).setValue(item);

    }
    public void addprod(){

        writeNewProduct(marq);
        //Show Result :
        new AlertDialog.Builder(this)
                .setTitle("info")
                .setMessage("le produit a été ajouté avec succès à la base de données")

                .setNegativeButton("ok !", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    //when click on Search Product button
    public void search() {

        String marquee = marque.getText().toString();
        reff =FirebaseDatabase.getInstance().getReference().child("products").child(marquee);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {
                    //  TODO : HNA ZID LOKHRIN
                    String marque = dataSnapshot.child("marque").getValue().toString();


                    Intent myIntent = new Intent(addact.this, More_Details.class);

                    // HNA TZID LOKHRIN lazem hadik kima hna mark lzem
                    // ykouno kifkif hiya wli ykono f details
                    //  TODO : HNA ZID LOKHRIN
                    myIntent.putExtra("Marque", marque);

                    startActivity(myIntent);
                }catch (Exception e)
                {
                    noProdect();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public void noProdect()
    {
        //Show Result :
        new AlertDialog.Builder(this)
                .setTitle("info")
                .setMessage("aucun produit dans la base de données")

                .setNegativeButton("ok !", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}

