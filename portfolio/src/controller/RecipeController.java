package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeCommand.IngrScrapDeleteCommand;
import RecipeCommand.IngrScrapProCommand;
import RecipeCommand.IngrScrapSaveCommand;
import RecipeCommand.IngrScrapViewCommand;
import RecipeCommand.MyReviewViewCommand;
import RecipeCommand.RecipeCommand;
import RecipeCommand.RecipeListCommand;
import RecipeCommand.RecipeMyFeedViewCommand;
import RecipeCommand.RecipeRegisterProCommand;
import RecipeCommand.RecipeScrapDeleteCommand;
import RecipeCommand.RecipeScrapProCommand;
import RecipeCommand.RecipeScrapViewCommand;
import RecipeCommand.RecipeViewCommand;
import RecipeCommand.ReviewDeleteCommand;
import RecipeCommand.ReviewReplyProCommand;
import model.ActionForward;

@WebServlet("*.rec")
public class RecipeController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String where = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		RecipeCommand command = null;
		HttpSession session = request.getSession();
		
		// 로그인이 필요한 페이지들
		if(session.getAttribute("id") != null) {
			if(where.equals("/recipeRegisterForm.rec")) {
			// recipe 등록하기 페이지로 이동
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("recipeRegister.jsp");
			} else if(where.equals("/recipeRegisterPro.rec")) {
			// recipe & recipeImg 테이블에 insert하여 레시피 등록
				command = new RecipeRegisterProCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/recipeMyFeedView.rec")) {
			// 내가 쓴 레시피 피드 페이지
				command = new RecipeMyFeedViewCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/reviewReplyPro.rec")) {
			// 레시피 후기 달기 + 레시피 뷰페이지로 이동
				command = new ReviewReplyProCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/reviewDelete.rec")) {
			// 레시피 후기 삭제 + 레시피 뷰페이지로 이동
				command = new ReviewDeleteCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/reviewEdit.rec")) {
				
			} else if(where.equals("/recipeScrapPro.rec")) {
			// 레시피 스크랩 + 레시피 뷰페이지로 이동
				command = new RecipeScrapProCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/recipeScrapDelete.rec")) {
			// 레시피 스크랩 취소 + 레시피 뷰페이지로 이동
				command = new RecipeScrapDeleteCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/recipeScrapView.rec")) {
			// 레시피 스크랩 select + 레시피 스크랩 갤러리로 이동
				command = new RecipeScrapViewCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/ingrScrapPro.rec")) {
			// 나의 장보기 목록에 재료 담기(추가) - ajax 통해서 왔다 가므로 forward = null
				command = new IngrScrapProCommand(); // ajax용 커맨드
				try {
					command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/ingrScrapView.rec")) {
			// 나의 장보기 목록 select + 페이지로 이동
				command = new IngrScrapViewCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/ingrScrapDelete.rec")) {
			// 나의 장보기 목록 delete + insert로 이동
				command = new IngrScrapDeleteCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/ingrScrapSave.rec")) {
			// 나의 장보기 목록 insert + view로 이동
				command = new IngrScrapSaveCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			} else if(where.equals("/myReviewView.rec")) {
			// 내가 쓴 리뷰 select + 페이지로 이동
				command = new MyReviewViewCommand();
				try {
					forward = command.execute(request, response);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login.jsp");
		}
		
		// 로그인 필요 없는 페이지들
		if(where.equals("/recipeView.rec")) { // recipeNo parameter값 필수
		// 레시피 개별 뷰페이지로 이동
			command = new RecipeViewCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(where.equals("/recipeList.rec")) {
			command = new RecipeListCommand();
			try {
				forward = command.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
