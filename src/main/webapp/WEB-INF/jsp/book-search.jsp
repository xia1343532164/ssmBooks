<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书搜索</title>
<link rel="stylesheet" href="${contextPath}/assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
 <div class="container">
   <h3>搜索结果</h3>
<table class="table table-hover">
     <tr>
       <th>书名</th><th>作者</th><th>出版社</th><th>出版年份</th><th>简介</th><th>类别</th>
     </tr>
         <c:forEach var="book" items="${book}">
            <tr>
                <td>${book.bookname }</td>
                <td>${book.author }</td>
                <td>${book.press }</td>
                <td><fmt:formatDate value="${book.year}" pattern="yyyy-MM-dd"/></td>
                <td>${book.synopsis }</td>
                <td>${book.category }</td>
           </tr>
          </c:forEach>
   </table>
   </div>
</body>
</html>