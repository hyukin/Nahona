package shopping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.techtwn.nahona.R;

import java.util.ArrayList;


public class gbuyActivity extends Fragment{
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;
    private ArrayList<upload> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        view = inflater.inflate(R.layout.activity_gbuy, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.grecyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>(); //객체담을 어레이
        database = FirebaseDatabase.getInstance();//파이어베이스 연동
        databaseReference = database.getReference("gbuytest"); // DB테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어 베이스 데이터베이스의 데이터틀 받아오는 곳
                arrayList.clear();//기존 배열존재 안하게 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){ //반복문으로 데이터 리스트 추출해냄
                    upload user = snapshot.getValue(upload.class); //만들어진 user객체에 데이터를 담는다.
                    arrayList.add(user); //담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼준비
                }
                adapter.notifyDataSetChanged(); //리스트 저장및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비가져오던중 에러 발생시
                Log.e(".MainActivity",String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });
        adapter = new upload_Adapter(arrayList,getContext());
        recyclerView.setAdapter(adapter);//리사이클러뷰에 어댑터 연결
        return view;
    }
}