package org.techtwn.nahona;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {
    ArrayList<Person> items = new ArrayList<Person>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {//뷰홀더 객체가 만들어질 때와 재사용될때 자동호출, 뷰홀더가 새로만들어지는 시점 그안에서각 암이템을 위해 정의한 xml레이아웃이용해 뷰객체 만듦
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.person_item, viewGroup,false); //인플레이션을 통해 뷰 객체 만들기

        return new ViewHolder(itemView); //뷰홀더 객체를 생성하면서 뷰 객체를 전달하고 그뷰홀더 객체 반환

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {//뷰홀더 객체가 만들어질 때와 재사용될때 자동화출
        Person item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() { //어뎁터에서 관리하는 아이템 개수를 반환 리사이클러뷰 에서 어댑터가 관리하는 아잍메의 개수를 알아야할때사용,뷰홀더가 재사요ㅕㅇ시 호출되므로 뷰객체는 기존것을 그대로 사용하고 데이터만 바꿔줌
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        TextView textView2;

        public ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
        public void setItem(Person item){
            textView.setText(item.getName());
            textView2.setText(item.getMobile());
        }

    }
    public void addItem(Person item){
        items.add(item);
    }
    public void setItems(ArrayList<Person> items){
        this.items = items;
    }
    public Person getItem(int position){
        return items.get(position);
    }
    public Person setItem(int position, Person item){
        return items.set(position, item);
    }


}
