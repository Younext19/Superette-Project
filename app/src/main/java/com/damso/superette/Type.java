package com.damso.superette;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Type extends AppCompatActivity {

    EditText bcode;
    Button submit;
    TextView result;
    String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        bcode = findViewById(R.id.typeBar);
        submit= findViewById(R.id.btnsend);
        result = findViewById(R.id.resulta);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //HNA TAFFICHER DEK TEXTVIEW
               content = bcode.getText().toString();
               result.setText(content);


            }
        });
        int l;
//        l=Integer.parseInt(content);
        // l rah fih Code bar
    }
}
