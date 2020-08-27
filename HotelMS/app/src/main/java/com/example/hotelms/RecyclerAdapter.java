package com.example.hotelms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    Context ct;
    ArrayList<Room> roomAl;
    public RecyclerAdapter(Context ct, ArrayList<Room> roomAl) {
        this.ct=ct;
        this.roomAl=roomAl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li=LayoutInflater.from(ct);
        View v=li.inflate(R.layout.recyclerlayout,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Room r=roomAl.get(position);
        holder.tvname.setText(r.getName());
        holder.tvnumber.setText(r.getNumber());
        holder.tvsize.setText(""+r.getSize());
        holder.tvbeds.setText(""+r.getNoofbeds());
        holder.iv.setImageResource(r.getImage());
        holder.book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase md=new MyDatabase(ct);
                MyDatabase2 md2=new MyDatabase2(ct);
                md2.insertBook(r.getName(),r.getNumber(),r.getSize(),r.getNoofbeds());
                md.delete(0,r.getNumber());
                Intent i=new Intent(ct,BookAct.class);
                ct.startActivity(i);
                Activity a=(Activity) ct;
                a.finish();
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase md=new MyDatabase(ct);
                md.delete(0,""+r.getNumber());
                Activity a=(Activity) ct;
                a.recreate();
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomAl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvname,tvnumber,tvbeds,tvsize;
        ImageView iv;
        LinearLayout layout;
        Button book,delete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.roomname);
            tvnumber=itemView.findViewById(R.id.roomnumber);
            tvsize=itemView.findViewById(R.id.roomsize);
            tvbeds=itemView.findViewById(R.id.noofbeds);
            iv=itemView.findViewById(R.id.roomiv);
            layout=itemView.findViewById(R.id.ll);
            book=itemView.findViewById(R.id.bookbtn);
            delete=itemView.findViewById(R.id.delbtn);
        }
    }
}
