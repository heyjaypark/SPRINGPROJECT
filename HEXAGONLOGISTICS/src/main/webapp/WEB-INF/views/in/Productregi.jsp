<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在庫管理</title>
    <link href="${path}/resources/css/test.css" rel="stylesheet"/>
</head>
<body>
 <%@ include file="base.jsp" %>
    <div class="content">
    <div align="center">
<form id='actionForm' action="/in/ProductRegist" method="post">	
	<table border="1">

<tr>

<th>品目名</th>
<th>ソウル店</th>
<th>水原店</th>
<th>仁川店</th>
<th>単価</th>
<th>日付</th>
</tr>
<tr>

<td>
<input type="text" name="p_name" size="27%"/>
</td>
<td>
<input type="text" name="p_seoul" size="27%"/>
</td>
<td>
<input type="text" name="p_suwon" size="27%"/>
</td>
<td>
<input type="text" name="p_incheon" size="27%"/>
</td>
<td>
<input type="text" name="price" size="27%"/>
</td>
<td>
<input type="date" name="date" id="today">

<%-- <input type="hidden" name="writer" value="${authUser.name }"> --%>
</td>
</tr>
</table>

<button type="submit" class="submit-button">登録</button>

<%-- <!-- 에러발생 및 등록 성공시 -->
<c:if test="${errors.NoMinus}">
正数を入力してください
</c:if>

<c:if test="${errors.numberInsert}">
入力してください
</c:if> --%>


<c:if test="${errors.successRegi}">
<script type="text/javascript">
alert("登録されました");
</script>
</c:if>




</form>

</div>
</div>
    <div class="footer">
        <p>&copy; 2024 HEXAGON LOGISTICS. All rights reserved.</p>
    </div>
</body>
</html>