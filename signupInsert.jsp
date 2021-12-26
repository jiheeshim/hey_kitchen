<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<%@ page import="java.sql.*" %>

<%
// 1) 회원가입 페이지로부터 DB에 넣을 input 값들 설정
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");
String email = request.getParameter("emailfront") + request.getParameter("emailback");
String tel = request.getParameter("tel");
String gender = request.getParameter("gender").equals("N") ? null : "'" + request.getParameter("gender") + "'";
String birthyear = request.getParameter("birthyear");
String birthmonth = request.getParameter("birthmonth");
String birthdate = request.getParameter("birthdate");
String postcode = request.getParameter("postcode") == ""? null : "'" + request.getParameter("postcode") + "'";
String addr1 = request.getParameter("postcode") == ""? null : "'" + request.getParameter("postcode") + "'";
String extraAddr = request.getParameter("postcode") == ""? null : "'" + request.getParameter("postcode") + "'";
String addr2 = request.getParameter("postcode") == ""? null : "'" + request.getParameter("postcode") + "'";
String joincode = request.getParameter("joincode");
int familynum = Integer.parseInt(request.getParameter("familynum"));
String marketing = request.getParameter("marketing") == null? null : "'" + request.getParameter("marketing") + "'";

// 생년월일이 모두 입력되어야 생일 정보가 저장되어 출력되도록
String birthday = null;
if(birthyear != "" && birthmonth != "0" && birthdate != "0")
	birthday = "'" + birthyear + "-" + birthmonth + "-" + birthdate + "'";

// 추천인 코드가 맞으면(js를 통해 코드 확인하므로, 빈칸만 아니면 됨), 5000원 적립
int point = 0;
if(joincode != "")
	point += 5000;

// 아이디 + 숫자 4개의 랜덤 문자열 생성
// (굳이 추천인의 아이디 숨길 필요 없으므로, 추천인코드 중복을 막기 위해 아이디 사용 + 인터넷에서 아이디만 보고 코드로 사용하는 것 막기 위해 뒤에 난수 4자리 붙여주기)
String refcode = id;
for(int i = 0; i < 4; i++)
	refcode += (int)(Math.random() * 10); // 0 ~ 9 : 한자리수
%>

<%
// 2) DB에 연결
Connection conn = null;
Statement stmt = null;
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "9999");
	if(conn == null)
		throw new Exception("데이터베이스에 연결할 수 없습니다");
	stmt = conn.createStatement();
	String command = String.format("insert into users values ('%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, %s, '%s', %d, %d, %s);", id, pw, name, email, tel, gender, birthday, postcode, addr1, extraAddr, addr2, refcode, familynum, point, marketing);
	int rowNum = stmt.executeUpdate(command);
	if(rowNum < 1)
		throw new Exception("데이터를 DB에 입력할 수 없습니다");
} finally {
	try { stmt.close(); }
	catch(Exception ignored) {}
	try { conn.close(); }
	catch(Exception ignored) {}
}

// 3) 회원가입 완료 페이지로 이동
response.sendRedirect("signupSuccess.jsp");
%>
