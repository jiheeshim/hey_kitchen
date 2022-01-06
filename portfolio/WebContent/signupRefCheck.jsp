<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>

<%
// 1) 입력한 추천인코드 값 불러오기
String joincode = request.getParameter("joincode");

// 2) select절에서 where절에 해당 코드를 넣었을 때 결과 확인
Connection conn = null;
Statement stmt = null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "9999");
	if(conn == null)
		throw new Exception("데이터베이스에 연결할 수 없습니다");
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from users where refcode = '" + joincode + "';");
	if(rs.next()) // 해당 추천인 코드 데이터가 존재하면 1 반환
		out.println("1");
	else // 해당 데이터가 존재하지 않으면 0 반환
		out.println("0");
} finally {
	try { stmt.close(); }
	catch(Exception ignored) {}
	try { conn.close(); }
	catch(Exception ignored) {}
}
%>