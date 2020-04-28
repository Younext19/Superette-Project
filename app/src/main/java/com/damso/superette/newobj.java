package com.damso.superette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.damso.superette.database.Item;
import com.damso.superette.database.VocabularyAdapter;
import com.damso.superette.database.VocabularyAdapter2;

import java.util.ArrayList;

public class newobj extends AppCompatActivity {
RecyclerView recyclerView;
    private ArrayList<Item> arrayList= new ArrayList<Item>();
    private VocabularyAdapter2 adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newobj);
        recyclerView = findViewById(R.id.recycler_view);
        //HNA JIB DATA M FIREBASE
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        adapter = new VocabularyAdapter2(this, arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
