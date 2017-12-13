package com.khmelnikova.lab.entity;

import java.util.LinkedList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groupList = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public void addGroup(Group group) {
        groupList.add(group);
    }

    public void removeGroup(Group group) {
        groupList.remove(group);
    }

    public float getAvgBySubject(String subject) {
        float result = 0;
        for (Group group : groupList) {
            result = result + group.getAvgBySubject(subject);
        }
        return result / groupList.size();
    }

    public float getTotalAvg() {
        float result = 0;
        for (Group group : groupList) {
            result = result + group.getTotalAvg();
        }
        return result / groupList.size();
    }
}
