package qnaCommand;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ActionForward;
import model.QnaDTO;
import qnaService.QnaReplyProService;

public class QnaReplyProCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String page = request.getParameter("page");
		ActionForward forward = null;
		
		// 답글 데이터로 qna 객체 값 설정
		String id = "";
		if(((String)session.getAttribute("auth9999")).equals("admin9999")) { // 관리자의 경우, 목록페이지에서 아이디 대신 이름이 뜨도록 이름을 저장
			id = (String)session.getAttribute("adminName");
		} else {
			id = (String)session.getAttribute("id");
		}
		QnaDTO qna = new QnaDTO();
		qna.setQnaCategory(request.getParameter("qnaCategory"));
		qna.setSecret(request.getParameter("secret"));
		qna.setTitle(request.getParameter("title"));
		qna.setContent(request.getParameter("content"));
		qna.setId(id);
		qna.setQnaPw(request.getParameter("qnaPw"));
		qna.setQnaRef(Integer.parseInt(request.getParameter("qnaRef")));
		qna.setQnaLev(Integer.parseInt(request.getParameter("qnaLev")));
		qna.setQnaSeq(Integer.parseInt(request.getParameter("qnaSeq")));
		qna.setRegDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
		
		QnaReplyProService qnaReplyProService = new QnaReplyProService();
		boolean isReplySuccess = qnaReplyProService.replyQna(qna);
		
		if(isReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("qnaList.qna?page" + page);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류가 발생하였습니다. 홈페이지로 돌아갑니다.'); location.href='index.jsp';</script>");
		}
		
		return forward;
	}

}
