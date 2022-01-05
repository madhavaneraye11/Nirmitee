package com.spam.maddy.nirmiteetask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    static FrameLayout fragViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragViewPager = findViewById(R.id.fragViewPager);
        Fragment fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragViewPager, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();


        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.homenv);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.action_home :
                        Fragment fragment1 = new HomeFragment();
                        moveToFragment(fragment1);
                        return true;

                    case R.id.action_search :

                        Fragment fragment2 = new SearchFragment();
                        moveToFragment(fragment2);
                        return true;
                    case R.id.action_cart :
                        Fragment fragment3 = new CartFragment();
                        moveToFragment(fragment3);
                        return true;


                    case R.id.action_account :
                        Fragment fragment4 = new AccountFragment();
                        moveToFragment(fragment4);
                        return true;
                }
                return true;
            }
        });


    }


    private void moveToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragViewPager, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }
}