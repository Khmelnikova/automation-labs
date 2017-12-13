package com.khmelnikova.lab.entity;

import java.util.LinkedList;
import java.util.List;

public class Group {
    private String name;
    private List<Student> studentList = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public float getAvgBySubject(String subject) {
        float result = 0;
        for (Student student : studentList) {
            result = result + student.getAvgBySubject(subject);
        }
        return result / studentList.size();
    }

    public float getTotalAvg() {
        float result = 0;
        for (Student student : studentList) {
            result = result + student.getTotalAvg();
        }
        return result / studentList.size();
    }
}
