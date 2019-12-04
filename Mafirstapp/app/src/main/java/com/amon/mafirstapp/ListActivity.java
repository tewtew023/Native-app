package com.amon.mafirstapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private ArrayList<String> list = new ArrayList<String>();
    private ArrayList<String> pic = new ArrayList<String>();
    private ArrayList<String> category = new ArrayList<String>();
    private ArrayList<String> id = new ArrayList<String>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);




        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


//        String[] myDataset = {"Item 1", "Item 2", "Item 3"};

        final String TAG = "testFireStore";
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("shops")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                System.out.println("name here!!!!!!!!!!!!!"+document.get("name"));

                                list.add(document.get("name").toString());

                                pic.add(document.get("url").toString());

                                id.add(document.getId());
                                category.add(document.get("category").toString());
                                System.out.println("url here!!!!!!!!!!!!!"+document.get("url"));
                            }

                            System.out.println("list"+list+"pic"+pic+"id"+id);

                            String[] name = list.toArray(new String[0]);
                            String[] Pic = pic.toArray(new String[0]);
                            String[] Category = category.toArray(new String[0]);
                            System.out.println("list"+name+"pic"+Pic+"id"+Category);

                            mAdapter = new MyAdapter(ListActivity.this,Pic,name,Category);
                            recyclerView.setAdapter(mAdapter);

                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });


    }




}
