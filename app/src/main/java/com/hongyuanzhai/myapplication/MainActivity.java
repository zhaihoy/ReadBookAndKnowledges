package com.hongyuanzhai.myapplication;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hongyuanzhai.myapplication.Fragment.BookFragment;
import com.hongyuanzhai.myapplication.Fragment.GameFragment;
import com.hongyuanzhai.myapplication.Fragment.HomeFragment;
import com.hongyuanzhai.myapplication.Fragment.MusicFragment;
import com.hongyuanzhai.myapplication.utils.ToastUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                      getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragments.get(0)).commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment, fragments.get(1)).commit();
                    return true;
                case R.id.navigation_notifications:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragments.get(2)).commit();
                    return true;
            }
            return false;
        }
    };
    private ArrayList<Fragment> fragments;
    private FrameLayout fragment;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        ToastUtils.init(this);
        fragment = findViewById(R.id.fragment);
        //首先实例化
        fragments = getFragments();
        setDefaultFragment();

        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void setDefaultFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, new HomeFragment()).commit();
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment() );
        fragments.add(new BookFragment());
        fragments.add( new MusicFragment());
        fragments.add( new GameFragment());
        return fragments;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ToastUtils.cancel();
    }
}
