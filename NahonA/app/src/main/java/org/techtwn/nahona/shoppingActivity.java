package org.techtwn.nahona;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class shoppingActivity extends AppCompatActivity {
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        pager = findViewById(R.id.buyvPager);
        pager.setOffscreenPageLimit(3);

        buypagerAdapter adapter = new buypagerAdapter(getSupportFragmentManager());
        gbuyActivity gbuyactivity = new  gbuyActivity();
        adapter.addItem(gbuyactivity);


        hbuyActivity hbuyactivity = new hbuyActivity();
        adapter.addItem(hbuyactivity);

        nbuyActivity nbuyactivity = new nbuyActivity();
        adapter.addItem(nbuyactivity);
        pager.setAdapter(adapter);
    }
    class buypagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>();
        public buypagerAdapter(FragmentManager fm){
            super(fm);
        }
        public void addItem(Fragment item){
            items.add(item);
        }
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }
}



