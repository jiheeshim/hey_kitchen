<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>


<%
String clientId = "ZKuwqzVwlCAldtVAiRPW";//애플리케이션 클라이언트 아이디값";
String clientSecret = "B4LfXbNNqm";//애플리케이션 클라이언트 시크릿값";
String code = request.getParameter("code");
String state = request.getParameter("state");
String redirectURI = URLEncoder.encode("YOUR_CALLBACK_URL", "UTF-8");
String apiURL;
apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
apiURL += "client_id=" + clientId;
apiURL += "&client_secret=" + clientSecret;
apiURL += "&redirect_uri=" + redirectURI;
apiURL += "&code=" + code;
apiURL += "&state=" + state;
String access_token = "";
String refresh_token = "";
System.out.println("apiURL="+apiURL);
try {
  URL url = new URL(apiURL);
  HttpURLConnection con = (HttpURLConnection)url.openConnection();
  con.setRequestMethod("GET");
  int responseCode = con.getResponseCode();
  BufferedReader br;
  System.out.print("responseCode="+responseCode); //
  if(responseCode==200) { // 정상 호출
    br = new BufferedReader(new InputStreamReader(con.getInputStream()));
  } else {  // 에러 발생
    br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
  }
  String inputLine;
  StringBuffer res = new StringBuffer();
  while ((inputLine = br.readLine()) != null) {
    res.append(inputLine);
  }
  br.close();
  if(responseCode==200) { // 로그인 성공
	//access_token = res.toString().substring(17, 108);
    //System.out.println(res.toString());
    //System.out.println("access_token: " + access_token);
    session.setAttribute("id", "naver****");
    //response.sendRedirect("login.kitchen?where=naverLogin&access_token=" + access_token); //회원정보 조회 쓰려면 서블릿컨트롤러에 추가해야함
    response.sendRedirect("index.jsp");
  }
} catch (Exception e) {
  System.out.println(e);
}
%>