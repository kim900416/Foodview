package admin.model;

import java.util.List;

public class UserContent {

	 private Integer number;
	 private List<User> content;
	 
	 
	 public UserContent(Integer number, List<User> content) {
	      this.number = number;
	      this.content = content;
	   }

	 public Integer getNumber() {
	      return number;
	   }

	 public List<User> getContent() {
	      return content;
	   }

}

