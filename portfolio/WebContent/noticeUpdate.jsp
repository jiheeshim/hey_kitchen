<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.time.LocalDate" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="notice" class="model.NoticeDTO" />
<%
String adminName = (String)session.getAttribute("adminName");
if(adminName == null) {
	out.println("<script>alert('권한이 없습니다.'); location.href='noticeListSelect.jsp';</script>");
}

String folder = "/noticeUpload";
int fileSize = 10 * 1024 * 1024;
String realFolder = getServletContext().getRealPath(folder);
MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());

// 사용자가 입력한 parameter 값들 불러오기
int noticeNo = Integer.parseInt(multi.getParameter("noticeNo"));
String title = multi.getParameter("title"); 
String category = multi.getParameter("category");
String content = multi.getParameter("content");
String fileName = multi.getParameter("fileName");
String imgName = multi.getParameter("imageName");
String impo = multi.getParameter("impo");
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