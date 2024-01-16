<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿修正</title>
<link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="base.jsp"%>
	<div class="content">
		<div align="center">

			投稿を修正しました。 <br />
			<br /> ${ctxPath = pageContext.request.contextPath ; '' }
			<div class="succes">
				<a href="${ctxPath}/list.do"><button class=submit-button>投稿リストへ</button></a>
				<a href="${ctxPath}/read.do?no=${modReq.articleNumber}"><button
						class=submit-button>投稿内容閲覧</button></a>
			</div>
		</div>
	</div>
	<div class="footer">
		<p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
	</div>
</body>
</html>