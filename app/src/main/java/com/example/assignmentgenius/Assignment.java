// Assignment.java
package com.example.assignmentgenius;

import java.util.Date;

public class Assignment {
    private String title;
    private Date dueDate;
    private String studyMaterialLink;

    public Assignment(String title, Date dueDate, String studyMaterialLink) {
        this.title = title;
        this.dueDate = dueDate;
        this.studyMaterialLink = studyMaterialLink;
    }

    public String getTitle() {
        return title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getStudyMaterialLink() {
        return studyMaterialLink;
    }
}
