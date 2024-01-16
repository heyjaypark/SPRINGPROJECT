<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
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
		<div class="contentTable" align="center">
			<form action="write.do" method="post">
				<table border="1">
					<tr>
						<th><font color=“#000000” size=“11”> タイトル</font></th>
						<td><input class="title" type="text" name="title"
							value="${param.title}" /></td>
						<!-- 제목은 공백이 아닐 것
タイトルは空白でないこと -->
						<c:if test="${errors.title}">タイトルを入力してください。</c:if>
					</tr>
					<tr>
						<th><font color=“#000000” size=“11”> 内容</font></th>
						<td><textarea name="content" rows="30" cols="100">${param.content}</textarea></td>
					</tr>

				</table>
				<button class=submit-button>登録</button>
			</form>
		</div>
	</div>
	<div class="footer">
		<p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
	</div>
</body>
</html>