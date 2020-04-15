package com.example.cobafragment.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.cobafragment.view.fragment.MovieFragment;
import com.example.cobafragment.R;
import com.example.cobafragment.view.fragment.TvshowFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private Fragment selectedFragment           =   new MovieFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView                    =   findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        loadFragment(selectedFragment);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.menu_bottomnav_movie:
                selectedFragment                =   new MovieFragment();
                loadFragment(selectedFragment);
                break;
            case R.id.menu_bottomnav_tvshow:
                selectedFragment                =   new TvshowFragment();
                loadFragment(selectedFragment);
                break;

        }
        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {

        if(selectedFragment != null)
        {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.activitymain_fragmentcontainer,selectedFragment).
                    commit();
            return  true;
        }
        return false;

    }
}
