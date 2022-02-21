package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RecipeService.RecipeListService;
import model.ActionForward;
import model.PageInfoDTO;
import model.RecipeDTO;

public class RecipeListCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 클릭한 카테고리 구별자
		String group = request.getParameter("group"); // 큰 분류
		String categ = request.getParameter("categ"); // 작은 분류
		
		String[] category = new String[2]; // 실제 카테고리 이름(0 : 큰 분류, 1: 작은 분류)
		
//		switch(group) { // 큰 분류 이름
//		case "time":
//			category[0] = "삼시네끼";
//			break;
//		case "dish":
//			category[0] = "디쉬";
//			break;
//		case "country":
//			category[0] = "전세계";
//			break;
//		case "main":
//			category[0] = "메인 재료";
//			break;
//		case "special":
//			category[0] = "특별한 날";
//			break;
//		case "baking":
//			category[0] = "베이킹";
//			break;
//		case "drink":
//			category[0] = "음료";
//			break;
//		}
		category[0] = group;
		category[1] = categ;
	
		request.setAttribute("category", category);
		
		int page = 1; // 현재 페이지
		int limit = 12; // 한 페이지 당 최대 12개씩 출력
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		RecipeListService recipeListService = new RecipeListService();
		int listCount = recipeListService.getListCount(category[1]); // 카테고리에 맞는 레시피 게시물 개수
		ArrayList<RecipeDTO> recipeList = recipeListService.getRecipeList(category[1], page, limit); // 카테고리에 맞는 레시피들
		request.setAttribute("recipeList", recipeList);
		
		// 페이징
		int maxPage = (int)((double)listCount/limit + 0.95); // 총 페이지수
		int startPage = (((int)((double)page/10 + 0.9)) - 1) * 10 + 1; // 페이지 목록의 시작
		int endPage = startPage + 10 - 1; // 페이지 목록의 마지막
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfoDTO pageInfo = new PageInfoDTO();
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		request.setAttribute("pageInfo", pageInfo);
		
		// 이동 경로 설정
		ActionForward forward = new ActionForward();
		forward.setPath("/recipeList.jsp");
		
		return forward;
	}

}
