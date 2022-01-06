<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="notice" class="model.NoticeDTO" />
<%
String category = request.getParameter("category");
String title = request.getParameter("title");
String content = request.getParameter("content");
//String fileName = request.getParameter("fileName"); // 아직 어떤 식으로 해야 할지 모르겠어서 일단은 빈칸 처
//String imgName = request.getParameter("imgName");
String fileName = "";
String imgName = "";
String adminName = (String)session.getAttribute("adminName");
String impo = request.getParameter("impo");
LocalDate today = LocalDate.now();
String regDate = today.toString();

notice.setCategory(category);
notice.setTitle(title);
notice.setContent(content);
notice.setFileName(fileName);
notice.setImgName(imgName);
notice.setAdminName(adminName);
notice.setImpo(impo);
notice.setRegDate(regDate);

int result = dao.noticeInsert(notice);

if(result == 1)
	response.sendRedirect("noticeListSelect.jsp");
else
	response.sendRedirect("noticeWrite.jsp");
%>    