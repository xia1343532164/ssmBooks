<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>图书管理</title>
	
	<link type="text/css" rel="stylesheet" href="${contextPath}/assets/jsgrid/jsgrid.min.css" />
	<link type="text/css" rel="stylesheet" href="${contextPath}/assets/jsgrid/jsgrid-theme.min.css" />
</head>
<body>
	<div class="container">
	   <%@ include file = "header.jspf" %>
		<h3>使用【jsgrid + ajax】实现图书增删改查</h3>
		<div id="jsGrid"></div>
	</div>
</body>
	<script type="text/javascript" src="${contextPath}/assets/jquery/jquery.js"></script>
	<script type="text/javascript" src="${contextPath}/assets/jsgrid/jsgrid.min.js"></script>
	<script type="text/javascript" src="${contextPath}/assets/js/books-crud.js"></script>
</html>