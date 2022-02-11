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

// 첨부파일, 이미지파일 수정이 있었는지 없었는지에 대한 값
String fileEdit = "false"; // 첨부파일 수정 여부
if(multi.getParameter("fileEdit") != null) {
	fileEdit = 	multi.getParameter("fileEdit");
}
String imgEdit = "false"; // 이미지파일 수정 여부
if(multi.getParameter("imgEdit") != null) {
	imgEdit = 	multi.getParameter("imgEdit");
}
int editVersion = 0;

// 사용자가 입력한 parameter 값들 불러오기
int noticeNo = Integer.parseInt(multi.getParameter("noticeNo"));
String title = multi.getParameter("title"); 
String category = multi.getParameter("category");
String content = multi.getParameter("content");
String fileName = multi.getOriginalFileName("fileName");
String fileServerName = multi.getFilesystemName("fileName");
String imgName = multi.getOriginalFileName("imgName");
String imgServerName = multi.getFilesystemName("imgName");
String impo = multi.getParameter("impo");
LocalDate today = LocalDate.now();
String editDate = today.toString();

// notice객체에 각 값 입력
notice.setNoticeNo(noticeNo);
notice.setTitle(title);
notice.setCategory(category);
notice.setContent(content);
notice.setFileName(fileName);
notice.setFileServerName(fileServerName);
notice.setImgName(imgName);
notice.setImgServerName(imgServerName);
notice.setAdminName(adminName);
notice.setImpo(impo);
notice.setEditDate(editDate);

// 결과 정상적으로 실행될 시, noticeSelect.jsp -> noticeView.jsp 순서로 이동
if(fileEdit.equals("true") && imgEdit.equals("true")) { // 둘다 수정하는 경우
	editVersion = 3;
} else {
	if(fileEdit.equals("true")) { // 첨부파일만 수정하는 경우
		editVersion = 1;
	} else if(imgEdit.equals("true")) { // 이미지파일만 수정하는 경우
		editVersion = 2;
	} // 파일 수정 안 하는 경우 초기값 0
}
int result = dao.noticeUpdate(notice, editVersion);


if(result == 1)
	response.sendRedirect("noticeSelect.jsp?noticeNo=" + noticeNo + "&purpose=view");
else
	response.sendRedirect("noticeEdit.jsp");
%>