package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanDeliverySelect {

	private static MealplanDeliverySelect mpdSelect = new MealplanDeliverySelect();
	public static MealplanDeliverySelect getInstance() {
		return mpdSelect;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// mealplanDeliverySelect() : mealplanDelivery 데이터 select
	public MealplanDeliveryDTO mealplanDeliverySelect(MealplanDeliveryDTO mealplanDelivery) {
		SqlSession sqlSession = sqlSessionF.openSession();
		MealplanDeliveryDTO mealplanDeliveryResult = sqlSession.selectOne("mealplanDeliverySelect", mealplanDelivery);
		sqlSession.close();
		return mealplanDeliveryResult;
	}
	
}
