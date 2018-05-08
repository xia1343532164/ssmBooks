<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<c:set var="title" value="${book.id== null ? '添加客户' : '修改客户'}"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
<link rel="stylesheet" href="${contextPath}/assets/css/app.css">
</head>
<body>
	<h3>${title}</h3>
	<!-- 1. 表单重要属性: method="post" enctype="multipart/form-data" -->
	<form:form action="" method="post" commandName="book" enctype="multipart/form-data">
书名&emsp;&emsp;<form:input type="text" path="bookname" />
     <form:errors path="bookname" cssClass="field-error"></form:errors>
	<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<br>
作者&emsp;&emsp;<form:input type="text" path="author" />
     <form:errors path="author" cssClass="field-error"></form:errors>
		<br>
出版社&emsp;<form:input type="text" path="press" />
     <form:errors path="press" cssClass="field-error"></form:errors>
		<br>
出版年份<form:input type="text" path="year" />
     <form:errors path="year" cssClass="field-error"></form:errors>
		<br>
简介&emsp;&emsp;<form:input type="text" path="synopsis" />
     <form:errors path="synopsis" cssClass="field-error"></form:errors>
		<br>
类别&emsp;&emsp;<form:input type="text" path="category" />
     <form:errors path="category" cssClass="field-error"></form:errors>
		<br>
上传照片<input type = "file" name="picture">
     <form:errors path="picture" cssClass="field-error"></form:errors>
            <br>
	 <button  type="submit">提交</button>
	</form:form>
</body>
</html>