package qnaCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.QnaDTO;
import qnaService.QnaViewService;

public class QnaReplyFormCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String page = request.getParameter("page");
		
		QnaViewService qnaViewService = new QnaViewService();
		QnaDTO qna = qnaViewService.readQna(qnaNo, true);
		request.setAttribute("qna", qna);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/qnaReply.jsp");
		
		return forward;
	}

}
