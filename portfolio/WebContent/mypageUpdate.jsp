<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="user" class="model.UsersDTO" />
<%
// 로그인 없이 링크로 들어오는 경우 방지
if(session.getAttribute("id") == null) {
	response.sendRedirect("login.jsp");
} else {

	// 사용자가 입력한 parameter 값들 불러오기
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String tel = request.getParameter("tel");
	String birthyear = request.getParameter("birthyear");
	String birthmonth = request.getParameter("birthmonth");
	String birthdate = request.getParameter("birthdate");
	String birthday = null;
	if(birthyear != "" && birthmonth != "0" && birthdate != "0")
		birthday = "'" + birthyear + "-" + birthmonth + "-" + birthdate + "'";
	int familynum = Integer.parseInt(request.getParameter("familynum"));
	String marketing = request.getParameter("marketing").equals("null") ? null : "'on'";
	
	// usersDTO 객체에 값 입력
	user.setId(id);
	user.setName(name);
	user.setEmail(email);
	user.setTel(tel);
	user.setBirthday(birthday);
	user.setFamilynum(familynum);
	user.setMarketing(marketing);
	
	// 결과 정상적으로 실행될 시, alert 후 회원정보 관리 페이지
	int result = dao.userUpdate(user);
	if(result == 1)
		out.println("<script>alert('수정되었습니다.'); location.href='mypageSelect.jsp';</script>");
	else
		out.println("<script>location.href='mypageSelect.jsp';</script>");
}
%>