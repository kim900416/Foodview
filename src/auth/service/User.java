package auth.service;

public class User {

	private String id;
	private String name;
	private String grade;


	public User(String id, String name, String grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}

}
