<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫履歴</title>
    <link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
 <%@ include file="base.jsp" %>
    <div class="content">
<div align="center">
<form id='actionForm' action="/in/ProductLogSearchList" name="p_no" method="get">
				<div>
					<select name="select_num">
						<option value="2">品目名</option>
						<option value="1">品目コード</option>
					</select> <input type="text" name="code" id="code" value="${param.code}"
						list="searchOptions" placeholder="${param.code}" />
					<datalist id="searchOptions">
						<c:forEach var="product" items="${productPage.content}">
							<option>${product.p_name}</option>
						</c:forEach>
					</datalist>
					<input type="submit" value="検索">
				</div>


				<!-- 숫자 아닌 문자를 입력시 오류발생
 数字以外の文字を入力する際にエラー発生 -->
		<c:if test="${errors['NumberFormatException']}">
    <script type="text/javascript">
    console.log("NumberFormatException occurred!");
        alert("数字のみ入力可能です。");
    </script>
</c:if>
			</form>


<table border="1">
<tr>

</tr>
<tr>
<th>入庫番号</th>
<th>タイプ</th>
<th>品目番号</th>
<th>品目名</th>
<th>ソウル店</th>
<th>水原店</th>
<th>仁川店</th>
<th>単価</th>
<th>登録日</th>
<th>登録者</th>

</tr>

<%-- <c:if test="${product.hasNoArticles()}">
<tr>
<td colspan="4">商品がありません</td>
</tr>
</c:if> --%>
<c:forEach var="product" items="${product.content}">
<tr>
<td>
${product.l_no}
</td>
<td>
${product.l_class}
</td>
<td>
${product.p_no}
</td>
<td>
${product.l_name}
</td>
<td>
${product.l_seoul}
</td>
<td>
${product.l_suwon}
</td>
<td>
${product.l_incheon}
</td>
<td>
${product.l_price}
</td>
<td>
${product.l_date}
</td>
<td>
${product.l_writer}
</td>
</tr>
</c:forEach>

<!-- 페이징 코드. 단위는 5개.
ページングコード。 単位は5つ。 -->
<%-- <c:if test="${productLogPage.hasArticles()}"> --%>
<tr>
<td colspan="10">
<c:if test="${product.startPage > 5}">
<a href="/in/ProductLogList?pageNum=${product.startPage - 5}">[以前]</a>
</c:if>
<c:forEach var="pNo"
begin="${product.startPage}"
end="${product.endPage}">
<a href="/in/ProductLogList?pageNum=${pNo}">[${pNo}]</a>
</c:forEach>
<c:if test="${product.endPage < product.totalPages}">
<a href="/in/ProductLogList?pageNum=${product.startPage + 5}">[次のページ]</a>
</c:if>
</td>
</tr>
<%-- </c:if> --%>
</table>
</div>
</div>
    <div class="footer">
        <p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
    </div>
</body>
</html>