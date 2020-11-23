package admin.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.WriteFoodIntroRequest;
import admin.service.WriteFoodIntroService;
import auth.service.User;
import mvc.command.CommandHandler;

public class WriteFoodIntroHandler implements CommandHandler {
	 
	private static final String FORM_VIEW = "/WEB-INF/view/13.jsp";
	private WriteFoodIntroService writeFoodIntroService = 
			new WriteFoodIntroService();
	   
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
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

	      WriteFoodIntroRequest writeFoodReq = createWriteRequest(req);
	      writeFoodReq.validate(errors);
	      
	      if (!errors.isEmpty()) {
	         return FORM_VIEW;
	      }
	      
	      int newFoodIntroNo = writeFoodIntroService.write(writeFoodReq);
	      req.setAttribute("newFoodIntroNo", newFoodIntroNo);
	      
	      return "/WEB-INF/view/SS.jsp";
	   }

	   private WriteFoodIntroRequest createWriteRequest(HttpServletRequest req) {
	      return new WriteFoodIntroRequest(
	    		  	req.getParameter("f_title"),  
	            	req.getParameter("f_imageAddress"),
	            	req.getParameter("f_content"),
	            	req.getParameter("f_introduce")
	    		  );            	
	            	
	   }
	}