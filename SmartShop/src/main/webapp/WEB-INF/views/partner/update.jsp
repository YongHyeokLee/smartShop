<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>
	<div class="container">
		<form method="post" class="mt-4">
		<div class="input-group mt-2">
			<label class="input-group-text col-2">거래처</label>
			<input type="text" name="name" class="form-control"  value="${item.name}">
		</div>
		<div class="input-group mt-2">
			<label class="input-group-text col-2">전화번호:</label>
			<input type="text"  name="tel" class="form-control"  value="${item.tel}">
		</div>
		<div class="input-group mt-2">
			<label class="input-group-text col-2">주소</label>
			<input type="text"  name="address" class="form-control"  value="${item.address}">
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