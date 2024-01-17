<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
    <c:set var="path" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫状況</title>
    <link href="${path}/resources/css/test.css" rel="stylesheet"/>
<script>

	
	function openChild() {
	    window.name = "parentForm";
	    openWin = window.open("/in/ProductSerchlistAlert", "childForm", "width=800, height=600, resizable=no, scrollbars=no");
	}

	function setParentText() {
	    console.log("setParentText 함수 호출");
	    
	    // 값이 정확하게 가져와지는지 확인
	    //値が正確に持ってきてのかどうか確認
	    console.log("p_name 값:", document.getElementById("p_name").value);

	    // 부모 창에서 코드 요소가 정확한지 확인
	    //親ウィンドウでコード要素が正確であることを確認します
	    console.log("부모 창의 code 요소:", window.opener.document.getElementById("code"));

	    // 부모 창의 코드 요소에 값 설정
	    //親ウィンドウのコード要素に値を設定します
	    window.opener.document.getElementById("code").value = document.getElementById("p_name").value;
	    
	    // 창 닫기
	    //ウィンドウ終了
	    window.close();
	}
	
	
	
	</script>
</head>
<body>
 <%@ include file="base.jsp" %>
    <div class="content">
<div align="center">

<br/>
<form id='actionForm' action="/in/ProductSearchlist" name="p_no" method="get">
			<div>
				<select name="select_num">
    				<option value="2">品目名</option>    
    				<option value="1">品目コード</option>
				</select>
				
				<input type="text" name="code" id="code" value = "${param.code}"  list = "searchOptions"
				placeholder="${param.code}" />
				<datalist id ="searchOptions">
				<c:forEach var="product" items="${product.content}">
				<search option>${product.p_name}</search>
				</c:forEach>
				</datalist>
				<input type="submit" value="検索">
			</div>
	
		
			
		
<%-- <c:if test="${errors.NumberFormatException}">
   <script type="text/javascript">
alert("数字のみ入力可能です。");
</script>
</c:if> --%>

</form>

<button type="submit" class="submit-button" onclick="openChild()">製品名検索</button>


<table border="1">
<tr>

</tr>
<tr>
<th>品目コード入力</th>
<th>品目名</th>
<th>ソウル店</th>
<th>水原店</th>
<th>仁川店</th>
<th>単価</th>

</tr>

<%-- <c:if test="${productPage.hasNoArticles()}">
<tr>
<td colspan="4">商品がありません</td>
</tr>
</c:if> --%>

<!-- 특정품목 검색시 결과를 표시하고 테이블을 닫는다.
特定品目検索時に結果を表示し、テーブルを閉じる。 -->

<!-- 페이지에 따른 품목리스트 표시
ページによる品目リストの表示 -->
<c:forEach var="product" items="${product.content}">
<tr>
<td>
${product.p_no}
</td>
<td>
${product.p_name}
</td>
<td>
${product.p_seoul}
</td>
<td>
${product.p_suwon}
</td>
<td>
${product.p_incheon}
</td>
<td>
${product.price}
</td>

</tr>
</c:forEach>

<!-- 페이징 코드. 단위는 5개.
ページングコード。 単位は5つ。 -->
<%-- <c:if test="${productPage.hasArticles()}"> --%>
<tr>
<td colspan="6">
<c:if test="${product.startPage > 5}">
<a href="/in/ProductSearchlist?select_num=2&code=${param.code}&pageNum=${product.startPage - 5}">[以前]</a>
</c:if>
<c:forEach var="pNo"
begin="${product.startPage}"
end="${product.endPage}">
<a href="/in/ProductSearchlist?select_num=2&code=${param.code}&pageNum=${pNo}">[${pNo}]</a>
</c:forEach>
<c:if test="${product.endPage < productPage.totalPages}">
<a href="/in/ProductSearchlist?select_num=2&code=${param.code}&pageNum=${product.startPage + 5}">[次のページ]</a>
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