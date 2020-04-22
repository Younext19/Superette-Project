package com.damso.superette.details;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.damso.superette.LoginActivity;
import com.damso.superette.MainActivity;
import com.damso.superette.R;
import com.damso.superette.details.TabAccessorAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class More_Details extends AppCompatActivity {
    private Toolbar mtoolbar;
    private ViewPager mviewpager;
    private TabLayout mtablayout;
    private TabAccessorAdapter mtabaccessoradapter;
    int position;

    String Marque;
    String  marque,id_produit,nom,poids,volume,prix,barcode,id_producteur;
    String id_compos,calcium,colesterol,fibre,energie,fer
            ,glucide,sel,graisse,proteine,
            sucre,sodium,sulphate,vitamine,magnesium;
    String toxic, alcool, status, ingredient,description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more__details);
        //TODO GET DATA M RECYCLER VIEW


        //call initialise function
        initialise();


        //________TOOLBAR__________
        setSupportActionBar(mtoolbar);

        //________FRAGMENTS__________
        mtabaccessoradapter = new TabAccessorAdapter(getSupportFragmentManager());
        mviewpager.setAdapter(mtabaccessoradapter);
        mtablayout.setupWithViewPager(mviewpager);

    }

    //________________________Initialisations______________________________
    public void initialise(){
        //mtoolbar=findViewById(R.id.main_page_toolbar);
        mviewpager=findViewById(R.id.main_tabs_pager);
        mtablayout=findViewById(R.id.main_tabs);
    }

    //------------------------FINISHED INITIALISATIONS--------------------


}
