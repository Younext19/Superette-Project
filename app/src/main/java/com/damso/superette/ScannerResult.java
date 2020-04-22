package com.damso.superette;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.damso.superette.database.dbHelper;

public class ScannerResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner_result);

        String barcode;

        barcode=getIntent().getStringExtra("Barcode");

        //DERWAK HNA BARCODE RAH F barcode
        // TODO: F FONCTION LOADDATABASE JAYA F DETAILS FRAGMENT HADIK T3AWNEK
        // TODO: HADIK T7EL BIHA DATABASE BSH GHADI TBEDEL CONDITION HADI NRMLMNT if (cursor.moveToFirst())
        // WA9ILA DIRHA BOUCLE FOR MA3LABALICH

        //Lazem Takhdem B Cursor
        // TODO : WRECHERCHER 3LA barcode F BDD

        /*
        Cursor cursor = dbHelper.QueryData("select * from items");
        // Then browse the result:
        if (cursor.moveToFirst()){
            // The elements to retrieve
            Integer colId;
            String name;
            String firstname;

            // The associated index within the cursor



            // Browse the results list:
            int count=0;
            do {
                name=cursor.getString(6);
                Toast.makeText(this, "Retrieve element :"+name+"", Toast.LENGTH_LONG).show();
                count++;
            } while(cursor.moveToNext());
            Toast.makeText(this, "The number of elements retrieved is "+count, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "No element found : ", Toast.LENGTH_LONG).show();
        }*/


        //Makhdemlich hada
        // TODO ila l9itah Reslah l Activity jdida w afficher fiha row ta3 BDD w sayer
        // LAHYsahel x'(
    }
}
