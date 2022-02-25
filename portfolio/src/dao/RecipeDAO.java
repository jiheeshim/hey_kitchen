package dao;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.IngrScrapDTO;
import model.MyReviewDTO;
import model.RecipeDTO;
import model.RecipeImgDTO;
import model.RecipeReviewDTO;
import model.RecipeScrapDTO;

public class RecipeDAO {
	
	DataSource ds = null;
	Connection con = null;
	
	private static RecipeDAO recipeDAO;
	public static RecipeDAO getInstance() {
		if(recipeDAO == null) {
			recipeDAO = new RecipeDAO();
		}
		return recipeDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	
	// recipeInsert(recipe) : recipe insert
	public int recipeInsert(RecipeDTO recipe) {
		
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "insert into recipe (recipeNo, recipeName, thumbnail, thumbnailServer, category, readCount, scrapCount, recipeDesc, ingredients, id, regDate)"
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipe.getRecipeNo());
			pstmt.setString(2, recipe.getRecipeName());
			pstmt.setString(3, recipe.getThumbnail());
			pstmt.setString(4, recipe.getThumbnailServer());
			pstmt.setString(5, recipe.getCategory());
			pstmt.setInt(6, recipe.getReadCount());
			pstmt.setInt(7, recipe.getScrapCount());
			pstmt.setString(8, recipe.getRecipeDesc());
			pstmt.setString(9, recipe.getIngredients());
			pstmt.setString(10, recipe.getId());
			pstmt.setString(11, recipe.getRegDate());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// recipeImgInsert(recipeImg) : recipe img insert
	public int recipeImgInsert(RecipeImgDTO recipeImg) {
		
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "insert into recipeImg (imgNo, recipeNo, imgName, imgServerName, imgDesc) values (?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeImg.getImgNo());
			pstmt.setInt(2, recipeImg.getRecipeNo());
			pstmt.setString(3, recipeImg.getImgName());
			pstmt.setString(4, recipeImg.getImgServerName());
			pstmt.setString(5, recipeImg.getImgDesc());
			
			insertCount = pstmt.executeUpdate();	
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// reviewInsert(recipeReview) : 레시피 후기 insert
	public int reviewInsert(RecipeReviewDTO review) {
		
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "insert into recipeReview (reviewNo, recipeNo, content, imgName, imgServerName, id, regDate) values (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, review.getReviewNo());
			pstmt.setInt(2, review.getRecipeNo());
			pstmt.setString(3, review.getContent());
			pstmt.setString(4, review.getImgName());
			pstmt.setString(5, review.getImgServerName());
			pstmt.setString(6, review.getId());
			pstmt.setString(7, review.getRegDate());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// scrapInsert(scrap) : 레시피 스크랩 insert
	public int scrapInsert(RecipeScrapDTO scrap) {
		
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "insert into recipeScrap (id, recipeNo) values (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getRecipeNo());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// ingrScrapInsert(ingrScrap) : 재료 스크랩 insert
	public int ingrScrapInsert(IngrScrapDTO ingrScrap) {
		
		PreparedStatement pstmt = null;
		int insertCount = 0;
		
		try {
			String sql = "insert into ingrScrap (ingrNo, ingr, checked, id) values (0, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ingrScrap.getIngr());
			pstmt.setString(2, ingrScrap.getChecked());
			pstmt.setString(3, ingrScrap.getId());
			
			insertCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return insertCount;
	}
	
	// maxNoSelect() : 현재 가장 큰 recipeNo를 select하여 recipeNo 값 설정할 +1하여 사용할 메소드
	public int maxNoSelect() {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int maxNo = 0;
		
		try {
			String sql = "select max(recipeNo) from recipe";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				maxNo = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return maxNo;
	}
	
	// myFeedSelect(id) : 해당 아이디가 작성자인 레시피 게시글 select
	public ArrayList<RecipeDTO> myFeedSelect(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		
		try {
			String sql = "select * from recipe where id = ? order by regDate desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeDTO recipe = new RecipeDTO();
				recipe.setRecipeNo(rs.getInt("recipeNo"));
				recipe.setRecipeName(rs.getString("recipeName"));
				recipe.setThumbnailServer(rs.getString("thumbnailServer"));
				recipe.setRegDate(rs.getString("regDate"));
				recipe.setReadCount(rs.getInt("readCount"));
				recipeList.add(recipe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recipeList;
	}
	
	// recipeSelect(recipeNo) : 해당 번호의 recipe select
	public RecipeDTO recipeSelect(int recipeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecipeDTO recipe = null;
		
		try {
			String sql = "select * from recipe where recipeNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				recipe = new RecipeDTO();
				recipe.setRecipeNo(recipeNo);
				recipe.setRecipeName(rs.getString("recipeName"));
				recipe.setCategory(rs.getString("category"));
				recipe.setReadCount(rs.getInt("readCount"));
				recipe.setScrapCount(rs.getInt("scrapCount"));
				recipe.setRecipeDesc(rs.getString("recipeDesc"));
				recipe.setThumbnail(rs.getString("thumbnail"));
				recipe.setThumbnailServer(rs.getString("thumbnailServer"));
				recipe.setId(rs.getString("id"));
				recipe.setIngredients(rs.getString("ingredients"));
				recipe.setRegDate(rs.getString("regDate"));
				recipe.setEditDate(rs.getString("editDate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recipe;
	}
	
	// recipeImgSelect(recipeNo) : 해당 번호의 recipeImg select
	public ArrayList<RecipeImgDTO> recipeImgSelect(int recipeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecipeImgDTO> recipeImgList = new ArrayList<RecipeImgDTO>();
		
		try {
			String sql = "select * from recipeImg where recipeNo = ? order by imgNo asc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeImgDTO recipeImg = new RecipeImgDTO();
				recipeImg.setImgNo(rs.getInt("imgNo"));
				recipeImg.setRecipeNo(recipeNo);
				recipeImg.setImgName(rs.getString("imgName"));
				recipeImg.setImgServerName(rs.getString("imgServerName"));
				recipeImg.setImgDesc(rs.getString("imgDesc"));
				recipeImgList.add(recipeImg);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recipeImgList;
	}
	
	// reviewSelect(recipeNo) : 해당 번호의 recipeReview select
	public ArrayList<RecipeReviewDTO> reviewSelect(int recipeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecipeReviewDTO> reviewList = new ArrayList<RecipeReviewDTO>();
		
		try {
			String sql = "select * from recipeReview where recipeNo = ? order by regDate desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeReviewDTO review = new RecipeReviewDTO();
				review.setReviewNo(rs.getInt("reviewNo"));
				review.setRecipeNo(recipeNo);
				review.setContent(rs.getString("content"));
				review.setId(rs.getString("id"));
				review.setImgName(rs.getString("imgName"));
				review.setImgServerName(rs.getString("imgServerName"));
				review.setRegDate(rs.getString("regDate"));
				review.setEditDate(rs.getString("editDate"));
				reviewList.add(review);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return reviewList;
	}
	
	// myReviewSelect(id) : 해당 아이디의 recipeReview select & 각 review별 recipeTitle select
	public ArrayList<MyReviewDTO> myReviewSelect(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MyReviewDTO> myReviewList = new ArrayList<MyReviewDTO>();
		
		try {
			String sql = "select recipe.recipeNo, recipeName, recipeReview.content, recipeReview.id, recipeReview.regDate, recipeReview.editDate from recipeReview"
					+ " join recipe on recipeReview.recipeNo = recipe.recipeNo where recipeReview.id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MyReviewDTO myReview = new MyReviewDTO();
				myReview.setRecipeNo(rs.getInt("recipeNo"));
				myReview.setRecipeName(rs.getString("recipeName"));
				myReview.setContent(rs.getString("content"));
				myReview.setId(rs.getString("id"));
				myReview.setRegDate(rs.getString("regDate"));
				myReview.setEditDate(rs.getString("editDate"));
				myReviewList.add(myReview);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return myReviewList;
		
	}
	
	// scrapSelect(scrap) : scrap의 id와 recipeNo가 동시에 겹치는 게 있는지 select -> boolean 리턴
	public boolean scrapSelect(RecipeScrapDTO scrap) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isScrapped = false;
		
		try {
			String sql = "select * from recipeScrap where id = ? and recipeNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getRecipeNo());
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				isScrapped = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return isScrapped;
	}
	
	// scrapRecipeSelect(id) : id로 스크랩한 레시피를 select
	public ArrayList<RecipeDTO> scrapRecipeSelect(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		
		try {
			String sql = "select * from recipe where recipeNo in (select recipeNo from recipeScrap where id = ?) order by regDate desc";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RecipeDTO recipe = new RecipeDTO();
				recipe.setRecipeNo(rs.getInt("recipeNo"));
				recipe.setRecipeName(rs.getString("recipeName"));
				recipe.setThumbnailServer(rs.getString("thumbnailServer"));
				recipe.setRegDate(rs.getString("regDate"));
				recipe.setReadCount(rs.getInt("readCount"));
				recipeList.add(recipe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recipeList;
	}
	
	// ingrScrapSelect(id) : 해당 id의 ingrScrap select
	public ArrayList<IngrScrapDTO> ingrScrapSelect(String id) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<IngrScrapDTO> ingrScrapList = new ArrayList<IngrScrapDTO>();
		
		try {
			String sql = "select * from ingrScrap where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				IngrScrapDTO ingrScrap = new IngrScrapDTO();
				ingrScrap.setIngrNo(rs.getInt("ingrNo"));
				ingrScrap.setIngr(rs.getString("ingr"));
				ingrScrap.setChecked(rs.getString("checked"));
				ingrScrap.setId(rs.getString("id"));
				ingrScrapList.add(ingrScrap);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return ingrScrapList;
	}
	
	// listCountSelect(category) : 해당 카테고리에 맞는 레시피 글 개수 select
	public int listCountSelect(String category) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		
		try {
			String sql = "select count(*) from recipe where category like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + category + "%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	// recipeListSelect(category) : 해당 카테고리에 맞는 레시피들 select
	public ArrayList<RecipeDTO> recipeListSelect(String category, int page, int limit) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		int startrow = (page - 1) * 12;
		
		try {
			String sql = "select * from recipe where category like ? order by regDate desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + category + "%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RecipeDTO recipe = new RecipeDTO();
				recipe.setRecipeNo(rs.getInt("recipeNo"));
				recipe.setRecipeName(rs.getString("recipeName"));
				recipe.setThumbnailServer(rs.getString("thumbnailServer"));
				recipe.setId(rs.getString("id"));
				recipe.setRegDate(rs.getString("regDate"));
				recipe.setReadCount(rs.getInt("readCount"));
				recipeList.add(recipe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recipeList;
	}
	
	// searchCountSelect(searchTxt) : 검색어를 가진 레시피 글 개수 select
	public int searchCountSelect(String searchTxt) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		
		try {
			String sql = "select count(*) from recipe where recipeName like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchTxt + "%");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	// searchRecipeList(searchTxt) : 이름에 searchTxt가 들어간 레시피들 select
	public ArrayList<RecipeDTO> searchRecipeList(String searchTxt, int page, int limit) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
		int startrow = (page - 1) * 12;
		
		try {
			String sql = "select * from recipe where recipeName like ? order by regDate desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + searchTxt + "%");
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, limit);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RecipeDTO recipe = new RecipeDTO();
				recipe.setRecipeNo(rs.getInt("recipeNo"));
				recipe.setRecipeName(rs.getString("recipeName"));
				recipe.setThumbnailServer(rs.getString("thumbnailServer"));
				recipe.setId(rs.getString("id"));
				recipe.setRegDate(rs.getString("regDate"));
				recipe.setReadCount(rs.getInt("readCount"));
				recipeList.add(recipe);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recipeList;
	}
	
	// updateReadCount(recipeNo) : 해당 번호에 맞는 레시피 게시글 조회수 + 1
	public int updateReadCount(int recipeNo) {
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update recipe set readCount = readCount + 1 where recipeNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeNo);
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// updateReview(reviewNo) : 해당 번호에 맞는 레시피 후기 update 수정
	public int updateReview(RecipeReviewDTO review) {
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update recipeReview set content = ?, imgName = ?, imgServerName = ?, editDate = ? where reviewNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, review.getContent());
			pstmt.setString(2, review.getImgName());
			pstmt.setString(3, review.getImgServerName());
			pstmt.setString(4, review.getEditDate());
			pstmt.setInt(5, review.getReviewNo());
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
		
	}
	
	// plusScrapCount(recipeNo) : 해당 번호에 맞는 레시피 스크랩 수 + 1
	public int plusScrapCount(int recipeNo) {
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update recipe set scrapCount = scrapCount + 1 where recipeNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeNo);
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
		
	}
	
	// minusScrapCount(recipeNo) : 해당 번호에 맞는 레시피 스크랩 수 - 1
	public int minusScrapCount(int recipeNo) {
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update recipe set scrapCount = scrapCount - 1 where recipeNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeNo);
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
		
	}
	
	// plusPoint(String id, int point) : 해당 아이디 적립금 적립
	public int plusPoint(String id, int point) {
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update users set point = point + ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// minusPoint(String id, int point) : 해당 아이디 적립금 철회
	public int minusPoint(String id, int point) {
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		
		try {
			String sql = "update users set point = point - ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, point);
			pstmt.setString(2, id);
			
			updateCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return updateCount;
	}
	
	// deleteReview(reviewNo) : 해당 번호에 맞는 레시피 후기 delete
	public int deleteReview(int reviewNo) {
		
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		
		try {
			String sql = "delete from recipeReview where reviewNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reviewNo);
		
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
		
	}
	
	// deleteScrap(scrap) : recipeNo, id 일치하는 정보 delete
	public int deleteScrap(RecipeScrapDTO scrap) {
		
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		
		try {
			String sql = "delete from recipeScrap where id = ? and recipeNo = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, scrap.getId());
			pstmt.setInt(2, scrap.getRecipeNo());
		
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
	}
	
	// deleteIngrScrap(id) : 해당 id의 ingrScrap 정보 delete
	public int deleteIngrScrap(String id) {
		
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		
		try {
			String sql = "delete from ingrScrap where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
		
			deleteCount = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return deleteCount;
		
	}

}
