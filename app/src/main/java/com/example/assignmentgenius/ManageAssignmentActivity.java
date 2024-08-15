package com.example.assignmentgenius;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgenius.Adapter.ManageAssignmentAdapter;
import com.example.assignmentgenius.Model.ManageAssignment;

import java.util.ArrayList;
import java.util.List;

public class ManageAssignmentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_assignment);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create dummy data
        List<ManageAssignment> dummyAssignments = new ArrayList<>();
        dummyAssignments.add(new ManageAssignment("Maths Assignment 1", "Discrete Strucuture", "2024-08-01", "14:00"));
        dummyAssignments.add(new ManageAssignment("Java Assignment 1", "OOPs using Java", "2024-08-10", "16:30"));
        dummyAssignments.add(new ManageAssignment("Maths Assignment 2", "Discrete Strucuture", "2024-08-01", "14:00"));
        dummyAssignments.add(new ManageAssignment("Java Assignment 2", "OOPs using Java", "2024-08-10", "16:30"));

        // Set up the adapter
        ManageAssignmentAdapter adapter = new ManageAssignmentAdapter(dummyAssignments);
        recyclerView.setAdapter(adapter);

    }
}
