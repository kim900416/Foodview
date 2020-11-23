package member.model;

import java.util.Date;

public class Member {

	private String id;
	private String name;
	private String password;
	private String sex;
	private String email;
	private String email_key;
	private String phonNum;
	private String active_state;
	private String uni;
	private String f_num;
	private Date regDate;
	private String grade;

	
	public Member(
			String id, String name, String password, String sex, String email,
			String phonNum, Date regDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phonNum = phonNum;
		this.regDate = regDate;
		this.grade = "0";
	}
	
	public Member(
			String id, String name, String password, String sex, String email,
			String phonNum, String grade, Date regDate) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.email = email;
		this.phonNum = phonNum;		
		this.grade = grade;
		this.regDate = regDate;	
	}

	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getSex() {
		return sex;
	}
	public String getEmail() {
		return email;
	}
	public String getPhonNum() {
		return phonNum;
	}	
	public String getGrade() {
		return grade;
	}	
	public Date getRegDate() {
		return regDate;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

	public void changePassword(String newPwd) {
		this.password = newPwd;
	}
	public void changeEmail(String newEmail) {
		this.email = newEmail;
	}

}
