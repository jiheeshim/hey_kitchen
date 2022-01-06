<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<%
int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
int result = dao.noticeDelete(noticeNo);

if(result == 1)
	out.println("<script>alert('삭제되었습니다.'); location.href='noticeListSelect.jsp';</script>");
else
	out.println("<script>alert('오류가 발생하였습니다.'); location.href='noticeListSelect.jsp';</script>");
%>