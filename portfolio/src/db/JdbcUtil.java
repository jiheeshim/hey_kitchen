package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// DB 연결, 트랜잭션 관련 메소드들 선언한 클래스
public class JdbcUtil {
	
	// context.xml에서 데이터 소스를 찾아와서 DB 연결
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQLD");
			con = ds.getConnection();
			con.setAutoCommit(false);
		} catch(Exception e) {
			System.out.println("DB Connection error");
			System.out.println(e);
		}
		
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch(Exception e) {
			System.out.println("commit error");
			System.out.println(e);
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();
			System.out.println("rollback");
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
