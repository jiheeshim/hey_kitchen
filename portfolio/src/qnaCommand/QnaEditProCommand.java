package qnaCommand;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import model.QnaDTO;
import qnaService.QnaEditProService;

public class QnaEditProCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		QnaDTO qna = null;
		boolean isEditSuccess = false;
		QnaEditProService qnaEditProService = new QnaEditProService();
		
		String page = request.getParameter("page");
		int qnaNo = Integer.parseInt(request.getParameter("qnaNo"));
		
		// 비밀번호 맞는지 확인
		boolean isRightPw = qnaEditProService.isRightPw(qnaNo, request.getParameter("qnaPw"));
		
		if(isRightPw) { // 비밀번호 맞으면 qna 객체 값 설정 + update
			
			qna = new QnaDTO();
			qna.setQnaNo(qnaNo);
			qna.setQnaCategory(request.getParameter("qnaCategory"));
			qna.setSecret(request.getParameter("secret"));
			qna.setTitle(request.getParameter("title"));
			qna.setContent(request.getParameter("content"));
			qna.setEditDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
			
			isEditSuccess = qnaEditProService.editQna(qna);
			if(isEditSuccess) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("qnaView.qna?qnaNo=" + qnaNo + "&page=" + page);
			}
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('비밀번호가 옳지 않습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
