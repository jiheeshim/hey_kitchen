<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.NoticeDTO" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<jsp:useBean id="pageInfo" class="model.PageInfoDTO" />
<%
int limit = 10;
int nowPage = 1;
if(request.getParameter("page") != null) {
	nowPage = Integer.parseInt(request.getParameter("page"));	
}

// noticeListSelect()한 결과 받아오기
ArrayList<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
noticeList = dao.noticeListSelect(nowPage, limit);
request.setAttribute("noticeList", noticeList);

// 페이징
int listCount = dao.noticeListCount();
int maxPage = (int)((double)listCount / limit + 0.95); // 총 페이지 수
int startPage = (int)(((double)nowPage / 10 + 0.9) - 1) * 10 + 1;
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
RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
dispatcher.forward(request, response);

%>