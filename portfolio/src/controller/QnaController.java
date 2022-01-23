package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ActionForward;
import qnaCommand.Command;
import qnaCommand.QnaDeleteFormCommand;
import qnaCommand.QnaDeleteProCommand;
import qnaCommand.QnaEditFormCommand;
import qnaCommand.QnaEditProCommand;
import qnaCommand.QnaFileDeleteCommand;
import qnaCommand.QnaFileDownCommand;
import qnaCommand.QnaListCommand;
import qnaCommand.QnaReplyFormCommand;
import qnaCommand.QnaReplyProCommand;
import qnaCommand.QnaSearchCommand;
import qnaCommand.QnaViewCommand;
import qnaCommand.QnaViewPwCommand;
import qnaCommand.QnaWriteProCommand;

@WebServlet("*.qna")
public class QnaController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI(); // '/portfolio/qnaList.qna'
		String contextPath = request.getContextPath();
		String where = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		Command command = null; // 어떤 기능을 실행할지 선언될 인터페이스
		
		if(where.equals("/qnaList.qna")) { // qna 데이터들을 selectList를 해서 목록 페이지로 이동
			command = new QnaListCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaWriteForm.qna")) { // qnaWrite 페이지로 이동
			forward = new ActionForward();
			forward.setPath("qnaWrite.jsp");
		} else if(where.equals("/qnaWritePro.qna")) { // qna insert + 목록으로 이동
			command = new QnaWriteProCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaViewPw.qna")) { // 비밀번호 확인 + qnaView.qna로 이동
			command = new QnaViewPwCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaView.qna")) { // qna select + 조회수 update + qnaView 페이지로 이동
			command = new QnaViewCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaFileDown.qna")) {
			command = new QnaFileDownCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaEditForm.qna")) { // qna select + qnaEdit 페이지로 이동
			command = new QnaEditFormCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaEditPro.qna")) { // 비밀번호 확인 + qna update + view페이지로 이동
			command = new QnaEditProCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaReplyForm.qna")) { // qna 게시물 정보 가지고 qnaReply 페이지로 이동
			command = new QnaReplyFormCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaReplyPro.qna")) { // 답변 qna 게시물 정보 insert + 목록으로 이동
			command = new QnaReplyProCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaDeleteForm.qna")) { // page, qnaNo 정보 가지고 delete 페이지로 이동
			command = new QnaDeleteFormCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaDeletePro.qna")) { // delete + 목록 페이지로 이동
			command = new QnaDeleteProCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/qnaSearch.qna")) { // 검색 input에 맞게 select + 목록 페이지로 이동
			command = new QnaSearchCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// forward 객체 값 설정에 따라 경로 이동
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}  	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doProcess(request,response);
	}
	
}
