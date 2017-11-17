package BookModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class DateOfBirth {
	private int day;
	private int month;
	private int year;
	private java.sql.Date fullDOB;

	public DateOfBirth() {
		super();
	}
	
	public DateOfBirth(String s) {
		StringTokenizer st = new StringTokenizer(s, "/");
			this.month = Integer.parseInt(st.nextToken());
			this.day = Integer.parseInt(st.nextToken());
			this.year = Integer.parseInt(st.nextToken());
			try {
				this.fullDOB = new java.sql.Date(new SimpleDateFormat("mm/dd/yyyy").parse(s).getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
	}

	public DateOfBirth(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
		String date = "" + this.month + this.day + this.year;
		try {
			this.fullDOB = new java.sql.Date(new SimpleDateFormat("MMddyyyy").parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public java.sql.Date getFullDOB() {
		return fullDOB;
	}

	public void setFullDOB(java.sql.Date fullDOB) {
		this.fullDOB = fullDOB;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getAge() {
		return Integer.parseInt(new SimpleDateFormat("yyyy").format(new Date()).toString()) - this.year;
	}

}
