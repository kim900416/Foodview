package admin.service;

import java.util.List;

import admin.model.FoodIntroContent;

public class FoodPage {

	private List<FoodIntroContent> content;
	
	public FoodPage(List<FoodIntroContent> content) {
		this.content = content;
	}

	public List<FoodIntroContent> getContent(){
		return content;
	}
}
