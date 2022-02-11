package RecipeCommand;

import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import RecipeService.ReviewReplyProService;
import model.ActionForward;
import model.RecipeReviewDTO;

public class ReviewReplyProCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		HttpSession session = request.getSession();
		
		// 첨부 사진 저장
		String realFolder = request.getServletContext().getRealPath("/recipeUpload");
		int fileSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
		// input 값으로 review 객체 값 설정
		int recipeNo = Integer.parseInt(multi.getParameter("recipeNo"));
		RecipeReviewDTO review = new RecipeReviewDTO();
		review.setReviewNo(0);
		review.setRecipeNo(recipeNo);
		review.setContent(multi.getParameter("content"));
		review.setImgName(multi.getOriginalFileName("imgName"));
		review.setImgServerName(multi.getFilesystemName("imgName"));
		review.setId((String)session.getAttribute("id"));
		review.setRegDate(LocalDate.now().toString());		
		
		// insert 시행
		ReviewReplyProService reviewReplyProService = new ReviewReplyProService();
		boolean replySuccess = reviewReplyProService.replyReview(review);
		
		if(replySuccess) { // insert 성공하면, view 페이지로 이동
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("recipeView.rec?recipeNo=" + recipeNo);
		} else { // insert 실패하면, alert
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('답글 달기 중 오류가 발생했습니다.'); history.go(-1);</script>");
		}
		
		return forward;
	}

}
