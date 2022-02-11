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

String category = multi.getParameter("category");
String title = multi.getParameter("title");
String content = multi.getParameter("content");
String fileName = multi.getOriginalFileName("fileName");
String fileServerName = multi.getFilesystemName("fileName");
String imgName = multi.getOriginalFileName("imgName");
String imgServerName = multi.getFilesystemName("imgName");
String impo = multi.getParameter("impo");
LocalDate today = LocalDate.now();
String regDate = today.toString();

notice.setCategory(category);
notice.setTitle(title);
notice.setContent(content);
notice.setFileName(fileName);
notice.setFileServerName(fileServerName);
notice.setImgName(imgName);	
notice.setImgServerName(imgServerName);
notice.setAdminName(adminName);
notice.setImpo(impo);
notice.setRegDate(regDate);

int result = dao.noticeInsert(notice);

if(result == 1)
	response.sendRedirect("noticeListSelect.jsp");
else
	response.sendRedirect("noticeWrite.jsp");

%>    