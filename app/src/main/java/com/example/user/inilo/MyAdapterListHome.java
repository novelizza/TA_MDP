package com.example.user.inilo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapterListHome extends RecyclerView.Adapter<MyAdapterListHome.MyViewHolder> {

    String dataUsername[];
    String dataId[];
    String dataCompany[];
    String dataLocation[];
    Integer dataImage[];
    Integer dataFollower[];
    Integer dataFollowing[];
    Integer dataProject[];

    Context context;

    public MyAdapterListHome(Context ct, String username[], String id[], Integer img[], Integer follower[], Integer following[], Integer project[], String company[], String location[]){
        context = ct;
        dataUsername = username;
        dataId = id;
        dataImage = img;
        dataFollower = follower;
        dataFollowing = following;
        dataProject = project;
        dataCompany = company;
        dataLocation = location;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cards_layout_account, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvUsername.setText(dataUsername[position]);
        holder.tvId.setText(dataId[position]);
        holder.ivPP.setImageResource(dataImage[position]);
        holder.tvFollower.setText(String.valueOf(dataFollower[position]));
        holder.tvFollowing.setText(String.valueOf(dataFollowing[position]));
        holder.tvProject.setText(String.valueOf(dataProject[position]));
        holder.cardAccount.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Account account = new Account();

                account.setUsername(dataUsername[position]);
                account.setId(dataId[position]);
                account.setImg(dataImage[position]);
                account.setFollower(dataFollower[position]);
                account.setFollowing(dataFollowing[position]);
                account.setProject(dataProject[position]);
                account.setCompany(dataCompany[position]);
                account.setLocation(dataLocation[position]);

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_ACCOUNT, account);

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataUsername.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvUsername;
        TextView tvId;
        TextView tvFollower;
        TextView tvFollowing;
        TextView tvProject;
        ImageView ivPP;
        LinearLayout cardAccount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvId = itemView.findViewById(R.id.tvId);
            ivPP = itemView.findViewById(R.id.ivPP);
            tvFollower = itemView.findViewById(R.id.tvFollower);
            tvFollowing = itemView.findViewById(R.id.tvFollowing);
            tvProject = itemView.findViewById(R.id.tvProject);
            cardAccount = itemView.findViewById(R.id.main_card_account);
        }
    }
}
