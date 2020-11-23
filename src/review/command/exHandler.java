package review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import review.service.ListReviewService;
import review.service.ReviewGradeService;
import review.service.ReviewPage;

public class exHandler implements CommandHandler{
	   
	   @Override
	   public String process(HttpServletRequest req, HttpServletResponse res) 
	         throws Exception {		     
	    	  return "/WEB-INF/view/EX01.jsp";
      }
   }
