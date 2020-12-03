package shopping;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
import org.techtwn.nahona.write_selling_info;

import java.util.ArrayList;



public class Shopping1Activity extends Fragment {

    private RecyclerView recyclerView;
    private PostAdapter mAdapter;
    private ArrayList<upload> mDatas;
    private  RecyclerView.LayoutManager layoutManager;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.shoping_frag1, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.carrot1);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        mDatas = new ArrayList<>();
        database = FirebaseDatabase.getInstance();  //파베 연동

        Button btn_write = (Button)view.findViewById(R.id.btn_write);
        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), write_selling_info.class);
                startActivity(intent);
            }
        });


        databaseReference = database.getReference("carrot"); // DB테이블 연결
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //파이어 베이스 데이터베이스의 데이터틀 받아오는 곳
                mDatas.clear();//기존 배열존재 안하게 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){ //반복문으로 데이터 리스트 추출해냄
                    upload user = snapshot.getValue(upload.class); //만들어진 user객체에 데이터를 담는다.
                    mDatas.add(user); //담은 데이터들을 배열리스트에 넣고 리사이클러뷰로 보낼준비
                }
                mAdapter.notifyDataSetChanged(); //리스트 저장및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //디비가져오던중 에러 발생시
                Log.e(".MainActivity",String.valueOf(databaseError.toException())); // 에러문 출력
            }
        });

        mAdapter = new PostAdapter(mDatas, getContext());
        recyclerView.setAdapter(mAdapter);
        return view;


        /*Button button = button.findViewById(button3);
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Sell.class);
                startActivity(intent);
            }
        });*/
    }
}