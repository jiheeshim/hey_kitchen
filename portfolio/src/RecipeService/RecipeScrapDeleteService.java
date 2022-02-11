package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.RecipeScrapDTO;

public class RecipeScrapDeleteService {

	public int unscrapRecipe(RecipeScrapDTO scrap) {
	// scrapDelete + minusScrapCount + scrapSelect
		
		int unscrapResult = 0;
		// db 오류 시 : 0, 성공 시 : 1, 스크랩 취소할 정보가 없어서 실패 시 : 2
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		boolean isScrapped = recipeDAO.scrapSelect(scrap);
		
		if(isScrapped) { // 스크랩되어 있으면
			int deleteCount = recipeDAO.deleteScrap(scrap);
			int updateCount = recipeDAO.minusScrapCount(scrap.getRecipeNo());
			
			if(deleteCount > 0 && updateCount > 0) {
				commit(con);
				unscrapResult = 1;
			} else {
				rollback(con);
			}
		} else {
			unscrapResult = 2;
		}
		
		close(con);
		
		return unscrapResult;
	}
}
