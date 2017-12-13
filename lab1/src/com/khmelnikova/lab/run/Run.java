package com.khmelnikova.lab.run;

import com.khmelnikova.lab.entity.Faculty;
import com.khmelnikova.lab.entity.Group;
import com.khmelnikova.lab.entity.Student;
import com.khmelnikova.lab.entity.University;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Run {
    private static final String MATH = "Math";
    private static final String BIOLOGY = "Biology";
    private static final String GEOGRAPHY = "Geography";

    private University university;

    DecimalFormat df = new DecimalFormat("#.##");

    public void run(){
        initFields();

        university.getFacultyList().forEach(faculty -> {
            showFaculty(faculty);
            faculty.getGroupList().forEach(group -> {
                showGroup(faculty.getName(), group);
                group.getStudentList().forEach(student -> showStudent(faculty.getName(), group.getName(), student));
            });
        });
    }

    private void showStudent(String facultyName, String groupName, Student student) {
        System.out.println("==STUDENT==");
        System.out.println("Faculty:" + facultyName);
        System.out.println("Group:" + groupName);
        System.out.println("Surname:" + student.getSurname());
        System.out.println("avg MATH = " + df.format(student.getAvgBySubject(MATH)) +
                            ", avg BIOLOGY = " + df.format(student.getAvgBySubject(BIOLOGY)) +
                            ", avg GEOGRAPHY = " + df.format(student.getAvgBySubject(GEOGRAPHY)));
        System.out.println("total avg = " + df.format(student.getTotalAvg()));
    }

    private void showGroup(String facultyName, Group group) {
        System.out.println("==GROUP==");
        System.out.println("Faculty:" + facultyName);
        System.out.println("Name: " + group.getName());
        System.out.println("avg MATH = " + df.format(group.getAvgBySubject(MATH)) +
                            ", avg BIOLOGY = " + df.format(group.getAvgBySubject(BIOLOGY)) +
                            ", avg GEOGRAPHY = " + df.format(group.getAvgBySubject(GEOGRAPHY)));
        System.out.println("total avg = " + df.format(group.getTotalAvg()));
    }

    private void showFaculty(Faculty faculty) {
        System.out.println("==FACULTY==");
        System.out.println("Name:" + faculty.getName());
        System.out.println("avg MATH = " + df.format(faculty.getAvgBySubject(MATH)) +
                            ", avg BIOLOGY = " + df.format(faculty.getAvgBySubject(BIOLOGY)) +
                            ", avg GEOGRAPHY = " + df.format(faculty.getAvgBySubject(GEOGRAPHY)));
        System.out.println("total avg = " + df.format(faculty.getTotalAvg()));
    }

    private void initFields() {
        Student student11 = new Student("Ivanov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(5, 5, 5));
            put(BIOLOGY, Arrays.asList(5, 4, 5));
            put(GEOGRAPHY, Arrays.asList(3,5,3));
        }});
        Student student12 = new Student("Petrov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(5, 5, 5));
            put(BIOLOGY, Arrays.asList(5, 4, 5));
            put(GEOGRAPHY, Arrays.asList(3,5,3));
        }});
        Group group1 = new Group();
        group1.setName("group 1");
        group1.addStudent(student11);
        group1.addStudent(student12);
        Student student21 = new Student("Ivanov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(3, 4, 5));
            put(BIOLOGY, Arrays.asList(4, 4, 3));
            put(GEOGRAPHY, Arrays.asList(3,5,4));
        }});
        Student student22 = new Student("Petrov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(5, 2, 4));
            put(BIOLOGY, Arrays.asList(5, 2, 3));
            put(GEOGRAPHY, Arrays.asList(5,5,5));
        }});
        Group group2 = new Group();
        group2.setName("group 2");
        group2.addStudent(student21);
        group2.addStudent(student22);
        Student student31 = new Student("Ivanov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(4, 5, 3));
            put(BIOLOGY, Arrays.asList(5, 4, 5));
            put(GEOGRAPHY, Arrays.asList(3,3,3));
        }});
        Student student32 = new Student("Petrov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(5, 5, 5));
            put(BIOLOGY, Arrays.asList(5, 5, 5));
            put(GEOGRAPHY, Arrays.asList(3,2,3));
        }});
        Group group3 = new Group();
        group3.setName("group 3");
        group3.addStudent(student31);
        group3.addStudent(student32);
        Student student41 = new Student("Ivanov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(4, 5, 4));
            put(BIOLOGY, Arrays.asList(4, 4, 4));
            put(GEOGRAPHY, Arrays.asList(2,2,2));
        }});
        Student student42 = new Student("Petrov", new HashMap<String, List<Integer>>() {{
            put(MATH, Arrays.asList(3, 4, 2));
            put(BIOLOGY, Arrays.asList(4, 3, 5));
            put(GEOGRAPHY, Arrays.asList(2,3,2));
        }});
        Group group4 = new Group();
        group4.setName("group 4");
        group4.addStudent(student41);
        group4.addStudent(student42);

        Faculty faculty1 = new Faculty();
        faculty1.setName("faculty 1");
        faculty1.addGroup(group1);
        faculty1.addGroup(group2);
        Faculty faculty2 = new Faculty();
        faculty2.setName("faculty 2");
        faculty2.addGroup(group3);
        faculty2.addGroup(group4);

        university = new University();
        university.addFaculty(faculty1);
        university.addFaculty(faculty2);
    }
}
