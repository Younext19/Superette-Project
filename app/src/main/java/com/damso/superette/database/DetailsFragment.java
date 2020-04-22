package com.damso.superette.database;


import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.damso.superette.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    private RecyclerView recyclerView;
    private dbHelper dbHelper;
    private ArrayList<Item> arrayList= new ArrayList<Item>();
    private Cursor cursor;
    private VocabularyAdapter adapter;

    String k;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.fragment_details, container, false);


        /*
        - HNA TROH L LA BASE DE DONNEES
        - NDIRO RECYCLER VIEW
        - TAFFICHILNA GA3 LES ITEMS 3LA HSAB LE NOM F BDD
        - Min TECLiCKI TEDIK L PAGA YJI FIHA GA3 SWALEH TA3 BDD
        - TAFFICHILEK SWALEH LI F BDD
         */

        //HNA YEBDA LCODE
        recyclerView = viewGroup.findViewById(R.id.recycler_view);
        loadDatabase();
        //HNA YAHBES LCODE
        return viewGroup;
    }
    public void loadDatabase(){
        dbHelper = new dbHelper(getActivity());
        try {
            dbHelper.checkAndCopyDatabase();
            dbHelper.openDatabase();
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            cursor = dbHelper.QueryData("select * from items");
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    do {
                        Item item = new Item();
                        // TODO HNA DIR SETTERS !
                        item.setMarque(cursor.getString(0));
                        item.setIdProduit(cursor.getString(1));
                        item.setNom(cursor.getString(2));
                        item.setPoid(cursor.getString(3));
                        item.setVolume(cursor.getString(4));
                        item.setPrix(cursor.getString(5));
                        item.setBarCode(cursor.getString(6));
                        item.setIdProducteur(cursor.getString(7));
                        item.setIdCompos(cursor.getString(8));
                        item.setColesterol(cursor.getString(9));
                        item.setFibre(cursor.getString(10));
                        item.setCalcium(cursor.getString(11));
                        item.setSucre(cursor.getString(12));
                        item.setEnergie(cursor.getString(13));
                        item.setProteine(cursor.getString(14));
                        item.setMagnesium(cursor.getString(15));
                        item.setSodium(cursor.getString(16));
                        item.setSulphate(cursor.getString(17));
                        item.setVitamine(cursor.getString(18));
                        item.setGlucide(cursor.getString(19));
                        item.setGraisse(cursor.getString(20));
                        item.setSel(cursor.getString(21));
                        item.setFer(cursor.getString(22));
                        item.setIngredients(cursor.getString(23));
                        item.setAlcool(cursor.getString(24));
                        item.setToxic(cursor.getString(25));
                        item.setStatus(cursor.getString(26));
                        item.setDescription(cursor.getString(27));
                        arrayList.add(item);

                    } while (cursor.moveToNext());
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        adapter = new VocabularyAdapter(getActivity(), arrayList);
        /*adapter.setOnTapListener(new OnTapListener() {
            @Override
            public void OnTapView(int position) {

                Toast.makeText(getContext(), "Click To "+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), More_Details.class);
                intent.putExtra("Weight", k);
                //intent.putExtra(position.getMarque());
                System.out.println(k);
                startActivity(intent);

            }
        });*/
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }
}
