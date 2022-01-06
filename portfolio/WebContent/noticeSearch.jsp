<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.NoticeDTO" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<%
// parameter값 받아서 noticeSearch()의 매개변수 형태에 맞춰주기
String category = request.getParameter("category");
String field1 = "";
String field2 = "";
if(category.equals("both")) {
	field1 = "title";
	field2 = "content";
} else
	field1 = category;
String words = request.getParameter("words");

// noticeSearch() 실행해서 noticeList 리턴받기
ArrayList<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
noticeList = dao.noticeSearch(field1, field2, words);

// jstl에서 바로 사용하기 위해서는 setAttribute()
request.setAttribute("noticeList", noticeList);

// forward
RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
dispatcher.forward(request, response);
%>