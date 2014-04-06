package com.example.isshkul;

public class TaskModel {
	public String courseNumber;
	public String name;
	public String type;
	public String due;
 
    public TaskModel(String type, String name, String courseNumber, String due) {
        this.name = name;
        this.type = type;
        this.courseNumber = courseNumber;
        this.due = due;
    }
    
    public String getTypeName()
    {
    	return type + ": " + name;
    }
}
