package com.damso.superette;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.damso.superette.R;
import com.damso.superette.database.DetailsFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ImageView overflowMenuImageView = view.findViewById(R.id.overflow_menu);
        overflowMenuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getItemId()== R.id.main_about_option){
                            getActivity().finish();

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
                            getActivity().finish();
                        }
                        return false;
                    }
                });
                popupMenu.inflate(R.menu.options_menu);
                popupMenu.show();
            }
        });
        return view;
    }

    //____________MENU OPTIONS ITEM SELECTED__________________
   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if(item.getItemId()== R.id.main_about_option){
            getActivity().finish();

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
            getActivity().finish();
        }

        return true;
    }*/
    //-------------------FINISHED MENU OPTIONS---------------

    //_____________________Go To Login Activity___________________
    private void SendUserToLoginActivity() {
        Intent loginintent = new Intent(getActivity(), LoginActivity.class);
        loginintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginintent);
        getActivity().finish();
    }
    //-------------------FINISHED LOGIN ACTIVITY--------------------------
    private void SendUserToHomeFrag(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new HomeFragment();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();

    }
    private void SendUserToDetailFrag(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new DetailsFragment();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }

    private void SendUserToScannerFrag(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = new ScannerFragment();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
