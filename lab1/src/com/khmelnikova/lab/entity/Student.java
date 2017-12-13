package com.khmelnikova.lab.entity;

import java.util.HashMap;
import java.util.List;

public class Student {
    private String surname;
    //Subject - Rating
    private HashMap<String, List<Integer>> dairy;

    public Student(String surname, HashMap<String, List<Integer>> dairy) {
        this.surname = surname;
        this.dairy = dairy;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public HashMap<String, List<Integer>> getDairy() {
        return dairy;
    }

    public void setDairy(HashMap<String, List<Integer>> dairy) {
        this.dairy = dairy;
    }

    public void addSubject(String subject, List<Integer> ratingList) {
        if (!dairy.containsKey(subject)) {
            dairy.put(subject, ratingList);
        }
    }

    public void removeSubject(String subject) {
        if (dairy.containsKey(subject)) {
            dairy.remove(subject);
        }
    }

    public float getAvgBySubject(String subject) {
        List<Integer> rating = dairy.get(subject);
        float result = 0;
        for (Integer i : rating) {
            result = result + i;
        }
        return result / rating.size();
    }

    public float getTotalAvg() {
        float result = 0;
        int count = 0;
        for (String subject : dairy.keySet()) {
            result = result + getAvgBySubject(subject);
            count++;
        }
        return result / count;
    }
}
