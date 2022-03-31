<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../include/header.jsp"></jsp:include>

<script>     //window.onload - html을 전부 읽어서 dom 을 다만듬 
//function 함수 const 상수     val() 


	function checkStock() {
		const select = $("select[name='product']");
		const max = select.find("option[value='" + select.val() + "']").data("amount");
		  // $(this) = change 이벤트
		  
		$("#msg").text("수량 (재고:" + max + ")");
		$("input[name='amount']").attr("max", max);
	
}
	$(function() {       
		$("select[name='product']").on("change", function() {
			checkStock(); 
		});	
		checkStock();
	});
</script>

</head>
<body>
	<div class="container">
		<form method="post" class="mt-4">
		<div>
			<h3>출고내역 등록</h3>
		</div>
		<div class="mt-2"> 
			<label>제품명</label>      
			<select name="product" class="form-select">     <!-- select-목록생성 -->
				<c:forEach var="item" items="${listProduct}">   <!-- items="${listProduct}" controller model에 지정한 이름 -->
					<option value="${item.code}" data-amount="${item.amount}">${item.name}</option>
				</c:forEach>                    <!--data-amount-데이터셋  -->
			</select>
		</div>
		
		<div class="mt-2">
			<label>거래처</label>
			<select name="partner" class="form-select">
				<c:forEach var="item" items="${listPartner}">
					 <option value="${item.code}">${item.name}</option>
				</c:forEach>
			</select>
		</div>
		
		
		<div class="form-floating mt-2">
			<input type="number" name="amount" class="form-control" placeholder="수량" min="1" max="">
			<label id="msg">수량</label>
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