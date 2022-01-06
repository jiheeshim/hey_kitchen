<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="admin" class="model.AdminDTO" />
<%
// input의 내용 불러오기
String adminId = request.getParameter("adminId");
String adminPw = request.getParameter("adminPw");

// loginSelect()를 통해 결과 가져오기
admin = dao.loginSelectAdmin(adminId, adminPw);

if(admin != null) {
	// 정보가 일치하는 경우, 세션 저장 + 인덱스페이지로 이동
	session.setAttribute("id", adminId);
	session.setAttribute("adminName", admin.getAdminName());
	session.setAttribute("auth9999", "admin9999");
	response.sendRedirect("index.jsp");
} else {
	// 정보가 일치하지 않는 경우, alert + 로그인페이지로 이동
	out.println("<script>alert('아이디 또는 비밀번호가 옳지 않습니다.'); location.href='loginAdmin.jsp';</script>");
}

%>