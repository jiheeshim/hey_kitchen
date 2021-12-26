<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>

<%
// 1) 입력한 id와 pw의 value 가져오기
String id = request.getParameter("id");
String pw = request.getParameter("pw");

// 2) DB 연결 -> id에 맞는 pw 찾기
Connection conn = null;
Statement stmt = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "9999");
	if(conn == null)
		throw new Exception("데이터베이스에 연결할 수 없습니다");
	stmt = conn.createStatement();
	String command = "select pw from users where id = '" + id + "';";
	ResultSet rs = stmt.executeQuery(command);
	if(rs.next()) { // 3) 결과가 있는 경우, input의 pw 값과 비교
		if(pw.equals(rs.getString("pw"))) {
			// 3-1) id & pw 일치하면, 세션에 아이디 저장 후, 인덱스 페이지로 이동
			session.setAttribute("id", id);
			response.sendRedirect("index.jsp");
		} else {
			// 3-2) id & pw 일치하지 않으면,
			out.println("<script>alert('아이디 또는 비밀번호가 옳지 않습니다.')");
			out.println("location.href='login.jsp'</script>");
		}
	} else { // 4) 결과가 없는 경우, 
		out.println("<script>alert('아이디 또는 비밀번호가 옳지 않습니다.')");
		out.println("location.href='login.jsp'</script>");
	}
} finally {
	try { stmt.close(); }
	catch(Exception ignored) {}
	try { conn.close(); }
	catch(Exception ignored) {}
}
%>