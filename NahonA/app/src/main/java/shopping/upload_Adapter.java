package shopping;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.techtwn.nahona.R;

import java.util.ArrayList;

public class upload_Adapter extends RecyclerView.Adapter <upload_Adapter.CustomViewHolder> {
    private ArrayList<upload> arrayList;
    private Context context;
    OnItemClickListener listener;
    public upload_Adapter(ArrayList<upload> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    public static interface OnItemClickListener {
        void onItemClick(CustomViewHolder holder, View view, int position);
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.groupsell_item,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Glide.with(holder.itemView).load(arrayList.get(position).getImage()).into(holder.gs_image); //이미지 받아와서 넣어줄것
        holder.gs_title.setText(arrayList.get(position).getTitle());
        holder.gs_cur.setText(String.valueOf(arrayList.get(position).getCur()));
        holder.gs_tar.setText(String.valueOf(arrayList.get(position).getTar()));
        holder.gs_price.setText(String.valueOf(arrayList.get(position).getPrice()));
        holder.gs_explain.setText(arrayList.get(position).getExplain());
        holder.setOnItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size():0);
    }
    public upload getItem(int position) {
        return arrayList.get(position);
    }

    public void test() {

    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView gs_image;
        TextView gs_title;
        TextView gs_cur;
        TextView gs_tar;
        TextView gs_price;
        TextView gs_explain;
        OnItemClickListener listener;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.gs_image =itemView.findViewById(R.id.gs_image);
            this.gs_title = itemView.findViewById(R.id.gs_title);
            this.gs_cur = itemView.findViewById(R.id.cur_human);
            this.gs_tar = itemView.findViewById(R.id.tar_human);
            this.gs_price = itemView.findViewById(R.id.gs_price);
            this.gs_explain = itemView.findViewById(R.id.gs_explain);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(CustomViewHolder.this, v,position );
                    }
                }
            });

        }
        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
    }
}
