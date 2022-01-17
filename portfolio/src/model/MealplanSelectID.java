package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanSelectID {
	
	private static MealplanSelectID mpSelectID = new MealplanSelectID();
	public static MealplanSelectID getInstance() {
		return mpSelectID;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	public MealplanDTO mealplanSelectID(MealplanDTO mealplan) {
		SqlSession sqlSession = sqlSessionF.openSession();
		MealplanDTO mealplanResult = sqlSession.selectOne("mealplanSelectID", mealplan);
		sqlSession.close();
		return mealplanResult;
	}

}
