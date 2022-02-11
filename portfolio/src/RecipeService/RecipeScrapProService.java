package RecipeService;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.RecipeDAO;
import model.RecipeScrapDTO;

public class RecipeScrapProService {
	
	public int scrapRecipe(RecipeScrapDTO scrap) {
	// scrapSelect(추가 검사) + scrapInsert(recipeScrap 테이블) + scrapUpdate(recipe 테이블)
		
		int scrapResult = 0; // 최종적으로 스크랩 완료되었는지
		// 성공 : 1, 이미 스크랩 겹치는 경우 : 2, db처리 오류 : 0
		
		Connection con = getConnection();
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.setConnection(con);
		
		// 이미 스크랩한 적 있는지 추가 검사
		boolean isScrapped = recipeDAO.scrapSelect(scrap);
		
		if(!isScrapped) { // 스크랩 한 적 없으면
			int insertCount = recipeDAO.scrapInsert(scrap); // recipeScrap insert
			int updateCount = recipeDAO.plusScrapCount(scrap.getRecipeNo()); // 스크랩 수 + 1
			
			if(insertCount > 0 && updateCount > 0) { // db처리 성공 시,
				commit(con);
				scrapResult = 1;
			} else { // db처리 오류 시,
				rollback(con);
			}
		} else {
			scrapResult = 2;
		}
		
		close(con);
		
		return scrapResult;
	}

}
