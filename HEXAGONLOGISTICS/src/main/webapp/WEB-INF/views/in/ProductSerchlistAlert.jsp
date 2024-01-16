<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>在庫状況</title>

<script type="text/javascript">
	function SetParentText(productNo) {
		var p_name = document.getElementById("p_name_" + productNo).value;
		window.opener.document.getElementById("code").value = p_name;
		window.close();
	}
</script>


<link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>




	 

	<div align="center">

		<br />
		<form action="productsearchchange.do" name="p_no" method="post">
			<div>


				品目名:<input type="text" name="code" value="${param.code}"
					list="searchOptions" /> <input type="submit" value="検索">
			</div>




			<c:if test="${errors.NumberFormatException}">
				<script type="text/javascript">
					alert("数字のみ入力可能です。");
				</script>
			</c:if>

		</form>
		<input type="button" value="창닫기" onclick="window.close()">


<div class="SearchAlert">
		<table border="1">
			<tr>

			</tr>
			<tr>
				<th>品目コード</th>
				<th>品目名</th>

			</tr>

			<c:if test="${productPage.hasNoArticles()}">
				<tr>
					<td colspan="4">商品がありません</td>
				</tr>
			</c:if>

			<!-- 특정품목 검색시 결과를 표시하고 테이블을 닫는다.
特定品目検索時に結果を表示し、テーブルを閉じる。 -->

			<!-- 페이지에 따른 품목리스트 표시
ページによる品目リストの表示 -->
			<c:forEach var="product" items="${productChange}">
				<tr>
					<td>${product.p_no}</td>
					<td><input type="hidden" id="p_name_${product.p_no}"
						value="${product.p_name}"> <input type="button"
						value="${product.p_name}"
						onclick="SetParentText('${product.p_no}')"></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</div>
    
</body>
</html>