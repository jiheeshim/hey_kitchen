package qnaCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import qnaService.QnaViewPwService;

public class QnaViewPwCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		String qnaPw = request.getParameter("qnaPw");
		
		ActionForward forward = null;
		
		QnaViewPwService qnaViewPwService = new QnaViewPwService();
		boolean isRightPw = qnaViewPwService.isRightPw(qnaNo, qnaPw);
		if(isRightPw) {
			forward = new ActionForward();
			forward.setPath("qnaView.qna?qnaNo=" + qnaNo + "&page=" + page);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('비밀번호가 옳지 않습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}
	
}
