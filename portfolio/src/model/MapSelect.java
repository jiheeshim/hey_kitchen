package model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.MyBatisConfig;

public class MapSelect {

	SqlSessionFactory sqlSessionF = MyBatisConfig.getFactory();
	
	public List<MapDTO> getMapList() {
		SqlSession sqlSession = sqlSessionF.openSession();
		List<MapDTO> mapList = sqlSession.selectList("mapSelect");
		sqlSession.close();
		return mapList;
	}
}
