package qnaCommand;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import qnaService.QnaDeleteProService;

public class QnaDeleteProCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String page = request.getParameter("page");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		ActionForward forward = null;
	
		
		QnaDeleteProService qnaDeleteProService = new QnaDeleteProService();
		boolean isRightPw = qnaDeleteProService.isRightPw(qnaNo, request.getParameter("qnaPw"));
		
		if(isRightPw) {
			boolean isDeleteSuccess = qnaDeleteProService.deleteQna(qnaNo);
			request.setAttribute("page", page);
			
			if(isDeleteSuccess) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("qnaList.qna?page=" + page);
			} else {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out=response.getWriter();
				out.println("<script>alert('오류가 발생하였습니다.'); history.go(-1);</script>");
			}
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('비밀번호가 옳지 않습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
