package admin.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.UserVariable;
import admin.service.ChangeUserGradeService;
import admin.service.WriteFoodIntroService;
import mvc.command.CommandHandler;

public class exHandler implements CommandHandler {
	private ChangeUserGradeService changeService = new ChangeUserGradeService(); 
	ArrayList<UserVariable> list = new ArrayList<UserVariable>();
	private static final String FORM_VIEW = "/WEB-INF/view/12.jsp";
	private WriteFoodIntroService userId = new WriteFoodIntroService();

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
		String[] a = req.getParameterValues("userId");
		String[] b = req.getParameterValues("changeGrade");
		String[] c = req.getParameterValues("blackList");
		for (int i = 0; i < a.length; i++) {
			insertIntro(a[i],b[i],c[i]);
		}
		changeService.changeUserG(list);
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}
		return "/WEB-INF/view/SS.jsp";
	}
	
	private void insertIntro(String id, String grade, String black){
		UserVariable user = new UserVariable(grade,black,id);
		list.add(user);
	}
}