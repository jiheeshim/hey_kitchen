<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
// session.invalidate(); -> 이렇게 하면 모든 세션 정보가 날라가므로,
session.removeAttribute("id");

session.removeAttribute("adminName");
session.removeAttribute("auth9999");
response.sendRedirect("login.jsp");
%>