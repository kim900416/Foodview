package review.model;

import java.util.Date;

public class Review {

	private Integer number;
	private Writer writer;
	private String title;
	private String grade;	
	private Date regDate;
	private String fnum;	
	private int readCount;


	public Review(String grade) {
		this.grade = grade;		
	}
	
	
	public Review(Integer number, Writer writer, String title, String grade, String fnum,
			Date regDate, int readCount) {
		this.number = number;
		this.writer = writer;
		this.title = title;
		this.regDate = regDate;
		this.grade = grade;
		this.fnum = fnum;
		//this.modifiedDate = modifiedDate;
		this.readCount = readCount;
	}

	public Integer getNumber() {
		return number;
	}

	public Writer  getWriter() {
		return writer;
	}

	public String  getTitle() {
		return title;
	}
	
	public String  getGrade() {
		return grade;
	}
		
	public String  getFnum() {
		return fnum;
	}

	public int getIntFnum() {
		return Integer.parseInt(fnum);
	}
	
	public Date getRegDate() {
		return regDate;
	}

	public int  getReadCount() {
		return readCount;
	}	

}
