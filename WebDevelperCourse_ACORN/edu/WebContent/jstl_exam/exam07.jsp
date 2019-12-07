<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url value="exam08.jsp" var="page">
		<c:param name="id" value="guest" />
		<c:param name="pwd" value="1004" />
	</c:url>
	<c:redirect url="${page }" />
</body>
</html>