<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿リスト</title>
<link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="base.jsp"%>
	<div class="content">



		<table class="article_table" border="1">
			<tr>
				<td colspan="4"><h1>
						<a href="/in/newArticleForm">[書き込み]</a>
					</h1></td>
			</tr>
			<tr>
				<th>NO</th>
				<th>題名</th>
				<th>書き手</th>
				<th>照会数</th>
			</tr>
			<c:if test="${articlePage.hasNoArticles()}">
				<tr>
					<td colspan="4">投稿がありません。</td>
				</tr>
			</c:if>
			<!-- 게시글 리스트
投稿リスト -->
			<c:forEach var="article" items="${articlePage.content}">
				<tr>
					<td>${article.article_no}</td>
					<td><a
						href="/in/read?no=${article.article_no}&pageNum=${articlePage.currentPage}">
							<c:out value="${article.title}" />
					</a></td>
					<td>${article.name}</td>
					<td>${article.read_cnt}</td>
				</tr>
			</c:forEach>
			<c:if test="${articlePage.hasArticles()}">
				<tr>
					<td colspan="4"><c:if test="${articlePage.startPage > 5}">
							<a href="/in/listArticle?pageNum=${articlePage.startPage - 5}">[以前]</a>
						</c:if> <!-- 페이징 코드. 단위는 5개
						ページングコード。 単位は五つ --> <c:forEach var="pNo"
							begin="${articlePage.startPage}" end="${articlePage.endPage}">
							<a href="/in/listArticle?pageNum=${pNo}">[${pNo}]</a>
						</c:forEach> <c:if test="${articlePage.endPage < articlePage.totalPages}">
							<a href="/in/listArticle?pageNum=${articlePage.startPage + 5}">[次ページへ]</a>
						</c:if></td>
				</tr>
			</c:if>
		</table>
	</div>
	<div class="footer">
		<p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
	</div>
</body>
</html>