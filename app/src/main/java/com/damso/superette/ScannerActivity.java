package com.damso.superette;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    int MY_PERMISSIONS_REQUEST_CAMERA=0;

    ZXingScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }
// MIN YESCANNER YKHAREJ CODE BAR F TEXTVIEW
    @Override
    public void handleResult(Result result) {
        String l = result.getText();
        System.out.println(l);

        // TODO:COMMENT LAST
        // HNA Min yescanner troh l ScannerResult Eya w Lcode Bar tani rah f la valeur
        Intent intent = new Intent(ScannerActivity.this, ScannerResult.class);
        intent.putExtra("Barcode",l);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        scannerView.setResultHandler(this);
//        scannerView.startCamera();
//    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
        }
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }
}
