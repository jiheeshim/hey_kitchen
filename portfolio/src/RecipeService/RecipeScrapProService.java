package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.RecipeScrapDTO;

public class RecipeScrapProService {
	
	public boolean scrapRecipe(RecipeScrapDTO scrap) {
	// scrapInsert(recipeScrap 테이블) + scrapUpdate(recipe 테이블)
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		boolean scrapResult = false; // DB 처리 결과용 변수
		
		int insertCount = recipeDAO.scrapInsert(scrap); // 스크랩
		int updateCount = recipeDAO.plusScrapCount(scrap.getRecipeNo()); // 스크랩수 +1
		
		if(insertCount > 0 && updateCount > 0) { // db처리 성공 시,
			commit(con);
			scrapResult = true;
		} else { // db처리 오류 시,
			rollback(con);
		}
		
		close(con);
		
		return scrapResult;
	}

}
