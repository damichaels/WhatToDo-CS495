package com.example.hellospring2020;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.TaskViewHolder> {
    private ArrayList<GroupName> mGroupList;
    public static class TaskViewHolder extends RecyclerView.ViewHolder{
        public TextView mGroupName;


        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            mGroupName= itemView.findViewById(R.id.groupName);
        }
    }
    public GroupListAdapter(ArrayList<GroupName> groupName){
        mGroupList=groupName;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item,parent,false);
        TaskViewHolder evh = new TaskViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        GroupName currentTask = mGroupList.get(position);

        holder.mGroupName.setText(currentTask.getText());

    }

    @Override
    public int getItemCount() {
        return mGroupList.size();
    }
}
