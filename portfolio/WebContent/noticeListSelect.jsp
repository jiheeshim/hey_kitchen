<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.NoticeDTO" %>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<%
// noticeListSelect()한 결과 받아오기
ArrayList<NoticeDTO> noticeList = new ArrayList<NoticeDTO>();
noticeList = dao.noticeListSelect();

// 리턴 받은 값을 화면에서 사용할 수 있도록 setAttribute()
request.setAttribute("noticeList", noticeList);

// forward
RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
dispatcher.forward(request, response);

%>