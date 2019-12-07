<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Bean</title>
</head>
<body>
	<jsp:useBean class="com.edu.beans.HelloBeans" id="hello" />
	
	<jsp:getProperty property="name" name="hello" /><br>
	<jsp:getProperty property="number" name="hello"/><br>
	
	<%-- <jsp:setProperty property="name" name="hello" value="Amy"/>
	<jsp:setProperty property="number" name="hello" value="12345"/>
	 --%>
	<jsp:setProperty property="name" name="hello" param="a"/>
	<jsp:setProperty property="number" name="hello" param="b"/>
	
	
	<hr>
	
	<jsp:getProperty property="name" name="hello"/><br>
	<jsp:getProperty property="number" name="hello"/><br>
</body>
</html>