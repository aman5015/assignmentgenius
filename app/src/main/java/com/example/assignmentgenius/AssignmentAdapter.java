// AssignmentAdapter.java
package com.example.assignmentgenius;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.AssignmentViewHolder> {

    private List<Assignment> assignmentList;
    private Context context;

    public AssignmentAdapter(List<Assignment> assignmentList, Context context) {
        this.assignmentList = assignmentList;
        this.context = context;
    }

    @NonNull
    @Override
    public AssignmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.assignment_item, parent, false);
        return new AssignmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AssignmentViewHolder holder, int position) {
        Assignment assignment = assignmentList.get(position);
        holder.tvAssignmentTitle.setText(assignment.getTitle());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        holder.tvAssignmentDueDate.setText("Due Date: " + dateFormat.format(assignment.getDueDate()));

        holder.tvStudyMaterialLink.setText(assignment.getStudyMaterialLink());
        holder.tvStudyMaterialLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(assignment.getStudyMaterialLink()));
            context.startActivity(browserIntent);
        });
    }

    @Override
    public int getItemCount() {
        return assignmentList.size();
    }

    static class AssignmentViewHolder extends RecyclerView.ViewHolder {
        TextView tvAssignmentTitle, tvAssignmentDueDate, tvStudyMaterialLink;

        public AssignmentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAssignmentTitle = itemView.findViewById(R.id.assignmentTitle);
            tvAssignmentDueDate = itemView.findViewById(R.id.assignmentDueDate);
            tvStudyMaterialLink = itemView.findViewById(R.id.studyMaterialLink);
        }
    }
}
