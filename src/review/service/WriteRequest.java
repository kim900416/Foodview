package review.service;

import java.util.Map;

import review.model.Writer;

public class WriteRequest {

	private Writer writer;
	private String title;
	private String content;
	private String grade;
	private String fnum;
	
	public WriteRequest(
			Writer writer,String title, String content, String grade, String fnum) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.grade = grade;
		this.fnum = fnum;
	}
	
	

	public Writer getWriter() {
		return writer;
	}
	
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
	
	public String getGrade() {
		return grade;
	}

	public String getFnum() {
		return fnum;
	}
	public int getIntFnum() {
		return Integer.parseInt(fnum);
	}
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
	}
}
