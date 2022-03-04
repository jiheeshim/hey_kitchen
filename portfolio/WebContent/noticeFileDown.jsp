<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.File" %>
<%@ page import="java.io.*" %>
<%

out.clear();
String file_name = request.getParameter("file_name"); // 서버 파일 이름
String savePath = "/noticeUpload"; // 서버 폴더 이름
String sFilePath = getServletContext().getRealPath(savePath) + "/" + file_name; // 절대경로 + 파일명

byte b[] = new byte[4096]; 
FileInputStream in = new FileInputStream(sFilePath);

// 파일의 확장자 구분
String sMimeType = getServletContext().getMimeType(sFilePath);
if(sMimeType == null)
	sMimeType = "application/octet-stream"; // 알려지지 않은 확장자일 경우 주로 사용
response.setContentType(sMimeType);

// OS 및 브라우저 확인
String agent = request.getHeader("User-Agent");
boolean ieBrowser = (agent.indexOf("MSIE") > -1) || (agent.indexOf("Trident") > -1);
if (ieBrowser) {
	file_name = URLEncoder.encode(file_name, "UTF-8").replaceAll("\\+", "%20");
} else {
	file_name = new String(file_name.getBytes("UTF-8"), "iso-8859-1");
}

response.setHeader("Content-Disposition", "attachment; filename = " + file_name);

ServletOutputStream out2 = response.getOutputStream();
int numRead;
while((numRead = in.read(b, 0, b.length)) != -1) {
	out2.write(b, 0, numRead);
}

// input & output stream 정리
out2.flush();
out2.close();
in.close();

%>