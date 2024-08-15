package com.example.assignmentgenius.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignmentgenius.Model.PreviousAssignment;
import com.example.assignmentgenius.R;

import java.util.List;

public class PreviousAssignmentAdapter extends RecyclerView.Adapter<PreviousAssignmentAdapter.ViewHolder> {

    private final List<PreviousAssignment> assignments;

    public PreviousAssignmentAdapter(List<PreviousAssignment> assignments) {
        this.assignments = assignments;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.previous_assignment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PreviousAssignment assignment = assignments.get(position);
        holder.titleTextView.setText(assignment.getTitle());
        holder.dateTextView.setText(assignment.getDate());
        holder.solutionTextView.setText(assignment.getSolution());
        // Optional: Set PDF icon click listener if needed
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView dateTextView;
        TextView solutionTextView;
        ImageView pdfIcon;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            solutionTextView = itemView.findViewById(R.id.solutionTextView);
            pdfIcon = itemView.findViewById(R.id.pdfIcon);
        }
    }
}

