package model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class PointUpdate {

	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	public int pointUpdate(UsersDTO user) {
		SqlSession sqlSession = sqlSessionF.openSession();
		int result = sqlSession.update("pointUpdate", user);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
