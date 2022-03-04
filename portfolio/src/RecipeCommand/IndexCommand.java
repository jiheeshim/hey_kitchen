package RecipeCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.IndexNoticeService;
import RecipeService.IndexRecipeService;
import model.ActionForward;
import model.NoticeDTO;
import model.RecipeDTO;
import model.UsersDTO;

public class IndexCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		IndexRecipeService indexRecipeService = new IndexRecipeService();
		
		// 가구원 수 가져오기
		int familyNum = 0; // 가구원 수 기본값
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		if(id != null) { // 로그인된 아이디가 있으면, 유저 정보 가져오기
			if(!id.equals("admin")) {
				UsersDTO user = indexRecipeService.getUserInfo(id);
				familyNum = user.getFamilynum(); // 가구원 수 저장
			}
		}
		
		// 가구원 수 기준 카테고리 설정
		String category = "";
		switch(familyNum) {
		case 3: case 4:
			category = "반찬";
			break;
		case 5: case 6:
			category = "단체";
			break;
		default:
			category = "메인";
		}
		
		// 가구원 수 기준 레시피 가져오기
		Map<String, String> map = new HashMap<String, String>();
		map.put("category", category);
		RecipeDTO familyRecipe = indexRecipeService.getFamilyRecipe(map);
		
		// 조회수 기준 레시피 가져오기
		RecipeDTO readCountRecipe = indexRecipeService.getReadCountRecipe(0); // 0 : 제일 높은 게시물
				
		// 후기수 기준 레시피 가져오기
		RecipeDTO reviewCountRecipe = indexRecipeService.getReviewCountRecipe(0);
		
		if(familyRecipe != null & readCountRecipe != null & reviewCountRecipe != null) {
			int fNo = familyRecipe.getRecipeNo(); // 가구원 수 기준 레시피 번호
			int rNo = readCountRecipe.getRecipeNo(); // 조회수 기준 레시피 번호
			int revNo = reviewCountRecipe.getRecipeNo(); // 후기수 기준 레시피 번호
			int rStartNum = 1;
			int revStartNum = 1;
			// 하나라도 겹치는 경우, 그 다음으로 높은 게시물 불러오기
			while(fNo == rNo || fNo == revNo || rNo == revNo) { 
				if(fNo == rNo) {
					readCountRecipe = indexRecipeService.getReadCountRecipe(rStartNum);
					rStartNum++;
				} else if(fNo == revNo) {
					reviewCountRecipe = indexRecipeService.getReviewCountRecipe(revStartNum);
					revStartNum++;
				} else {
					readCountRecipe = indexRecipeService.getReadCountRecipe(rStartNum);
					rStartNum++;
				}
				rNo = readCountRecipe.getRecipeNo();
				revNo = reviewCountRecipe.getRecipeNo();
			}
		}
		
		// 레시피 저장
		request.setAttribute("familyRecipe", familyRecipe);
		request.setAttribute("readCountRecipe", readCountRecipe);
		request.setAttribute("reviewCountRecipe", reviewCountRecipe);
		
		// 공지사항, 게시판 글 불러오기
		IndexNoticeService indexNoticeService = new IndexNoticeService();
		List<NoticeDTO> noticeList = indexNoticeService.getIndexNotice();
		request.setAttribute("noticeList", noticeList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/index2.jsp");
		
		return forward;
	}

}
