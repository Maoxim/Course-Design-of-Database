package com.maoxin.pojo;

public class StuCourse {
    private int id;
    private String student_num;
    private String course_num;
    private int grade;

    public StuCourse() {
    }

    public StuCourse(int id, String student_num, String course_num, int grade) {
        this.id = id;
        this.student_num = student_num;
        this.course_num = course_num;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_num() {
        return student_num;
    }

    public void setStudent_num(String student_num) {
        this.student_num = student_num;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
