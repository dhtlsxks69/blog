<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
getcontextPath = <%= request.getContextPath() %> <br />
getMethod = <%= request.getMethod() %> <br />
getRequestURL = <%= request.getRequestURL() %> <br />
getRequestURI = <%= request.getRequestURI() %> <br />
getQueryString = <%= request.getQueryString() %> <br />
getRemoteHost = <%= request.getRemoteHost() %> <br />
getRemoteAddr = <%= request.getRemoteAddr() %> <br />
getRemoteUser = <%= request.getRemoteUser() %> <br />
getRemotePort = <%= request.getRemotePort() %> <br />
getServerName = <%= request.getServerName() %> <br />
getProtocol = <%= request.getProtocol() %> <br />
getCharacterEncoding = <%= request.getCharacterEncoding() %> <br />
getContentType = <%= request.getContentType() %> <br />
getLocalAddr = <%= request.getLocalAddr() %> <br />
</body>
</html>