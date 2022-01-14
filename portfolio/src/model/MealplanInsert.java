package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanInsert {
	
	private static MealplanInsert mpInsert = new MealplanInsert();
	public static MealplanInsert getInstance() {
		return mpInsert;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	public int mealplanInsert(MealplanDTO mealplan) {
		SqlSession sqlSession = sqlSessionF.openSession();
		int result = sqlSession.insert("mealplanInsert", mealplan);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
