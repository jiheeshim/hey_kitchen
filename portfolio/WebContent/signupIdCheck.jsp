<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>

<%
// 1) 입력한 아이디 값 불러오기
String id = request.getParameter("id");

// 2) select절에서 where절에 해당 아이디를 넣었을 때 결과 확인
Connection conn = null;
Statement stmt = null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "9999");
	if(conn == null)
		throw new Exception("데이터베이스에 연결할 수 없습니다.<br>");
	stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery("select * from users where id = '" + id + "';");
	if(rs.next()){ // 3) 해당 아이디로 결과가 나오는 경우(즉, 중복되는 아이디가 존재하는 경우)
		out.println("0");
	} else { // 4) 해당 아이디가 중복되지 않는 경우
		out.println("1");
	}
} finally { // 5) DB연결 끊기
	try { stmt.close(); }
	catch(Exception ignored) {}
	try { conn.close(); }
	catch(Exception ignored) {}
}
%>