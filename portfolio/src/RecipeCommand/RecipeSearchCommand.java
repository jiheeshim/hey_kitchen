package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import RecipeService.RecipeSearchService;
import model.ActionForward;
import model.PageInfoDTO;
import model.RecipeDTO;

public class RecipeSearchCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		String searchTxt = request.getParameter("searchTxt");
		request.setAttribute("searchTxt", searchTxt);
		
		int page = 1; // 현재 페이지
		int limit = 12; // 한 페이지 당 최대 12개씩 출력
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		RecipeSearchService recipeSearchService = new RecipeSearchService();
		int listCount = recipeSearchService.getSearchCount(searchTxt);
		ArrayList<RecipeDTO> recipeList = recipeSearchService.searchRecipeList(searchTxt, page, limit);
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
		
		forward = new ActionForward();
		forward.setPath("/recipeListSearch.jsp");
		
		return forward;
	}

}
