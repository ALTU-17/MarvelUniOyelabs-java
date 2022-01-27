package com.oyelabs.marvel.universe;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.time.Instant;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class CharAdapter extends RecyclerView.Adapter<CharViewHolder> {

    private Context context;
    private List<CharInfo> charinfoList;
    private Instant Glid;

    public CharAdapter(Context context, List<CharInfo> charinfoList) {
        this.context = context;
        this.charinfoList = charinfoList;

    }

    @NonNull
    @Override
    public CharViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.char_item,parent,false);
        return new  CharViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull CharViewHolder holder, int position) {

        Glide.with(context).load(charinfoList.get(position).getMedium()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return charinfoList.size();
    }
}

class CharViewHolder extends RecyclerView.ViewHolder{
    ImageView imageView;
    public CharViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.charViewItem);
    }
}