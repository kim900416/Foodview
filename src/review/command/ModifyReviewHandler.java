package review.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import review.service.ReviewData;
import review.service.ReviewNotFoundException;
import review.service.ModifyReviewService;
import review.service.ModifyRequest;
import review.service.PermissionDeniedException;
import review.service.ReadReviewService;
import auth.service.User;
import mvc.command.CommandHandler;

public class ModifyReviewHandler implements CommandHandler {
   private static final String FORM_VIEW = "/WEB-INF/view/10.jsp";

   private ReadReviewService readService = new ReadReviewService();
   private ModifyReviewService modifyService = new ModifyReviewService();

   @Override
   public String process(HttpServletRequest req, HttpServletResponse res)
         throws Exception {
      if (req.getMethod().equalsIgnoreCase("GET")) {
         return processForm(req, res);
      } else if (req.getMethod().equalsIgnoreCase("POST")) {
         return processSubmit(req, res);
      } else {
         res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
         return null;
      }
   }

   private String processForm(HttpServletRequest req, HttpServletResponse res)
         throws IOException {
      try {
         String noVal = req.getParameter("no");
         int no = Integer.parseInt(noVal);
         ReviewData ReviewData = readService.getReview(no, false);
         User authUser = (User) req.getSession().getAttribute("authUser");
         if (!canModify(authUser, ReviewData)) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null;
         }
         ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
               ReviewData.getReview().getTitle(),
               ReviewData.getContent());

         req.setAttribute("modReq", modReq);
         return FORM_VIEW;
      } catch (ReviewNotFoundException e) {
         res.sendError(HttpServletResponse.SC_NOT_FOUND);
         return null;
      }
   }

   private boolean canModify(User authUser, ReviewData ReviewData) {
      String writerId = ReviewData.getReview().getWriter().getId();
      return authUser.getId().equals(writerId);
   }

   private String processSubmit(HttpServletRequest req, HttpServletResponse res)
         throws Exception {
      User authUser = (User) req.getSession().getAttribute("authUser");
      String noVal = req.getParameter("no");
      int no = Integer.parseInt(noVal);

      ModifyRequest modReq = new ModifyRequest(authUser.getId(), no,
            req.getParameter("title"),
            req.getParameter("content"));
      req.setAttribute("modReq", modReq);

      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
      modReq.validate(errors);
      if (!errors.isEmpty()) {
         return FORM_VIEW;
      }
      try {
         modifyService.modify(modReq);
         return "/WEB-INF/view/11.jsp";
      } catch (ReviewNotFoundException e) {
         res.sendError(HttpServletResponse.SC_NOT_FOUND);
         return null;
      } catch (PermissionDeniedException e) {
         res.sendError(HttpServletResponse.SC_FORBIDDEN);
         return null;
      }
   }
}