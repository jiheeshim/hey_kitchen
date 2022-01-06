<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<%
// purpose1) 로그인에서 넘어온 경우 purpose = login
// purpose2) 마이페이지 회원정보관리에서 비밀번호 재확인의 경우 purpose = pwCheck
String purpose = request.getParameter("purpose");

String id = "";
if(purpose.equals("login"))
	id = request.getParameter("id");
else if(purpose.equals("pwCheck"))
	id = (String)session.getAttribute("id");
String pw = request.getParameter("pw");

int result = dao.loginSelect(id, pw);
if(result == 1) {
	if(purpose.equals("login")) {
		session.setAttribute("id", id);
		response.sendRedirect("index.jsp");
	}
	else if(purpose.equals("pwCheck"))
		response.sendRedirect("mypageSelect.jsp");
} else {
	out.println("<script>alert('아이디 또는 비밀번호가 옳지 않습니다.'); history.go(-1);</script>");
}
%>
