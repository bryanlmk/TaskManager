package com.myapplicationdev.android.taskmanager;

import java.io.Serializable;

public class Task implements Serializable{
    private int id;
    private String taskName;
    private String description;

    public Task(int id,String taskName,String description) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
    }

    public int getId() { return id; }

    public String getTaskName() { return taskName; }

    public  String getDescription(){ return description; }

    @Override
    public String toString() {
        return "ID:" + id + ", " + taskName + ", " + description;
    }

}



