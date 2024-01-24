<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書き込み</title>
<link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="base.jsp"%>
	<div class="content">
		<div align="center">
			<br />
			<br />投稿を登録しました。<br />
			<br />
		</div>
		
		<div class="success">
			<a href="/in/listArticle"><button class=submit-button>投稿リストを見る</button></a>
			<a href="/in/read?no=${newArticleNo}"><button
					class=submit-button>掲示物の内容を見る</button></a>
		</div>
	</div>
	<div class="footer">
		<p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
	</div>
</body>
</html>