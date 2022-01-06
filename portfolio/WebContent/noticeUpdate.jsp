<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="notice" class="model.NoticeDTO" />
<%
// 사용자가 입력한 parameter 값들 불러오기
int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
String title = request.getParameter("title"); 
String category = request.getParameter("category");
String content = request.getParameter("content");
//String fileName = request.getParameter("fileName");
//String imgName = request.getParameter("imgName");
String fileName = "";
String imgName = "";
String adminName = (String)session.getAttribute("adminName");
String impo = request.getParameter("impo");
LocalDate today = LocalDate.now();
String editDate = today.toString();

// notice객체에 각 값 입력
notice.setNoticeNo(noticeNo);
notice.setTitle(title);
notice.setCategory(category);
notice.setContent(content);
notice.setFileName(fileName);
notice.setImgName(imgName);
notice.setAdminName(adminName);
notice.setImpo(impo);
notice.setEditDate(editDate);

// 결과 정상적으로 실행될 시, noticeSelect.jsp -> noticeView.jsp 순서로 이동 
int result = dao.noticeUpdate(notice);
if(result == 1)
	response.sendRedirect("noticeSelect.jsp?noticeNo=" + noticeNo + "&purpose=view");
else
	response.sendRedirect("noticeEdit.jsp");
%>