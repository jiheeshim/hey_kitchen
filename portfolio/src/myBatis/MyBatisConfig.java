package myBatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConfig {
	
	// 싱글톤 패턴에 맞게 객체 생성
	private static SqlSessionFactory sqlSessionF;
	public static SqlSessionFactory getFactory() {
		return sqlSessionF;
	}
	
	// static initialization block : 메인 메소드 시작 전에 SqlSessionFactory build
	static {
		try {
			String resource = "myBatis/config.xml"; // configuration XML파일
			Reader reader = Resources.getResourceAsReader(resource); // 파일 읽어오기
			SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
			sqlSessionF = factoryBuilder.build(reader); // 읽어온 config.xml로 SqlSessionFactory build
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
