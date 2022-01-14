package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealkitSelect {
	// 싱글톤 패턴 객체 생성
	private static MealkitSelect mkSelect = new MealkitSelect();
	public static MealkitSelect getInstance() {
		return mkSelect;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// mealkitSelect() : mealkit의 startDate와 endDate에 매개변수 객체의 deliverDate가 포함되어 있는 mealkit 데이터들을 select
	public List<MealkitDTO> mealkitSelect(MealplanDeliveryDTO mealplanDelivery) {
		SqlSession sqlSession = sqlSessionF.openSession();
		List<MealkitDTO> mealkitList = sqlSession.selectList("mealkitSelect", mealplanDelivery);
		sqlSession.close();
		return mealkitList;
	}
}
