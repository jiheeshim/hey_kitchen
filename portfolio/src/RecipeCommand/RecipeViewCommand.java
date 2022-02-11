package RecipeCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import RecipeService.RecipeViewService;
import model.ActionForward;
import model.RecipeDTO;
import model.RecipeImgDTO;
import model.RecipeReviewDTO;
import model.RecipeScrapDTO;

public class RecipeViewCommand implements RecipeCommand {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 댓글 창에 뜰 현재 아이디 저장
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		request.setAttribute("id", id);
		
		// url을 통해 받은 recipeNo
		int recipeNo = Integer.parseInt(request.getParameter("recipeNo"));
		
		// recipeNo로 recipe & recipeImg 데이터 불러오기
		RecipeViewService recipeViewService = new RecipeViewService();
		RecipeDTO recipe = recipeViewService.getRecipe(recipeNo);
		ArrayList<RecipeImgDTO> recipeImgList = recipeViewService.getRecipeImgList(recipeNo);
		request.setAttribute("recipe", recipe);
		request.setAttribute("recipeImgList", recipeImgList);
		
		// 재료 데이터 콤마(,) 중심으로 나눠서 배열로 저장
		String ingredients = recipe.getIngredients();
		String[] ingredientsArr = ingredients.split(", ");
		request.setAttribute("ingredientsArr", ingredientsArr);
		
		// review 불러와서 저장
		ArrayList<RecipeReviewDTO> reviewList = recipeViewService.getReviewList(recipeNo);
		request.setAttribute("reviewList", reviewList);
		
		// 스크랩 유무 확인
		boolean isScrapped = false;
		if(id != null) { // 로그인 상태면
			// scrap 객체 설정
			RecipeScrapDTO scrap = new RecipeScrapDTO();
			scrap.setId(id);
			scrap.setRecipeNo(recipeNo);
			
			// 스크랩되어 있는지 확인
			isScrapped = recipeViewService.isScrapped(scrap);
		}
		request.setAttribute("isScrapped", isScrapped);
		
		// ActionForward 경로 설정
		ActionForward forward = new ActionForward();
		forward.setPath("/recipeView.jsp");
		
		return forward;
	}

}
