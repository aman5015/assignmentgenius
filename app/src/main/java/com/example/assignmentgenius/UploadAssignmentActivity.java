package com.example.assignmentgenius;

// Inside your activity class

// Import necessary packages
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UploadAssignmentActivity extends Activity {
    private static final int REQUEST_CODE_ASSIGNMENT = 1;
    private static final int REQUEST_CODE_SOLUTION = 2;

    private EditText etAssignmentTitle;
    private EditText etAssignmentDescription;
    private TextView tvAssignmentPreview;
    private TextView tvSolutionPreview;
    private Uri assignmentUri;
    private Uri solutionUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_assignment);

        etAssignmentTitle = findViewById(R.id.etAssignmentTitle);
        etAssignmentDescription = findViewById(R.id.etAssignmentDescription);
        tvAssignmentPreview = findViewById(R.id.tvAssignmentPreview);
        tvSolutionPreview = findViewById(R.id.tvSolutionPreview);

        Button btnUploadAssignment = findViewById(R.id.btnUploadAssignment);
        btnUploadAssignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(REQUEST_CODE_ASSIGNMENT);
            }
        });

        Button btnUploadSolution = findViewById(R.id.btnUploadSolution);
        btnUploadSolution.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilePicker(REQUEST_CODE_SOLUTION);
            }
        });

        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitAssignment();
            }
        });

        Button btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnViewPrevious = findViewById(R.id.btnViewPrevious);
        btnViewPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPreviousAssignments();
            }
        });
    }

    private void openFilePicker(int requestCode) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("*/*");
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                if (requestCode == REQUEST_CODE_ASSIGNMENT) {
                    assignmentUri = uri;
                    tvAssignmentPreview.setText("Assignment: " + uri.getLastPathSegment());
                } else if (requestCode == REQUEST_CODE_SOLUTION) {
                    solutionUri = uri;
                    tvSolutionPreview.setText("Solution: " + uri.getLastPathSegment());
                }
            }
        }
    }

    private void submitAssignment() {
        String title = etAssignmentTitle.getText().toString().trim();
        String description = etAssignmentDescription.getText().toString().trim();

        if (title.isEmpty() || description.isEmpty() || assignmentUri == null || solutionUri == null) {
            Toast.makeText(this, "Please fill in all fields and upload both files", Toast.LENGTH_LONG).show();
            return;
        }

        // Logic to handle the submitted assignment and solution
        Toast.makeText(this, "Assignment submitted successfully!", Toast.LENGTH_SHORT).show();
        // Add actual submission logic here

        // Clear fields and reset previews
        etAssignmentTitle.setText("");
        etAssignmentDescription.setText("");
        tvAssignmentPreview.setText("No assignment uploaded");
        tvSolutionPreview.setText("No solution uploaded");
    }

    private void viewPreviousAssignments() {
        // Logic to view previous assignments
        Toast.makeText(this, "Displaying previous assignments...", Toast.LENGTH_SHORT).show();
        // Add actual logic to view previous assignments here
    }
}
