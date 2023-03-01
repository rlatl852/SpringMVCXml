<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Spring MVC</h1>
	<h4	><a href="${contextPath}/Board/list">게시판</a></h4>
	<img src="images/7fd47d7a-c60a-4b13-a159-f25f3fb42372_angel-5705040_640.jpg"/>
</body>
</html>