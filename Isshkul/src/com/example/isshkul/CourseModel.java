package com.example.isshkul;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CourseModel {
	public String courseName;
	public String courseNumber;
	public String teacherName;
	public int length;
	//pic of teacher
	public String status = null;
	public SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy");
	Calendar startDate = new GregorianCalendar();
	Calendar endDate = new GregorianCalendar();

	public CourseModel(String courseName, String courseNumber, String teacherName, int year, int month, int day,int lengthInWeeks)
	{
		this.courseName = courseName;
		this.startDate =  new GregorianCalendar(year, month, day);
		this.endDate =  new GregorianCalendar(year, month, day);
		endDate.add(Calendar.WEEK_OF_YEAR, lengthInWeeks);
		this.courseNumber = courseNumber;
		this.teacherName = teacherName;
		this.length = lengthInWeeks;
		
		//set status
		if (Calendar.getInstance().after(endDate))
			status = "Ended";
		else if (Calendar.getInstance().before(startDate))
			status = "Not started";
		else 
			status = "Active";
	}
	public String getStartDate()
	{
		return sdf.format(startDate.getTime());
	}
	
}
