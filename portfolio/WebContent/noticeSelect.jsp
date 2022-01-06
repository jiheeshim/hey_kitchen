<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="notice" class="model.NoticeDTO"/>
<jsp:useBean id="dao" class="controller.ControllerDAO" />
<%
// 클릭한 타이틀을 가진 게시물의 noticeNo를 parameter로 받아옴
int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
String purpose = request.getParameter("purpose");

// 해당 noticeNo를 가진 게시물의 데이터 가져오기
notice = dao.noticeSelect(noticeNo);

// 가져온 데이터들을 다음 화면에서 사용하기 위해 setAttribute()
request.setAttribute("notice", notice);

// forward
RequestDispatcher dispatcher = null;
if(purpose.equals("view")) {
	dispatcher = request.getRequestDispatcher("noticeView.jsp");
	dispatcher.forward(request, response);	
} else if(purpose.equals("edit")) {
	dispatcher = request.getRequestDispatcher("noticeEdit.jsp");
	dispatcher.forward(request, response);
}

%>