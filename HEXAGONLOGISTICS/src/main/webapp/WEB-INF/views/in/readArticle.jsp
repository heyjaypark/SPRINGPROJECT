<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お知らせ</title>
    <link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
 <%@ include file="base.jsp" %>
    <div class="content">
<div class="readTable">
<table>
<tr>
<th>No</th>
<td>${articleData.article.article_no}</td>
</tr>
<tr>
<th>書き手</th>
<td>${articleData.article.name}</td>
</tr>
<tr>
<th>題名</th>
<td><c:out value='${articleData.article.title}'/></td>
</tr>
<tr>
<th>内容</th>
<td><textarea name="content" rows="30" cols="50" readonly><u:pre value='${articleData.content.content}'/></textarea></td>
</tr>
<tr>
<th>
<td>

<c:set var="pageNum" value="${empty param.pageNum ? '1' : param.pageNum}" />
<a href="/in/listArticle?pageNum=${pageNum}"><button class=submit-button>投稿リストへ</button></a>
<!-- 로그인한 유저가 작성자라면 상세 기능 버튼을 표시한다
ログインしたユーザーが作成者であれば詳細機能ボタンを表示する -->
<c:if test="${authUser.id == articleData.article.id}">
<a href="/in/modifyForm?no=${articleData.article.article_no}&pageNum=${pageNum}"><button class=submit-button>投稿修正</button></a>
<a href="/in/DeleteForm?no=${articleData.article.article_no}"><button class=submit-button>投稿削除</button></a>
</c:if>
</td>
</tr>
</table>
</div>
</div>
    <div class="footer">
        <p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
    </div>
</body>
</html>