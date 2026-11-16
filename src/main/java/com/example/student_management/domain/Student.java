package com.example.student_management.domain;

public class Student {

    private int id;
    private String name;
    private String email;
    private int num;
    private String course;

    public Student(int id, String name, String email, int num, String course) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.num = num;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}























