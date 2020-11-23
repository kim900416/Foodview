package review.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.border.EmptyBorder;

import review.service.ReviewPage;
import review.service.ListReviewService;
import mvc.command.CommandHandler;

public class ListReviewHandler implements CommandHandler {

   private ListReviewService listService = new ListReviewService();

   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) 
         throws Exception {
      String pageNoVal = req.getParameter("pageNo");
      String fnum = req.getParameter("fnum");      
      int pageNo = 1;
      if (pageNoVal != null) {
         pageNo = Integer.parseInt(pageNoVal);
      }
      if(fnum != null) {
    	  ReviewPage ReviewPage = listService.getReviewPage(pageNo,fnum);
          req.setAttribute("ReviewPage", ReviewPage);          
          return "/WEB-INF/view/08.jsp";
      }
      else {
    	  ReviewPage ReviewPage = listService.getReviewPage(pageNo);    	 
    	  req.setAttribute("ReviewPage", ReviewPage);
    	  return "/WEB-INF/view/08.jsp";
      }
   }
}