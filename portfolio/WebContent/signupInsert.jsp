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
String addr1 = request.getParameter("addr1") == ""? null : "'" + request.getParameter("addr1") + "'";
String extraAddr = request.getParameter("extraAddr") == ""? null : "'" + request.getParameter("extraAddr") + "'";
String addr2 = request.getParameter("addr2") == ""? null : "'" + request.getParameter("addr2") + "'";
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

// 서버 단에서도 유효성 검사 제어를 해서 데이터를 받아줘야함
// 왜? javascript는 보안에 취약하고, 클라이언트 서버 측에서 조작이 가능하므로, 서버에서도 무조건 제어가 필요함
boolean success = false; // 백단에서 유효성 검사할 때 쓰일 결과 변수
String errorMsg = null; // 에러 페이지가 뜨게 되는 경우, 어떤 에러 메시지를 담을지

// 2) DB에 연결
Connection conn = null;
Statement stmt = null;
try {
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "root", "9999");
	if(conn == null) {
		throw new Exception("데이터베이스에 연결할 수 없습니다");
	}
	stmt = conn.createStatement();
	String command = String.format("insert into users values ('%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, %s, '%s', %d, %d, %s);", id, pw, name, email, tel, gender, birthday, postcode, addr1, extraAddr, addr2, refcode, familynum, point, marketing);
	int rowNum = stmt.executeUpdate(command);
	if(rowNum < 1)
		throw new Exception("데이터를 DB에 입력할 수 없습니다"); // 이런 예외를 띄울 게 아니라, 뭐가 잘못 됐는지 알면 어떻게 처리할 건지를 적어줘야 함
	
	success = true;
	
} catch(Exception e) {
	//  why
	
} finally {
	try { stmt.close(); }
	catch(Exception ignored) {}
	try { conn.close(); }
	catch(Exception ignored) {}
}

if (success) {
	
} else {
	
}

// 3) 회원가입 완료 페이지로 이동
response.sendRedirect("signupSuccess.jsp");
%>
