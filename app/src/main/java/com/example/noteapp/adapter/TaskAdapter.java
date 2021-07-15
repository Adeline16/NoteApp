package com.example.noteapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.noteapp.R;
import com.example.noteapp.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    ArrayList<TaskModel> list = new ArrayList<>();
   public void addModel(TaskModel model){
       list.add(model);

   }

    @NonNull
    @NotNull
    @Override
    public TaskAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull TaskAdapter.MyViewHolder holder, int position) {
       holder.OnBind(list.get(position));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,des;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            des = itemView.findViewById(R.id.item_des);
        }

        public void OnBind(TaskModel taskModel) {
            title.setText(taskModel.getTitle());
            des.setText(taskModel.getDes());
        }
    }
}
