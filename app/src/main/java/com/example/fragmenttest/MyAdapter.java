package com.example.fragmenttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    ArrayList<Course> courseArrayList;

    public MyAdapter(Context context, ArrayList<Course> courseArrayList) {
        this.context = context;
        this.courseArrayList = courseArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        Course addCourse = courseArrayList.get(position);
        holder.title.setText(addCourse.getTitle());
        holder.date.setText(addCourse.getDate());
        holder.producer.setText(addCourse.getProducer());
        holder.length.setText(addCourse.getLength());


    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title,date,producer,length;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.addressshow);
            date=itemView.findViewById(R.id.timeshow);
            producer=itemView.findViewById(R.id.producershow);
            length=itemView.findViewById(R.id.lengthshow);

        }
    }

}
