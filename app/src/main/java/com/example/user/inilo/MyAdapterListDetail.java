package com.example.user.inilo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapterListDetail extends RecyclerView.Adapter<MyAdapterListDetail.MyViewHolder> {

    String dataNameProject[];
    String dataDetailProject[];
    String dataLang[];
    String dataUpdate[];
    Context context;

    public MyAdapterListDetail(Context ct, String nameproject[], String detailproject[], String language[], String update[]){
        context = ct;
        dataNameProject = nameproject;
        dataDetailProject = detailproject;
        dataLang = language;
        dataUpdate = update;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cards_layout_project, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvProjectList.setText(dataNameProject[position]);
        holder.tvProjectDetailList.setText(dataDetailProject[position]);
        holder.tvLang.setText(dataLang[position]);
        holder.tvUpdate.setText(dataUpdate[position]);
    }

    @Override
    public int getItemCount() {
        return dataNameProject.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvProjectList;
        TextView tvProjectDetailList;
        TextView tvLang;
        TextView tvUpdate;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProjectList = itemView.findViewById(R.id.tvProjectList);
            tvProjectDetailList = itemView.findViewById(R.id.tvProjectDetailList);
            tvLang = itemView.findViewById(R.id.tvLang);
            tvUpdate = itemView.findViewById(R.id.tvDate);
        }
    }
}
