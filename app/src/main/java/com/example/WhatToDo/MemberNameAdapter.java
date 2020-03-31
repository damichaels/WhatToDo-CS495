package com.example.WhatToDo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemberNameAdapter extends RecyclerView.Adapter<MemberNameAdapter.TaskViewHolder> {
    private ArrayList<MemberName> mMemberList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(MemberNameAdapter.OnItemClickListener listener) {
        mListener = listener;
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView mMemberName;

        public TaskViewHolder(@NonNull View itemView, final MemberNameAdapter.OnItemClickListener listener) {
            super(itemView);
            mMemberName = itemView.findViewById(R.id.memberName);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

        public MemberNameAdapter(ArrayList<MemberName> memberName) {
            mMemberList = memberName;
        }


        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.member_names, parent, false);
            TaskViewHolder evh = new TaskViewHolder(v,mListener);
            return evh;
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
            MemberName currentTask = mMemberList.get(position);

            holder.mMemberName.setText(currentTask.getText());

        }

        @Override
        public int getItemCount() {
            return mMemberList.size();
        }
    }

