package qnaCommand;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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

		// multi 객체 먼저 생성(+첨부파일 저장)
		int fileSize = 10 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		String realFolder = context.getRealPath("/qnaUpload");
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
		String page = multi.getParameter("page");
		int qnaNo = Integer.parseInt(multi.getParameter("qnaNo"));
		
		// 비밀번호 맞는지 확인
		boolean isRightPw = qnaEditProService.isRightPw(qnaNo, multi.getParameter("qnaPw"));
		
		if(isRightPw) { // 비밀번호 맞으면 qna 객체 값 설정 + update
			
			qna = new QnaDTO();
			qna.setQnaNo(qnaNo);
			qna.setQnaCategory(multi.getParameter("qnaCategory"));
			qna.setSecret(multi.getParameter("secret"));
			qna.setTitle(multi.getParameter("title"));
			qna.setContent(multi.getParameter("content"));
			qna.setQnaFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
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
