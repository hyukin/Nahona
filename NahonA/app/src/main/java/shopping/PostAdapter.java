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
import java.util.List;

import shopping.upload;
import shopping.upload_Adapter;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private ArrayList<upload> arrayList;
    private Context context;

    public PostAdapter(ArrayList<upload> arrayList, Context context)
    {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        PostViewHolder holder = new PostViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        Glide.with(holder.itemView).load(arrayList.get(position).getImage()).into(holder.gs_image);
        holder.gs_title.setText(arrayList.get(position).getTitle());
        holder.gs_price.setText(String.valueOf(arrayList.get(position).getPrice()));
        /*Post data = datas.get(position);
        holder.title.setText(data.getTitle());
        holder.contents.setText(data.getContents());*/
    }

    @Override
    public int getItemCount() {
        return (arrayList != null ? arrayList.size():0);
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        ImageView gs_image;
        TextView gs_title;
        TextView gs_price;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.gs_image =itemView.findViewById(R.id.gs_image);
            this.gs_title = itemView.findViewById(R.id.gs_title);
            this.gs_price = itemView.findViewById(R.id.gs_price);
        }
    }
}
