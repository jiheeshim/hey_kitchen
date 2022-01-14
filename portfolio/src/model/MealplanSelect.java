package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanSelect {
	
	private static MealplanSelect mpSelect = new MealplanSelect();
	public static MealplanSelect getInstance() {
		return mpSelect;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// mealplanSelect() : 매개변수 객체의 mealplanNo와 일치하는 mealplan 정보 리턴
	public MealplanDTO mealplanSelect(MealplanDTO mealplan) {
		SqlSession sqlSession = sqlSessionF.openSession();
		MealplanDTO mealplanResult = sqlSession.selectOne("mealplanSelect", mealplan);
		sqlSession.close();
		return mealplanResult;
	}
}
