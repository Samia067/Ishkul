package com.example.isshkul.model;

public class TeacherNotificationModel {
	public String content ,date ;
	
	
	public TeacherNotificationModel(String student,String course,String date ){
		this.content = student +" requested to join "+ course ;
		this.date = date ;
	}
	
	public TeacherNotificationModel(String content,String date) {
		// TODO Auto-generated constructor stub
		this.content = content ;
		this.date = date ;
	}
}
