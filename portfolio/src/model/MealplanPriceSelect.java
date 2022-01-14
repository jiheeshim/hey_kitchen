package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanPriceSelect {
	private static MealplanPriceSelect mppSelect = new MealplanPriceSelect();
	public static MealplanPriceSelect getInstance() {
		return mppSelect;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	public List<MealplanPriceDTO> mealplanPriceSelect() {
		SqlSession sqlSession = sqlSessionF.openSession();
		List<MealplanPriceDTO> priceList = sqlSession.selectList("mealplanPriceSelect");
		sqlSession.close();
		return priceList;
	}
}
