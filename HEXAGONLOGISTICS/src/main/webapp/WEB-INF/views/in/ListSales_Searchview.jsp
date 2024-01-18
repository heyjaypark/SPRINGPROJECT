<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>販売履歴</title>
<link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
	<%@ include file="base.jsp"%>
	<div class="content">
		<div align="center">
			<!-- 판매번호 또는 품목번호로 검색할 수 있다
		販売番号または品目番号で検索できる -->
			<form action="/in/ListSales_Searchview" name="p_no" method="get">
				<div>
					<select name="select_num">
						<option value="1">取引番号</option>
						<option value="2">品目コード</option>
					</select> <input type="text" name="code" value="${param.code}" required>
					<input type="submit" value="検索">
					<%-- <c:if test="${errors.Notnum}">数字だけ入力してください。</c:if> --%>
				</div>
			</form>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th>取引番号</th>
					<th>品目コード</th>
					<th>品目名</th>
					<th>ソウル店<br />販売量
					</th>
					<th>水原店<br />販売量
					</th>
					<th>仁川店<br />販売量
					</th>
					<th>日付</th>
					<th>単価</th>
					<th>Total</th>
					<th>登録者</th>
				</tr>
				<%-- <c:if test="${salesPage.hasNoArticles()}"> --%>
				<!-- 	<tr>
						<td colspan="7">該当販売履歴がありません。</td>
					</tr> -->
				<%-- </c:if> --%>
				<!-- 판매리스트를 표시한다
			販売リスト表示 -->
				<c:forEach var="sales" items="${salesPage.content}">
					<tr>
						<td>${sales.s_num}</td>
						<td>${sales.p_no}</td>
						<td>${sales.p_name}</td>
						<td>${sales.s_seoul}</td>
						<td>${sales.s_suwon}</td>
						<td>${sales.s_incheon}</td>
						<td>${sales.s_date}</td>
						<td>${sales.price}</td>
						<td>${sales.price*(sales.s_seoul+sales.s_suwon+sales.s_incheon)}</td>
						<td>${sales.s_registrant }</td>
					</tr>
				</c:forEach>
				<%-- <c:if test="${salesPage.hasArticles()}"> --%>
					<tr>
						<td colspan="10">
							<!-- 페이징 코드. 단위는 5개
			ページングコード。 単位は五つ --> <c:if test="${salesPage.startPage > 5}">
								<a
									href="/in/ListSales_Searchview?select_num=2&code=${param.code}&pageNum=${salesPage.startPage - 5}">[以前]</a>
							</c:if> <c:forEach var="pNo" begin="${salesPage.startPage}"
								end="${salesPage.endPage}">
								<a
									href="/in/ListSales_Searchview?select_num=2&code=${param.code}&pageNum=${pNo}">[${pNo}]</a>
							</c:forEach> <c:if test="${salesPage.endPage < salesPage.totalPages}">
								<a
									href="/in/ListSales_Searchview?select_num=2&code=${param.code}&pageNum=${salesPage.startPage + 5}">[次のページへ]</a>
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