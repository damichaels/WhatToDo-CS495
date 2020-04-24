package com.example.WhatToDo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

/*
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/


public class gList extends AppCompatActivity {
    private FirebaseFirestore db;
    private RecyclerView mRecyclerView;

    private GroupListAdapter mAdapter;
   // private FirestoreRecyclerAdapter<Group, GroupViewHolder> adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Query query;
    private ArrayList<GroupName> groupList;
    public ArrayList<String> array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_list);
        groupList = new ArrayList<>();
//        final ArrayList<String> array = new ArrayList<>();
        int a, b;
        final Button btnCreateGroup = (Button) findViewById(R.id.button_create);
        final Button btnJoinGroup = (Button) findViewById(R.id.button_join);
        final User newUser = (User) getIntent().getSerializableExtra("user");
        final Group newGroup = (Group) getIntent().getSerializableExtra("group");
    //    loadGroups(newUser.getuID());

        db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("users").document(newUser.getuID());
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
              @Override
              public void onSuccess(DocumentSnapshot documentSnapshot) {
                  User myUser = documentSnapshot.toObject(User.class);
                  int x, y = myUser.getGroupCount();

                  for (x = 1; x <= y; x++) {
                      //         Query query = db.collection("users").document(myUser.getuID()).collection("Groups").orderBy("gName", Query.Direction.ASCENDING);
                      //         Group myGroup = query.g
                          DocumentReference docRef1 = db.collection("users").document(myUser.getuID()).collection("groups").document(String.valueOf(x));
                                                      //                   Task<DocumentSnapshot> ds = docRef1.get();
                                                      //                  DocumentSnapshot ds1 = ds.getResult();
                                                      //                Group myGroup = ds1.toObject(Group.class);
                                                      //              groupList.add(new GroupName(myGroup.getgName()));

                      docRef1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                          @Override
                          public void onSuccess(DocumentSnapshot documentSnapshot) {
                              Group myGroup = documentSnapshot.toObject(Group.class);
                              System.out.println(myGroup.getgName() + " IS IN DATABASE");
                              groupList.add(new GroupName(myGroup.getgName()));
//                            array.add(myGroup.getgName());
                              System.out.println("THIS IS A TEST OF GREAT IMPORTANCE");
                                                              //                     }
                                                              //                   });
                          }

                      });
                  }
              }
        });
 /*       for (a = 0; a < groupList.size(); a++) {
   //         groupList.add(new GroupName(array.get(a)));
            System.out.println(groupList.get(a).getText());
        }
*/

        groupList.add(new GroupName("Smith Family Chores"));
        groupList.add(new GroupName("Bama Roommates"));
        groupList.add(new GroupName("The Office"));

        if (newGroup != null) {
            groupList.add(new GroupName(newGroup.getgName()));
        }
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GroupListAdapter(groupList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
//        db = FirebaseFirestore.getInstance();


//        db = FirebaseFirestore.getInstance();

/*        Query query = db.collection("users").document(newUser.getuID()).collection("Groups").orderBy("gName", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Group> groups = new FirestoreRecyclerOptions.Builder<Group>()
                .setQuery(query, Group.class)
                .build();

 */
/*
        mAdapter = new GroupListAdapter(groupList);
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
  *//*      adapter = new FirestoreRecyclerAdapter<Group, GroupViewHolder>(groups) {
            @Override
            protected void onBindViewHolder(@NonNull GroupViewHolder holder, int position, @NonNull Group group) {
                holder.setGroupName(group.getgName());
            }

            @NonNull
            @Override
            public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_list, parent, false);
                return new GroupViewHolder(view);
            }
        };

        adapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(adapter);
*/
        mAdapter.setOnItemClickListener(new GroupListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent today = new Intent(getBaseContext(), TodayTaskList.class);
                today.putExtra("group", newGroup);
                startActivity(today);
            }
        });

        btnCreateGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), CreateGroup.class);
                myIntent.putExtra("user", newUser);
                startActivity(myIntent);
            }
        });
        btnJoinGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getBaseContext(), JoinGroup.class);
                myIntent.putExtra("user", newUser);
                startActivity(myIntent);
            }
        });
    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAdapter != null) {
            mAdapter.stopListening();
        }
    }


    public void loadGroups(String uID) {
        final ArrayList<String> gList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("users").document(uID);
        System.out.println("TESTING123333333333333333");
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
  //              ArrayList<String> gList = new ArrayList<>();
                System.out.println("TESTING456666666666666");
                User myUser = documentSnapshot.toObject(User.class);
                int x, y = myUser.getGroupCount();

                for (x = 1; x <= y; x++) {
                    DocumentReference docRef1 = db.collection("users").document(myUser.getuID()).collection("groups").document(String.valueOf(x));
                    Task<DocumentSnapshot> ds = docRef1.get();
                    DocumentSnapshot ds1 = ds.getResult();
                    Group myGroup = ds1.toObject(Group.class);
                    groupList.add(new GroupName(myGroup.getgName()));

                    docRef1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                        @Override
                        public void onSuccess(DocumentSnapshot documentSnapshot) {
                            Group myGroup = documentSnapshot.toObject(Group.class);
                            groupList.add(new GroupName(myGroup.getgName()));
                            System.out.println(myGroup.getgName());
  //                          array.add(myGroup.getgName());
                        }
                    });
                }
                for (x = 0; x < y; x++) {
                    System.out.println(groupList.get(x).getText());
                }

            }
        });
    }
*/

 /*   public class GroupViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        private View view;

        public GroupViewHolder(View itemView) {
            super(itemView);
            view = itemView;
        }

        void setGroupName(String gName) {
            TextView textview = view.findViewById(R.id.textView);
            textview.setText(gName);
        }
    }
    */

}
