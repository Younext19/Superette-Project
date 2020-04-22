package com.damso.superette.details;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAccessorAdapter extends FragmentPagerAdapter {
    public TabAccessorAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                ProduitsFragment ProduitsFragment=new ProduitsFragment();
                return ProduitsFragment;

            case 1:
                ComposantsFragment composantsFragment = new ComposantsFragment();
                return composantsFragment;
            case 2:
                AdditiveFragment additivefragment = new AdditiveFragment();
                return additivefragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Produits";
            case 1:
                return "Composants";
            case 2:
                return "Additive";

            default:
                return null;
        }
    }
}
