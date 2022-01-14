package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class EndDateSelect {

	private static EndDateSelect edSelect = new EndDateSelect();
	public static EndDateSelect getInstance() {
		return edSelect;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// endDateSelect() : 밀키트들 중 가장 최근의 endDate를 select하는 메소드
	public MealkitDTO endDateSelect() {
		SqlSession sqlSession = sqlSessionF.openSession();
		MealkitDTO mealkit = sqlSession.selectOne("endDateSelect");
		sqlSession.close();
		return mealkit;
	}
}
