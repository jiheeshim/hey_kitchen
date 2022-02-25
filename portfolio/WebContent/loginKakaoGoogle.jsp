<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id"); // 카카오 로그인에서 가져오는 파라미터
String access_token = request.getParameter("access_token"); // 구글 로그인에서 가져오는 파라미터

// 헤이키친 용 로그인 세션 정보 입력 부분
if(id != null) {
	session.setAttribute("id", "kakao****");
} else if(access_token != null) {
	session.setAttribute("id", "google****");
} else {
	System.out.println("login error");
}

// 홈페이지로 이동
response.sendRedirect("index.jsp");
%>