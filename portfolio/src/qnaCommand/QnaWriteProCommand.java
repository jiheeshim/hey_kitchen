package qnaCommand;

import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.ActionForward;
import model.QnaDTO;
import qnaService.QnaWriteProService;

public class QnaWriteProCommand implements Command {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		ActionForward forward = null;
		QnaDTO qna = new QnaDTO();
		
		String realFolder = ""; // 첨부파일 저장할 폴더의 실제 경로
		String folder = "/qnaUpload"; // 첨부파일 폴더 이름
		int fileSize = 10 * 1024 * 1024; // 최대 10MB
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(folder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
		// input 값으로 qna 객체 값 설정
		qna.setQnaCategory(multi.getParameter("qnaCategory"));
		qna.setSecret(multi.getParameter("secret"));
		qna.setTitle(multi.getParameter("title"));
		qna.setContent(multi.getParameter("content"));
		qna.setQnaFile(multi.getOriginalFileName((String)multi.getFileNames().nextElement())); // 파일 올릴 때의 기존 이름으로 저장(서버에서는 다른 파일명일 수 있음)
		qna.setId((String)session.getAttribute("id"));
		qna.setQnaPw(multi.getParameter("qnaPw"));
		qna.setRegDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")));
		
		// (Service -> DAO) insert 실행
		QnaWriteProService qnaWriteProService = new QnaWriteProService();
		boolean isWriteSuccess = qnaWriteProService.writeQna(qna);
		
		if(isWriteSuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("qnaList.qna");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류가 발생하였습니다. 홈페이지로 돌아갑니다.'); location.href='index.jsp';</script>");
		}
		
		return forward;
	}

}
