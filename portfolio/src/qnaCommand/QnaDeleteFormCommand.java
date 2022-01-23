package qnaCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;

public class QnaDeleteFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		request.setAttribute("page", page);
		request.setAttribute("qnaNo", qnaNo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/qnaDelete.jsp");
		
		return forward;
	}

}
