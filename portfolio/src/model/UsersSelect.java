package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class UsersSelect {
	
	private static UsersSelect uSelect = new UsersSelect();
	public static UsersSelect getInstance() {
		return uSelect;
	}
	
	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	// usersSelect() : 매개변수 객체의 id를 가진 user 객체를 select해서 리턴
	public UsersDTO usersSelect(UsersDTO user) {
		SqlSession sqlSession = sqlSessionF.openSession();
		UsersDTO userResult = sqlSession.selectOne("usersSelect", user);
		sqlSession.close();
		return userResult;
	}
}
