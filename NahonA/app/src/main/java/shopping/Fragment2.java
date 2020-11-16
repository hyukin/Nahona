package shopping;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import org.techtwn.nahona.R;
import org.techtwn.nahona.nbuyActivity;


public class Fragment2 extends Fragment {
    ViewPager pager;
    private gbuyActivity fragment1;
    private hbuyActivity fragment2;
    private nbuyActivity fragment3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_shopping2, container, false);
        fragment1=new gbuyActivity();
        fragment2=new hbuyActivity();
        fragment3=new nbuyActivity();
        pager=(ViewPager)view.findViewById(R.id.buyvPager);
        pager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        pager.setCurrentItem(0);
        return view;
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
    private class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
            getItem(0);
        }

        public Fragment getItem(int position) {
            if (position == 0) {
                return fragment1;
            } else if (position == 1) {
                return fragment2;
            } else {
                return fragment3;
            }
        }

        public int getCount() {
            return 3;
        }

    }
}
