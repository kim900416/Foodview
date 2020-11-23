package admin.model;

public class FoodIntro {
	
	private Integer number;
	private String grade;
	private String name;
	private int reviewNum;
	
	
	public FoodIntro(Integer number, String name ) {		
		this.name = name;
		this.number = number;	
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getNumber() {
		return number;
	}

}
