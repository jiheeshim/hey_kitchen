<%@ page language="java" contentType="text/html; utf-8" pageEncoding="utf-8" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원가입 정보 확인</title>
</head>
<body>
	<% request.setCharacterEncoding("utf-8"); %>
	<%
	  String id = request.getParameter("id");
	  String pw = request.getParameter("pw");
	  String name = request.getParameter("name");
	  String email = request.getParameter("emailfront") + request.getParameter("emailback");
	  String tel = request.getParameter("tel");
	  String gender = (request.getParameter("gender") == null ? "선택 안함" : request.getParameter("gender"));
	  String birthyear = request.getParameter("birthyear");
	  String birthmonth = request.getParameter("birthmonth");
	  String birthdate = request.getParameter("birthdate");
	  String postcode = request.getParameter("postcode");
	  String address = request.getParameter("addr1") + " " + request.getParameter("extraAddr") + " " + request.getParameter("addr2");
	  String refcode = request.getParameter("refcode");
	  int familynum = Integer.parseInt(request.getParameter("familynum"));
	%>
	<%
	  // 생년월일이 모두 입력되어야 생일 정보가 저장되어 출력되도록
	  String birthday = "";
	  if(birthyear == "" || birthmonth == "" || birthdate == "")
	  	birthday = "선택 안함";
	  else
	  	birthday = birthyear + "-" + birthmonth + "-" + birthdate;
	%>
	<%
	  // 추천인 코드가 맞으면(지금은 데이터가 없으므로 null값이 아니면), 5000원 적립
	  int point = 0;
	  if(refcode != null)
	  	point += 5000;
	%>
	아이디 : <%= id %><br>
	비밀번호 : <%= pw %><br>
	이름 : <%= name %><br>
	이메일 : <%= email %><br>
	휴대번호 : <%= tel %><br>
	성별 : <%= gender %><br>
	생년월일 : <%= birthday %><br>
	우편번호 : <%= postcode %><br>
	주소 : <%= address %><br>
	가구원 수 :
	<%
	  if(familynum == 0)
	  	out.println("선택 안함");
	  else
	  	out.println(familynum + "명");
	%><br>
	적립금 : <%= point %>
</body>
</html>