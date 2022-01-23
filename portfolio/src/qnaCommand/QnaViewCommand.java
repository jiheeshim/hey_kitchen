package qnaCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.QnaDTO;
import qnaService.QnaViewService;

public class QnaViewCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String page = request.getParameter("page");
		
		ActionForward forward = null;
		QnaViewService qnaViewService = new QnaViewService();
		QnaDTO qna = qnaViewService.readQna(qnaNo, false);
		
		if(qna != null) {
			request.setAttribute("qna", qna);
			request.setAttribute("page", page);
			forward = new ActionForward();
			forward.setPath("/qnaView.jsp");
		}
		
		return forward;
	}
	
}
