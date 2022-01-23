<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.NoticeDTO" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="pageInfo" class="model.PageInfoDTO" />
<%
// parameter값 받아서 noticeSearch()의 매개변수 형태에 맞춰주기
String field = request.getParameter("field");
String words = request.getParameter("words");
int limit = 10;
int nowPage = 1;
if(request.getParameter("page") != null) {
	nowPage = Integer.parseInt(request.getParameter("page"));
}

// noticeSearch() 실행해서 noticeList 리턴받기
ArrayList<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
noticeList = dao.noticeSearch(field, words, nowPage, limit);
request.setAttribute("noticeList", noticeList);

// 페이징
int listCount = dao.noticeSearchCount(field, words);
int maxPage = (int)((double)listCount / limit + 0.95);
int startPage = ((int)((double)nowPage / limit + 0.9) - 1) * 10 + 1;
int endPage = startPage + 9;
if(endPage > maxPage) {
	endPage = maxPage;
}
pageInfo.setListCount(listCount);
pageInfo.setPage(nowPage);
pageInfo.setMaxPage(maxPage);
pageInfo.setStartPage(startPage);
pageInfo.setEndPage(endPage);
request.setAttribute("pageInfo", pageInfo);

// forward
RequestDispatcher dispatcher = request.getRequestDispatcher("noticeSearchPage.jsp?field=" + field + "&words=" + words);
dispatcher.forward(request, response);
%>