<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="base.jsp"%>
	<div class="content">

		<br />
		<br />
		<br />
		<br />

		<!-- 로그인 폼과 오류메세지
ログインフォームとエラーメッセージ -->
		<div align="center">
			<form action="login.do" method="post">

				<c:if test="${errors.idOrPwNotMatch}">
社員番号とパスワードが一致しません。
</c:if>
				<p>
					社員番号:<br />
					<input type="text" name="id" value="${param.id}">
					<c:if test="${errors.id}">
						<br />社員番号を入力してください。</c:if>
				</p>
				<p>
					パスワード:<br />
					<input type="password" name="password">
					<c:if test="${errors.password}">
						<br />パスワードを入力してください。</c:if>
				</p>
				<br />
				<button class="submit-button">ログイン</button>
			</form>
			<form action="join.do" method=post>
				<br />
				<button type="submit" class="submit-button">会員登録ページへ</button>
			</form>
		</div>



	</div>
	<div class="footer">
		<p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
	</div>
</body>
</html>