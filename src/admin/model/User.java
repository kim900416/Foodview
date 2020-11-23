package admin.model;


public class User {
	
	private String name;
	private String id;	
	private String email;
	private String grade;
	private String sex;
	private String phoneNum;
	private String blackList;	
	
	public User() {
		super();
	}
	public User(String name, String id, String phoneNum, String email, 
			String sex, String grade ) {
		
		this.name = name;
		this.id = id;
		this.phoneNum = phoneNum;
		this.email = email;
		this.grade = grade;
		this.sex = sex;
	}	

	//public User(String id,)
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public String getSex() {
		return sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public String getBlackList() {
		return blackList;
	}
	public String getAAA() {
		return "AAA";
	}
	public UserVariable getUserVariable() {
		String id = getId();
		String black = getBlackList();
		String grade = getGrade();
		UserVariable userVa = new UserVariable(grade, black, id);
		return userVa;
	} 
	
	public void changeGrade(String newGrade) {
		this.grade = newGrade;
	}
}
