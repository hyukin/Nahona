package shopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.tabs.TabLayout;

import org.techtwn.nahona.Picture;
import org.techtwn.nahona.R;

public class ShoppingActivity extends AppCompatActivity {

    private FragmentPagerAdapter fragmentPagerAdapter;
    Toolbar toolbar;

    Shopping1Activity fragment1;
    Fragment2 fragment2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);




        ActionBar actionBar = getSupportActionBar();

        fragment1 = new Shopping1Activity();
        fragment2 = new Fragment2();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("나혼아 장터"));
        tabs.addTab(tabs.newTab().setText("음식 공동구매"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();


                Fragment selected = null;
                if (position == 0) {
                    selected = fragment1;
                } else if (position == 1) {
                    selected = fragment2;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        /*Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(ShoppingActivity.this, Sell.class);
                startActivity(intent);
            }
        });*/

    }

    public void house(View v) {
        Intent intent = new Intent(ShoppingActivity.this, Picture.class);
        startActivity(intent);
    }


}