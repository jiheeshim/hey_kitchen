package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MealplanPayService {
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// mealkitNameSelect() : mealkitNo에 따른 mealkitName select
	public List<MealkitDTO> mealkitNameSelect(String[] mealkitNoArr) {
		SqlSession sqlSession = sqlSessionF.openSession();
		List<MealkitDTO> mealkitNameList = sqlSession.selectList("mealkitNameSelect", mealkitNoArr);
		sqlSession.close();
		return mealkitNameList;
	}
	
	// priceSelect() : servingCnt에 따른 subPrice select
	public int priceSelect(MealplanPriceDTO mealplanPrice) {
		SqlSession sqlSession = sqlSessionF.openSession();
		MealplanPriceDTO price = sqlSession.selectOne("priceSelect", mealplanPrice);
		sqlSession.close();
		return price.getPrice();
	}
	
	// usersSelect() : id에 해당하는 유저 정보 select
	public UsersDTO usersSelect(UsersDTO users) {
		SqlSession sqlSession = sqlSessionF.openSession();
		UsersDTO user = sqlSession.selectOne("usersSelect", users);
		sqlSession.close();
		return user;
	}
}
