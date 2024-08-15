package com.example.assignmentgenius;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgenius.Adapter.PreviousAssignmentAdapter;
import com.example.assignmentgenius.Model.PreviousAssignment;

import java.util.ArrayList;
import java.util.List;

public class ViewPreviousAssignmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_previous_assignments);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create dummy data
        List<PreviousAssignment> dummyAssignments = new ArrayList<>();
        dummyAssignments.add(new PreviousAssignment("Maths Assignment 1", "2024-08-01", "Click on the PDF to see the solution"));
        dummyAssignments.add(new PreviousAssignment("Java Assignment 2", "2024-08-10", "Click on the PDF to see the solution"));

        // Set up the adapter
        PreviousAssignmentAdapter adapter = new PreviousAssignmentAdapter(dummyAssignments);
        recyclerView.setAdapter(adapter);
    }
}
