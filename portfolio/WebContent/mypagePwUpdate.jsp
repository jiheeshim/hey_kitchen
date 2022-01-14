<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="user" class="model.UsersDTO" />
<%
// dao.pwUpdate() 실행
String id = (String)session.getAttribute("id");
String pw = request.getParameter("pw");

user.setId(id);
user.setPw(pw);

int result = dao.pwUpdate(user);

if(result == 1)
	out.println("<script>alert('비밀번호가 변경되었습니다.');location.href='mypagePwChange.jsp'</script>");
else
	out.println("<script>alert('비밀번호 변경에 실패하였습니다.');location.href='mypagePwChange.jsp'</script>");
%>