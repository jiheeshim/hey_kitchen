<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="user" class="model.UsersDTO" />
<%
String id = (String)session.getAttribute("id");
user = dao.userSelect(id);

request.setAttribute("user", user);
RequestDispatcher dispatcher = request.getRequestDispatcher("mypageUserInfo.jsp");
dispatcher.forward(request, response);
%>