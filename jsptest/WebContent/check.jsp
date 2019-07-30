<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 확인</h1>
<hr />
<%
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		//내장객체 out
		out.println(c.getName()+"<br />");
		out.println(c.getValue()+"<br />");
	}
%>
</body>
</html>