package com.example;

public class Course {
    private String courseName, courseDescription, department, courseTime, courseDate;

    public Course(){
        super();
    }

    public Course(String courseName, String courseDescription, String department, String courseTime, String courseDate) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.department = department;
        this.courseTime = courseTime;
        this.courseDate = courseDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(String courseDate) {
        this.courseDate = courseDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", department='" + department + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", courseDate='" + courseDate + '\'' +
                '}';
    }
}