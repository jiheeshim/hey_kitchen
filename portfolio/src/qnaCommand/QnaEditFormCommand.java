package qnaCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.QnaDTO;
import qnaService.QnaViewService;

public class QnaEditFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		QnaViewService qnaEditFormService = new QnaViewService();
		QnaDTO qna = qnaEditFormService.readQna(qnaNo, true);
		request.setAttribute("qna", qna);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/qnaEdit.jsp");
		
		return forward;
	}

}
