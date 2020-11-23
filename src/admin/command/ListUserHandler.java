package admin.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.ListUserViewService;
import admin.service.UserPage;
import mvc.command.CommandHandler;


public class ListUserHandler implements CommandHandler {

   private ListUserViewService listUserViewService = new ListUserViewService();

   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) 
         throws Exception {
      String pageNoVal = req.getParameter("pageNo");
      int pageNo = 1;
      if (pageNoVal != null) {
         pageNo = Integer.parseInt(pageNoVal);
      }
      UserPage UserPage = listUserViewService.getUserPage(pageNo);
      req.setAttribute("UserPage", UserPage);
      return "/WEB-INF/view/12.jsp";
   }

}