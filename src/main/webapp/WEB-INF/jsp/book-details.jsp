<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书详情</title>
   <style type="text/css">
       .book-picture {
              width : 100px;
              heiht:100px
       }
   </style>
</head>
<body>
<h3>图书详情</h3>
<div>
     <div>
                              照片：
             <c:choose>
                <c:when test="${book.picturePath!=null}">
                      <img src="${contextPath}/book-pictures/${book.picturePath}" 
                      class="book-picture">                   
                </c:when>
                <c:otherwise>
                                                                    无
                </c:otherwise>
             </c:choose>
</div>
书名&emsp;&emsp;${book.bookname }
		<br>
作者&emsp;&emsp; ${book.author }
		<br>
出版社&emsp;${book.press }
		<br>
出版年份<fmt:formatDate value="${book.year }" pattern="yyyy-MM-dd"/>
		<br>
简介&emsp;&emsp;${book.synopsis }
		<br>
类别&emsp;&emsp;${book.category }
</div>
</body>
</html>