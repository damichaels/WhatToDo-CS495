package com.example.WhatToDo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class taskItemAdapter extends RecyclerView.Adapter<taskItemAdapter.TaskViewHolder> {
    private ArrayList<taskItem> mTaskList;

    private taskItemAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(taskItemAdapter.OnItemClickListener listener){
        mListener=listener;
    }
    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView mTaskName;
        public TextView mTaskValue;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mTaskName= itemView.findViewById(R.id.taskName);
            mTaskValue= itemView.findViewById(R.id.taskValue);
        }
    }
    public taskItemAdapter(ArrayList<taskItem> taskItems){
        mTaskList=taskItems;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        TaskViewHolder evh = new TaskViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        taskItem currentTask = mTaskList.get(position);

        holder.mTaskName.setText(currentTask.getText());
        holder.mTaskValue.setText(currentTask.getText2());
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }
}
