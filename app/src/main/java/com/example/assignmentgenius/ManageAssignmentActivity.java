// ManageAssignmentActivity.java
package com.example.assignmentgenius;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Date;

public class ManageAssignmentActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AssignmentAdapter adapter;
    private ArrayList<Assignment> assignmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_assignment);

        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton fab = findViewById(R.id.fab);

        assignmentList = new ArrayList<>();
        adapter = new AssignmentAdapter(assignmentList, this); // Pass context to adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add new assignment - For testing, add a dummy assignment
                addDummyAssignment();
            }
        });
    }

    private void addDummyAssignment() {
        assignmentList.add(new Assignment("Your Assignment", new Date(), "https://www.instagram.com"));
        adapter.notifyDataSetChanged();
        Toast.makeText(this, "New assignment added", Toast.LENGTH_SHORT).show();
    }
}
