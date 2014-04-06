package com.example.ishkul.student;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class DiscussionCommentModel {
	public String name;
	//image
	//file
	public SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm");
	//public Date date;
	Calendar calendar = new GregorianCalendar();
	public String comment;
	boolean hasFile = false;
	
	public DiscussionCommentModel(String name, int year, int month, int day, int hour, int minute, String comment, boolean hasFile)
	{
		this.name = name;
		this.calendar =  new GregorianCalendar(year, month, day, hour, minute);
		this.comment = comment;
		this.hasFile = hasFile;
	}
	public DiscussionCommentModel(String name, int year, int month, int day, int hour, int minute, String comment)
	{
		this.name = name;
		this.calendar =  new GregorianCalendar(year, month, day, hour, minute);
		this.comment = comment;
		this.hasFile = false;
	}
	String getTime()
	{
		return sdf.format(calendar.getTime());
	}
}
