<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<div>
			<h3>출고내역 변경</h3>
		</div>
	
		<form method="post" class="mt-4">
		
		<div class="mt-2">
			<label>제품명</label>
			<select name="product" class="form-select">     
				<c:forEach var="product" items="${listProduct}">
					<option value="${product.code}" ${item.product == product.code ? 'selected' : ''}>${product.name}</option>
				</c:forEach>                    <!-- 이전에 선택한 값을 미리 선택해주기 위해서 -->
			</select>								<!-- 출력하는 제품이 입고에 있는 제품이면 selected을 출력하거 그렇지 않으면 공백 -->
		</div>
		
		<div class="mt-2">
			<label>거래처</label>
			<select name="partner" class="form-select">
				<c:forEach var="partner" items="${listPartner}">
					 <option value="${partner.code}" ${item.partner == partner.code ? 'selected' : ''}>${partner.name}</option>
				</c:forEach>
			</select>
		</div>
		
		<div class="input-group mt-2">
			<label class="input-group-text col-2">수량</label>
			<input type="number" name="amount" class="form-control" value="${item.amount}">
		</div>
		<div class="row mt-4">
			<div class="col"></div>
			<div class="col"><button class="btn btn-primary form-control">변경</button></div>
			<div class="col"></div>
		</div>
		</form>
	</div>
	<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>