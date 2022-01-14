package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanMenuInsert {
	
	private static MealplanMenuInsert mpmInsert = new MealplanMenuInsert();
	public static MealplanMenuInsert getInstance() {
		return mpmInsert;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// mealplanDetailInsert() : 매개변수 객체의 값을 mealplanDetail 테이블에 insert
	public int mealplanMenuInsert(MealplanMenuDTO mealplanMenu) {
		SqlSession sqlSession = sqlSessionF.openSession();
		int result = sqlSession.insert("mealplanMenuInsert", mealplanMenu);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
