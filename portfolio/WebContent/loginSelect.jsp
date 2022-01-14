<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<%
// purpose1) 로그인에서 넘어온 경우 purpose = login
// purpose2) 마이페이지 회원정보관리에서 비밀번호 재확인의 경우 purpose = pwCheck
// purpose3) 마이페이지 비밀번호 변경 시 비밀번호 재확인의 경우 purpose = pwChange
String purpose = request.getParameter("purpose");

String id = "";
if(purpose.equals("login"))
	id = request.getParameter("id");
else if(purpose.equals("pwCheck") || purpose.equals("pwChange"))
	id = (String)session.getAttribute("id");
String pw = request.getParameter("pw");

int result = dao.loginSelect(id, pw);
if(result == 1) {
	if(purpose.equals("login")) { // 로그인의 경우 세션에 아이디 저장 후 이동
		session.setAttribute("id", id);
		response.sendRedirect("index.jsp");
	}
	else if(purpose.equals("pwCheck"))
		response.sendRedirect("mypageSelect.jsp");
	else if(purpose.equals("pwChange"))
		response.sendRedirect("mypagePwUpdate.jsp?pw=" + request.getParameter("newPw"));
} else {
	if(purpose.equals("pwChange"))
		out.println("<script>alert('비밀번호가 옳지 않습니다.'); history.go(-1);</script>");
	else
		out.println("<script>alert('아이디 또는 비밀번호가 옳지 않습니다.'); history.go(-1);</script>");
}
%>
