package com.example.hellospring2020;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.Activity;
import android.view.View;

import java.util.ArrayList;

public class YourTaskList extends Activity {
    private RecyclerView mRecyclerView;
    private taskItemAdapter2 mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<taskItem> mtaskNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_namelist);
        ArrayList<taskItem> taskList = new ArrayList<>();
        taskList.add(new taskItem("Mow Lawn", "50"));
        taskList.add(new taskItem("Wash Dishes", "10"));
        taskList.add(new taskItem("Feed Cat", "20"));
        taskList.add(new taskItem("Fold Laundry", "20"));
        mRecyclerView = findViewById(R.id.recycle_view2);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new taskItemAdapter2(taskList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new taskItemAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Ganesh();
            }
        });
    }
    public void Ganesh(){
        Intent ganesh = new Intent(this, TaskDescription.class);
        startActivity(ganesh);
    }
}
