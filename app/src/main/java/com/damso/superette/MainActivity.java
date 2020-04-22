package com.damso.superette;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.damso.superette.database.DetailsFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Toolbar mtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //call initialise function
        initialise();

//________TOOLBAR__________
        //mtoolbar=findViewById(R.id.main_page_toolbar);
        //setSupportActionBar(mtoolbar);
        //________TOOLBAR__________
        //setSupportActionBar(mtoolbar);
        //getSupportActionBar().setTitle("Market");

        BottomNavigationView bottomNav = findViewById(R.id.BottomNav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        //I added this if statement to keep the selected fragment when rotating the device

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }
    //__________CREATE OPTIONS MENU______________
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }


    //____________MENU OPTIONS ITEM SELECTED__________________
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId()== R.id.main_about_option){
            finish();
            startActivity(getIntent());
        }
        if(item.getItemId()== R.id.main_search_option){
            SendUserToScannerFrag();
        }
        if(item.getItemId()== R.id.main_details_option){
            SendUserToDetailFrag();
        }
        if(item.getItemId()== R.id.main_Logout_option){
            SendUserToLoginActivity();
        }
        if(item.getItemId()== R.id.main_quit_option){
            finish();
        }

        return true;
    }
    //-------------------FINISHED MENU OPTIONS---------------

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new ScannerFragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new DetailsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    //________________________Initialisations______________________________
    public void initialise(){
        //mtoolbar=findViewById(R.id.main_page_toolbar);
        //mviewpager=findViewById(R.id.main_tabs_pager);
        //mtablayout=findViewById(R.id.main_tabs);
    }
    //------------------------FINISHED INITIALISATIONS--------------------


    //__________________When Start APP______if User exists or no______________
    @Override
    protected void onStart() {
        super.onStart();

    }
    //-----------------FINISHED WHEN START APP-------------------



    //_____________________Go To Login Activity___________________
    private void SendUserToLoginActivity() {
        Intent loginintent = new Intent(MainActivity.this, LoginActivity.class);
        loginintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginintent);
        finish();
    }
    //-------------------FINISHED LOGIN ACTIVITY--------------------------
    private void SendUserToHomeFrag(){
        Intent home= new Intent(MainActivity.this, HomeFragment.class);
        home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(home);
        finish();

    }
    private void SendUserToDetailFrag(){
        Intent details= new Intent(MainActivity.this, DetailsFragment.class);
        details.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(details);
        finish();
    }

    private void SendUserToScannerFrag(){
        Intent scan= new Intent(MainActivity.this, ScannerFragment.class);
        scan.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(scan);
        finish();
    }
}

