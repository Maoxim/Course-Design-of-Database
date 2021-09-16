package com.maoxin.pojo;

public class Course {
    private String courseNum;
    private String courseName;
    private String courseDesc;
    private String courseTea;

    public Course(){

    }
    public Course(String courseNum, String courseName, String courseDesc, String courseTea) {
        this.courseNum = courseNum;
        this.courseName = courseName;
        this.courseDesc = courseDesc;
        this.courseTea = courseTea;
    }

    public String getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(String courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public String getCourseTea() {
        return courseTea;
    }

    public void setCourseTea(String courseTea) {
        this.courseTea = courseTea;
    }
}
