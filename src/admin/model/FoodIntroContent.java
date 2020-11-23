package admin.model;

public class FoodIntroContent {

	private Integer number;
	private String imageAddress;
	private String title;
	private String content;
	private String introduce;
	private String grade;
	private int fnum;
	private int viewNum;
	

	public FoodIntroContent(Integer number, String imageAddress,
			String title, String content, String introduce, int fnum) {
	    this.number = number;
	    this.content = content;
	    this.title = title;
	    this.content = content;
	    this.introduce = introduce;
	    this.imageAddress = imageAddress;
	    this.fnum = fnum;
	}

	public FoodIntroContent(String imageAddress, String title,	
			String content, String introduce, String grade, int fnum, int viewNum) {
			    
	    this.title = title;
	    this.content = content;
	    this.introduce = introduce;
	    this.imageAddress = imageAddress;
	    this.grade = grade;
	    this.viewNum = viewNum;		
	    this.fnum = fnum;
	}
	
	public Integer getNumber() {
	    return number;
	   }
	public String getContent() {
		return content;
	   }	   
	public String getImageAddress() {
		return imageAddress;
		}
	public String getTitle() {
		return title;
		}
	public String getIntroduce() {
		return introduce;
		}
	public String getGrade() {
		return grade;
	}
	public int getFnum() {
		return fnum;
	}
	public int getviewNum() {
		return viewNum;
	}
}
