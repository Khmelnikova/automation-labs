package com.khmelnikova.lab.entity;

import java.util.LinkedList;
import java.util.List;

public class University {
    private List<Faculty> facultyList = new LinkedList<>();

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public void addFaculty(Faculty faculty) {
        facultyList.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        facultyList.remove(faculty);
    }

    public float getAvgBySubject(String subject) {
        float result = 0;
        for (Faculty faculty : facultyList) {
            result = result + faculty.getAvgBySubject(subject);
        }
        return result / facultyList.size();
    }

    public float getTotalAvg() {
        float result = 0;
        for (Faculty faculty : facultyList) {
            result = result + faculty.getTotalAvg();
        }
        return result / facultyList.size();
    }
}
