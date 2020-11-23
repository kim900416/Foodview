package admin.service;

import java.util.Map;

import admin.model.FoodIntro;
import review.model.Writer;

public class WriteFoodIntroRequest {

	private String grade;
	private String name;
	private int reviewNum;
	private String imageAddress;
	private String title;
	private String content;
	private String introduce;
	private int fnum;

	public WriteFoodIntroRequest
	(FoodIntro foodIntro, String imageAddress, String title,
			String content, String introduce) {
		this.title = title;
		this.imageAddress = imageAddress;
		this.content = content;
		this.introduce = introduce;	
	}
	
	public WriteFoodIntroRequest
	(String title, String imageAddress, String content, String introduce) {
		this.title = title;
		this.imageAddress = imageAddress;
		this.content = content;
		this.introduce = introduce;
	}
	
	

	public String getName() {
		return name;
	}	
	public String getGrade() {
		return grade;
	}
	public int getReviewNum() {
		return reviewNum;
	}	
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public String getIntroduce() {
		return introduce;
	}
	public int getFnum() {
		return fnum;
	}
	public void validate(Map<String, Boolean> errors) {
		if (title == null || title.trim().isEmpty()) {
			errors.put("title", Boolean.TRUE);
		}
		if (introduce == null || introduce.trim().isEmpty()) {
			errors.put("introduce", Boolean.TRUE);
		}
		if (content == null || content.trim().isEmpty()) {
			errors.put("content", Boolean.TRUE);
		}
	}
}