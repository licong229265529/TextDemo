package com.example.textdemo.adapters;

import android.content.Context;

import com.example.textdemo.R;
import com.example.textdemo.base.RecyclerAdapter;
import com.example.textdemo.base.RecyclerViewHolder;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerAdapter<String> {
    private Context context;
    public RecyclerviewAdapter(Context context,List<String> datas) {
        super(context, datas, R.layout.item);
        this.context = context;
    }

    @Override
    public void convert(RecyclerViewHolder holder, String s, int position) {
        holder.setText(R.id.textt,s);
    }
}
