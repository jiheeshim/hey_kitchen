<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String socialId = request.getParameter("socialId");

if(socialId != null) {
	session.setAttribute("socialId", socialId);
} else {
	System.out.println("login error");
}

// 홈페이지로 이동
response.sendRedirect("index.jsp");
%>