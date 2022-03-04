package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.NoticeDTO;
import model.RecipeDTO;
import model.UsersDTO;

public class IndexDAO {
	
	private SqlSessionFactory sqlSessionF = null;
	
	private static IndexDAO indexDAO;
	public static IndexDAO getInstance() {
		if(indexDAO == null) {
			indexDAO = new IndexDAO();
		}
		return indexDAO;
	}
	
	public void setSqlSessionF(SqlSessionFactory sqlSessionF) {
		this.sqlSessionF = sqlSessionF;
	}
		
	// usersSelect(id) : id에 해당하는 유저 정보 select
	public UsersDTO usersSelect(UsersDTO users) {
		SqlSession sqlSession = sqlSessionF.openSession();
		UsersDTO user = sqlSession.selectOne("usersSelect", users);
		sqlSession.close();
		return user;
	}
	
	// categoryRecipeSelect() : 카테고리에 따른 최신 레시피 select
	public RecipeDTO categoryRecipeSelect(Map<String, String> map) throws Exception {
		SqlSession sqlSession = sqlSessionF.openSession();
		RecipeDTO categoryRecipe = sqlSession.selectOne("categoryRecipeSelect", map);
		sqlSession.close();
		return categoryRecipe;
	}
	
	// readCountRecipeSelect() : 조회수가 가장 높은 레시피 select
	public RecipeDTO readCountRecipeSelect(int startNo) throws Exception {
		SqlSession sqlSession = sqlSessionF.openSession();
		RecipeDTO readCountRecipe = sqlSession.selectOne("readCountRecipeSelect", startNo);
		sqlSession.close();
		return readCountRecipe;
	}
	
	// reviewCountRecipeSelect() : 후기수가 가장 많은 레시피 select
	public RecipeDTO reviewCountRecipeSelect(int startNo) throws Exception {
		SqlSession sqlSession = sqlSessionF.openSession();
		RecipeDTO reviewCountRecipe = sqlSession.selectOne("reviewCountRecipeSelect", startNo);
		sqlSession.close();
		return reviewCountRecipe;
	}

	// indexNoticeSelect() : 이벤트/공지사항 게시물 최신 3개 select
	public List<NoticeDTO> indexNoticeSelect() throws Exception {
		SqlSession sqlSession = sqlSessionF.openSession();
		List<NoticeDTO> noticeList = sqlSession.selectList("indexNoticeSelect");
		sqlSession.close();
		return noticeList;
	}
}
