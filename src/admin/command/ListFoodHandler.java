package admin.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dao.AdminDao;
import admin.service.FoodPage;
import admin.service.ListFoodViewService;
import mvc.command.CommandHandler;

public class ListFoodHandler implements CommandHandler  {

	private ListFoodViewService listFoodViewService = new ListFoodViewService();

	 @Override
	   public String process(HttpServletRequest req, HttpServletResponse res) 
	         throws Exception {
	      String pageNoVal = req.getParameter("pageNo");
	      
	      FoodPage foodPage = listFoodViewService.getFoodPage();
	      req.setAttribute("foodPage", foodPage);
	      return "/WEB-INF/view/14.jsp";
	}
}

