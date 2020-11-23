package review.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.FoodGradeService;
import auth.service.User;
import mvc.command.CommandHandler;
import review.model.Writer;
import review.service.ReviewGradeService;
import review.service.WriteRequest;
import review.service.WriteReviewService;

public class WriteReviewHandler implements CommandHandler {
   private static final String FORM_VIEW = "/WEB-INF/view/06.jsp";
   private WriteReviewService writeService = new WriteReviewService();
   private ReviewGradeService gradeService = new ReviewGradeService();
   private FoodGradeService foodService = new FoodGradeService();
   
   @Override
   public String process(HttpServletRequest req, HttpServletResponse res) {
	   String fnum = req.getParameter("fnum");	    
	 // if(fnum!="") { return "/WEB-INF/view/SS.jsp";}
      if (req.getMethod().equalsIgnoreCase("GET")) {
         return processForm(req, res);
      } else if (req.getMethod().equalsIgnoreCase("POST")) {
         return processSubmit(req, res);
      } else {
         res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
         return null;
      }
   }

   private String processForm(HttpServletRequest req, HttpServletResponse res) {
      return FORM_VIEW;
   }
   
   private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);      
      User user = (User)req.getSession(false).getAttribute("authUser");
      WriteRequest writeReq = createWriteRequest(user, req);
      writeReq.validate(errors);
      
      if (!errors.isEmpty()) {
         return FORM_VIEW;
      }
      
      int newReviewNo = writeService.write(writeReq); 
      String grade = gradeService.bringGrade(writeReq);
      foodService.foodChangGrade(grade, req.getParameter("fnum"));
     // 평점 넣어주는 위치
      req.setAttribute("newReviewNo", newReviewNo);
      req.setAttribute("grade", grade);
      
      return "/WEB-INF/view/07.jsp";
   }

   private WriteRequest createWriteRequest(User user, HttpServletRequest req) {
      return new WriteRequest(
            new Writer(user.getId(), user.getName()),  
            	req.getParameter("title"),
            	req.getParameter("content"),            	
            	req.getParameter("grade"),
      			req.getParameter("fnum"));
   }
}