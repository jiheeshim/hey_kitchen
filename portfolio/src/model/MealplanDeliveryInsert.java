package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanDeliveryInsert {
	
	private static MealplanDeliveryInsert mpdInsert = new MealplanDeliveryInsert();
	public static MealplanDeliveryInsert getInstance() {
		return mpdInsert;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	public int mealplanDeliveryInsert(MealplanDeliveryDTO mealplanDelivery) {
		SqlSession sqlSession = sqlSessionF.openSession();
		int result = sqlSession.insert("mealplanDeliveryInsert", mealplanDelivery);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}

}
