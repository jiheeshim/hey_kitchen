package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.RecipeDAO;
import model.RecipeDTO;
import model.RecipeImgDTO;
import model.RecipeReviewDTO;
import model.RecipeScrapDTO;

public class RecipeViewService {
	
	public RecipeDTO getRecipe(int recipeNo) {
		// 레시피 테이블 정보 불러오기
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		RecipeDTO recipe = recipeDAO.recipeSelect(recipeNo);
		int updateCount = recipeDAO.updateReadCount(recipeNo); // 조회수 + 1
		
		if(updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return recipe;
		
	}
	
	public ArrayList<RecipeImgDTO> getRecipeImgList(int recipeNo) {
		// 레시피 요리 단계 정보 불러오기
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<RecipeImgDTO> recipeImgList = recipeDAO.recipeImgSelect(recipeNo);
		
		close(con);
		
		return recipeImgList;
	}
	
	public ArrayList<RecipeReviewDTO> getReviewList(int recipeNo) {
		// 레시피 후기 정보 불러오기
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		ArrayList<RecipeReviewDTO> reviewList = recipeDAO.reviewSelect(recipeNo);
		
		close(con);
		
		return reviewList;
	}
	
	public boolean isScrapped(RecipeScrapDTO scrap) {
		// 현재 아이디로 레시피 스크랩되어 있는지 확인
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		boolean isScrapped = recipeDAO.scrapSelect(scrap);
		
		close(con);
		
		return isScrapped;
	}

}
