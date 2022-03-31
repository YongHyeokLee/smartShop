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
		<div class="form-floating mt-2">
			<input type="text"  name="name" class="form-control" placeholder="거래처">
			<label>거래처</label>
		</div>
		<div class="form-floating mt-2">
			<input type="text"  name="tel" class="form-control" placeholder="전화번호">
			<label>전화번호:</label>
		</div>
		<div class="form-floating mt-2">
			<input type="text"  name="address" class="form-control" placeholder="주소">
			<label>주소:</label>
		</div>
		
		<div class="row mt-4">
			<div class="col"></div>
			<div class="col"><button class="btn btn-primary form-control">등록</button></div>
			<div class="col"></div>
		</div>
		</form>
	</div>
	<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>