package com.example.assignmentgenius.Model;

public class PreviousAssignment {
    private final String title;
    private final String date;
    private final String solution;

    public PreviousAssignment(String title, String date, String solution) {
        this.title = title;
        this.date = date;
        this.solution = solution;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getSolution() {
        return solution;
    }
}

