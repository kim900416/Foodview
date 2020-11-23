package review.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.service.ReviewContentNotFoundException;
import review.service.ReviewData;
import review.service.ReviewNotFoundException;
import review.service.ReadReviewService;
import mvc.command.CommandHandler;

public class ReadReviewHandler implements CommandHandler {

   private ReadReviewService readService = new ReadReviewService();

   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) 
         throws Exception {
      String noVal = req.getParameter("no");
      int ReviewNum = Integer.parseInt(noVal);
      try {
         ReviewData ReviewData = readService.getReview(ReviewNum, true);         
         req.setAttribute("ReviewData", ReviewData);
         return "/WEB-INF/view/09.jsp";
      } catch (ReviewNotFoundException | ReviewContentNotFoundException e) {
         req.getServletContext().log("no Review", e);
         res.sendError(HttpServletResponse.SC_NOT_FOUND);
         return null;
      }
   }

}