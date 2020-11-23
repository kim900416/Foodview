package admin.model;

public class UserVariable {
	private String gradeValue;
	private String blackListValue;
	private String userId;

	public UserVariable(String userId) {
		this.userId = userId;
	}

	public UserVariable(String gradeValue, String blackListValue, String userId) {
		this.gradeValue = gradeValue;
		this.blackListValue = blackListValue;
		this.userId = userId;
	}

	public String getGradeValue() {
		return gradeValue;
	}

	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}

	public String getBlackListValue() {
		return blackListValue;
	}

	public void setBlackListValue(String blackListValue) {
		this.blackListValue = blackListValue;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
