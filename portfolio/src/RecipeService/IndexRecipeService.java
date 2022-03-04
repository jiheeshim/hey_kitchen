package RecipeService;

import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import dao.IndexDAO;
import model.RecipeDTO;
import model.UsersDTO;
import myBatis.MyBatisConfig;

// 가구원수, 조회수, 후기수에 따른 레시피 불러오기
public class IndexRecipeService {
	
	public RecipeDTO getFamilyRecipe(Map<String, String> map) throws Exception {
		
		SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
		IndexDAO indexDAO = IndexDAO.getInstance();
		indexDAO.setSqlSessionF(sqlSessionF);
		
		RecipeDTO familyRecipe = indexDAO.categoryRecipeSelect(map);
		
		return familyRecipe;
	}
	
	public RecipeDTO getReadCountRecipe(int startNum) throws Exception {
		
		SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
		IndexDAO indexDAO = IndexDAO.getInstance();
		indexDAO.setSqlSessionF(sqlSessionF);
		
		RecipeDTO readCountRecipe = indexDAO.readCountRecipeSelect(startNum); // 조회수 기준
		
		return readCountRecipe;
	}
	
	public RecipeDTO getReviewCountRecipe(int startNum) throws Exception {
		
		SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
		IndexDAO indexDAO = IndexDAO.getInstance();
		indexDAO.setSqlSessionF(sqlSessionF);
		
		RecipeDTO reviewCountRecipe = indexDAO.reviewCountRecipeSelect(startNum); // 조회수 기준
		
		return reviewCountRecipe;
	}
	
	public UsersDTO getUserInfo(String id) throws Exception {
		
		SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
		IndexDAO indexDAO = IndexDAO.getInstance();
		indexDAO.setSqlSessionF(sqlSessionF);
		
		UsersDTO users = new UsersDTO();
		users.setId(id);
		UsersDTO user = indexDAO.usersSelect(users);
		
		return user;
		
	}
	

}
