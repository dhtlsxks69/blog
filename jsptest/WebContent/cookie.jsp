<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 쿠키 사이즈 : 4KB -->
쿠키 문자를 몇개?? 4000Byte --> 4000개 <br />
<!-- 쿠키 최대 용량 -->
쿠키 갯수 300개 --> 1.2MB --> 1,200,000개 <br />
<%
	Cookie c = new Cookie("list", "cap");
	c.setMaxAge(6000); // 6000이면 6000초
	response.addCookie(c);
%>
<a href="check.jsp">쿠키 확인</a>
</body>
</html>