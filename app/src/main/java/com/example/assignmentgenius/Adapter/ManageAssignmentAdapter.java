package com.example.assignmentgenius.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgenius.Model.ManageAssignment;
import com.example.assignmentgenius.R;

import java.util.List;

public class ManageAssignmentAdapter extends RecyclerView.Adapter<ManageAssignmentAdapter.ViewHolder> {

    private final List<ManageAssignment> assignments; // Correct type here

    public ManageAssignmentAdapter(List<ManageAssignment> assignments) { // Match constructor parameter type
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.add_manage_assignment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ManageAssignment assignment = assignments.get(position);
        holder.titleTextView.setText(assignment.getTitle());
        holder.subjectTextView.setText(assignment.getSubject());
        holder.dueDateTextView.setText(assignment.getDueDate());
        holder.dueTimeTextView.setText(assignment.getDueTime());
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView titleTextView;
        final TextView subjectTextView;
        final TextView dueDateTextView;
        final TextView dueTimeTextView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subjectTextView = itemView.findViewById(R.id.subjectTextView);
            dueDateTextView = itemView.findViewById(R.id.dueDateTextView);
            dueTimeTextView = itemView.findViewById(R.id.dueTimeTextView);
        }
    }
}
