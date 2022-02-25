<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%
if(((String)session.getAttribute("id")).equals("kakao****")) { // 카카오 로그아웃 API
%>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
Kakao.init('9dba1125139c9fc4d8f64e57190988a7');
if (Kakao.Auth.getAccessToken()) { // 로그인 되어 있으면,
    Kakao.API.request({
      url: '/v1/user/unlink'
      /* success: function (response) {
      	console.log(response);
      },
      fail: function (error) {
        console.log(error);
      }, */
    })
	Kakao.Auth.setAccessToken(undefined);
}
</script>

<%
}
session.removeAttribute("id"); // 헤이키친의 로그인 세션 정보 제거

session.removeAttribute("adminName");
session.removeAttribute("auth9999");
response.sendRedirect("login.jsp");
%>