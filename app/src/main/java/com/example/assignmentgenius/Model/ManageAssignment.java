package com.example.assignmentgenius.Model;

public class ManageAssignment {
    private String title;
    private String subject;
    private String dueDate;
    private String dueTime;

    public ManageAssignment(String title, String subject, String dueDate, String dueTime) {
        this.title = title;
        this.subject = subject;
        this.dueDate = dueDate;
        this.dueTime = dueTime;
    }

    public String getTitle() {
        return title;
    }

    public String getSubject() {
        return subject;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }
}

