<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书列表</title>
<link rel="stylesheet" href="${contextPath}/assets/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="container" >
     <h2 >图书列表</h2> 
              <%@ include file="header.jspf" %>
  <div>
      <a href="${contextPath}/book/add" class="btn btn-default btn-ms" >添加</a>
         <button type="button" class="btn btn-danger btn-ms" id="batch-delete-btn">批量删除</button>
         <form action="${contextPath}/book/batch-delete" method="post" style="display:none;" id="batch-delete-form">
          <input type="hidden" name="ids">
         </form>
         
         <form action="${contextPath}/book/search" method = "get" style = "display:inline;" class="form-inline">
              <input type="text" name="bookname" value = "${bookSearch.bookname }" class="form-control" placeholder="输入书名">
              <input type="text" name="bookauthor" value = "${bookSearch.author }" class="form-control" placeholder="输入作者">
              <button type="submit" class="btn btn-default">搜索</button>
         </form>
  </div>
  <table class="table table-hover">
     <tr>
        <th>编号</th><th>书名</th><th>作者</th><th>出版社</th><th>出版年份</th><th>简介</th><th>类别</th><th>操作</th>
     </tr>
         <c:forEach var="book" items="${books}">
            <tr>
               <td><input type="checkbox" data-book-id="${book.id}">
                   ${book.id }</td>
                   <td>${book.bookname }</td> 
                    <td>${book.author }</td>
                    <td>${book.press }</td>
                    <td><fmt:formatDate value="${book.year}" pattern="yyyy-MM-dd"/></td>
                    <td>${book.synopsis }</td>
                    <td>${book.category }</td>
                 <td>
                  <a href="${contextPath}/book/${book.id}/edit" class="btn btn-default btn-xs">修改</a>
                  <a href="${contextPath }/book/${book.id}/details" class="btn btn-default btn-xs">详情</a>
                 <form action="${contextPath}/book/${book.id}/delete" method="post" style = "display :inline;">
                 <button type="submit" class="btn btn-danger btn-xs">删除</button>
                 </form>
                 </td>                           
            </tr>
         </c:forEach>
  </table>
  <!-- 分页器 -->
  <ul id="pagination" class="pagination-sm"></ul>
  </div>
  <script type="text/javascript" src="${contextPath}/assets/jquery/jquery.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/twbs-pagination/jquery.twbsPagination.min.js"></script>
  <script type="text/javascript" src="${contextPath}/assets/js/book-list.js"></script>
    <script>
        $('#pagination').twbsPagination({
      totalPages: ${pageCount},
      visiblePages: 7,
      onPageClick: function (event, page) {
          console.log('go to page ' + page);
          window.location = '${contextPath}/book?page=' + page;
      },
      initiateStartPageClick: false,
      startPage: ${currentPage}
           });
  </script>
  
</body>
</html>