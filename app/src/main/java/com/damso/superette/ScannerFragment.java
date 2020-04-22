package com.damso.superette;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScannerFragment extends Fragment {

    public static TextView txt;
    Button scan,type;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)  {
        // Inflate the layout for this fragment

        // Min TEBGHI T3AYET L FINDVIEWBYID LAZEM DIR view?=.findviewbyID
        /*
        - Lazem ACCES LEL CAMERA Yendar F manifest
        - Dir Code ta3 SCANNER
        - KI Yescanner wykemel
        - Yrecuperer les numero li sabhom
        - Ychouf ila kaynin hadok les nums f BASE DE DONNEES
        - ila kayen yaffichilek Details ta3 lobjet
        - ila makach yafficher message ygoulek makench
         */
        View view = inflater.inflate(R.layout.fragment_scanner, container, false);

        // Hna yendar LCODE

        scan = view.findViewById(R.id.SCAN);
        type = view.findViewById(R.id.typing);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getContext(), ScannerActivity.class);
                startActivity(intent);
            }
        });
        type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getContext(), Type.class);
                startActivity(intent2);
            }
        });

        //HNA YAHBES LCODE
        return view;


    }

}
