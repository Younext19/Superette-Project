/*package com.damso.superette.NOTNEEDED;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

import com.damso.superette.details.More_Details;

class Affichage_Activity extends TabActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_affichage_);
        TextView aff1, aff2;
        // aff2 = (TextView) findViewById(R.id.aff2);
        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();

        String json_st = bundle.getString("json_st");

        // affiche_json(json_st);
        Bundle bu_aff1 = new Bundle();
        bu_aff1.putString("json_aff1", json_st);

        Intent intent = new Intent(this, Produit.class);

        intent.putExtras(bundle);

        Intent intent2 = new Intent(this, More_Details.class);

        intent2.putExtras(bundle);


        TabHost th = getTabHost();
        th.addTab(th.newTabSpec("nom").setIndicator("Produit").setContent(intent));
        th.addTab(th.newTabSpec("nom").setIndicator("Autre Information").setContent(intent2));
        th.setCurrentTab(0);

        //aff1 = (TextView) th.findViewById(R.id.aff1);
    }
    /* public void affiche_json(String json_str) {

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json_str);
            JSONObject produit = jsonArray.getJSONObject(0);

            String marque = produit.getString("Marque");
            String nom = produit.getString("Nom");
            String poid = produit.getString("Poid");
            String vol = produit.getString("Vol");
            String prix = produit.getString("Prix");

            JSONObject producteur = jsonArray.getJSONObject(1);

            String adress = producteur.getString("adress");
            String idWillaya = producteur.getString("idWillaya");
            String email = producteur.getString("e-mail");
            String siteWeb = producteur.getString("siteWeb");
            String tel = producteur.getString("tel");
            String fax = producteur.getString("fax");

            JSONObject paye = jsonArray.getJSONObject(2);

            String nomWillaya = paye.getString("NomWillaya");


            aff1.setText("Marque: " + marque +
                    "\nNom: " + nom +
                    "\nPoid: " + poid +
                    "\nVol: " + vol +
                    "\nPrix: " + prix +
                    "\n\nProducteur: \nAdresse" + adress +
                    "\nWillaya: " + nomWillaya +
                    "\ne-mail: " + email +
                    "\nsiteWeb: " + siteWeb +
                    "\ntel: " + tel +
                    "\nfax: " + fax);


            JSONObject categorie = jsonArray.getJSONObject(3);

            String libelieCat = categorie.getString("LibelieCat");

            JSONObject ecodes = jsonArray.getJSONObject(5);

            String ingredients = ecodes.getString("ingredients");
            String status = ecodes.getString("status");
            String desc = ecodes.getString("desc");
            String eu = ecodes.getString("eu");
            String us = ecodes.getString("us");
            String mainingredient = ecodes.getString("mainingredient");
            String toxic = ecodes.getString("toxic");
            String alcohol = ecodes.getString("alcohol");


            JSONObject composant = jsonArray.getJSONObject(6);

            String chlorures = composant.getString("Chlorures");
            String calcium = composant.getString("Calcium");
            String cholestrol = composant.getString("Cholestrol");
            String energie = composant.getString("Energie");
            String fibres = composant.getString("Fibres");
            String fer = composant.getString("Fer");
            String glucides = composant.getString("Glucides");
            String graisses = composant.getString("Graisses");
            String lipides = composant.getString("Lipides");
            String lipides_sature = composant.getString("Lipides_sature");
            String magnesium = composant.getString("Magnesium");
            String protein = composant.getString("Protein");
            String potassium = composant.getString("Potassium");
            String sucre = composant.getString("Sucre");
            String sodium = composant.getString("Sodium");
            String sulphates = composant.getString("Sulphates");
            String vitamines = composant.getString("Vitamines");

           aff2.setText("LibelieCat" + libelieCat +
                    "\nIngredients: " + ingredients +
                    "\nStatus: " + status +
                    "\nDescription: " + desc +
                    "\ndans europe: " + eu +
                    "\ndans usa: " + us +
                    "\nMain Ingredient: " + mainingredient +
                    "\nToxic: " + toxic +
                    "\nAlcohol: " + alcohol +
                    "\nChlorures: " + chlorures +
                    "\nCalcium: " + calcium +
                    "\nCholestrol: " + cholestrol +
                    "\nEnergie: " + energie +
                    "\nFibres: " + fibres +
                    "\nFer: " + fer +
                    "\nGlucides: " + glucides +
                    "\nLipides: " + lipides +
                    "\nLipides_sature: " + lipides_sature +
                    "\nMagnesium: " + magnesium +
                    "\nProtein: " + protein +
                    "\nPotassium: " + potassium +
                    "\nSucre: " + sucre +
                    "\nSodium: " + sodium +
                    "\nSulphates: " + sulphates +
                    "\nVitamines: " + vitamines
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }



}
*/
