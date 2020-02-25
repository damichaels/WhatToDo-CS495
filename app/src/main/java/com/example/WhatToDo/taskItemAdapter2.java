package com.example.hellospring2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class taskItemAdapter2 extends RecyclerView.Adapter<taskItemAdapter2.TaskViewHolder> {
    private ArrayList<taskItem> mTaskList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView mTaskName;
        public TextView mTaskValue;

        public TaskViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mTaskName= itemView.findViewById(R.id.taskName);
            mTaskValue= itemView.findViewById(R.id.taskValue);

            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public taskItemAdapter2(ArrayList<taskItem> taskItems){
        mTaskList=taskItems;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item2,parent,false);
        TaskViewHolder evh = new TaskViewHolder(v,mListener);
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
