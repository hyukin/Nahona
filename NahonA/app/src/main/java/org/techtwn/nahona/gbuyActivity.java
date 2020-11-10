package org.techtwn.nahona;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class gbuyActivity extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_gbuy, container, false);

        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(v.getContext(),LinearLayoutManager.VERTICAL,false); //리사이클 레이아웃 매니저 설정
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter();
        adapter.addItem(new Person("백혁인","010-9238-92621"));
        adapter.addItem(new Person("이준혁","010-9238-92622"));
        adapter.addItem(new Person("김현진","010-9238-92623"));
        adapter.addItem(new Person("최정현","010-9238-92624"));
        adapter.addItem(new Person("최윤지","010-9238-92625"));
        adapter.addItem(new Person("백혁인","010-9238-92626"));
        adapter.addItem(new Person("이준혁","010-9238-92627"));
        adapter.addItem(new Person("김현진","010-9238-92628"));
        adapter.addItem(new Person("최정현","010-9238-92629"));
        adapter.addItem(new Person("최윤지","010-9238-926210"));
        recyclerView.setAdapter(adapter);
        return v;
    }
}