<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../include/header.jsp"></jsp:include>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<script>
	$(function() {
		$('#summernote').summernote();
		
		$("#add_image").click(function() {
			const div = $("<div>").addClass("mt-2");
			const label = $("<label>").text("제품이미지:  ");
			const button = $("<span>").text("삭제");
			button.addClass("btn btn-outline-danger btn-sm");
			const file =$("<input>").attr("type", "file");
			file.attr("name", "productImage");
			file.addClass("form-control");
			
			button.click(function() {
				$(this).parent().remove();
			});
			
			div.append(label);
			div.append(button);
			div.append(file);
			
			$("form > div:last-child").before(div);
		});
		
		$("button.delete").click(function() {
			const code = $(this).data("code");   //코드값얻어옴        
			 
			$.ajax("../image/delete/" + code, {
				method: "GET",
				success: function(result) {        // success 콜백
					console.log(typeof(result));
					console.log(result);	
				
					if(result)                                 //this 누가 실행하는지 button 
						$("button.delete[data-code='" + code + "']").parent().remove();   //ajax이 센드되기 전에  
				},
				error: function(jpXhr, status) {
					console.log(status);
				}
			});
		});
		
	});
</script>
</head>
<body>
	<div class="container">
		<form method="post" enctype="multipart/form-data" class="mt-4">
		<div class="input-group mt-2">
			<label class="input-group-text col-2">제품명</label>
			<input type="text" name="name" class="form-control"  value="${item.name}">
		</div>
		<div class="input-group mt-2">
			<label class="input-group-text col-2">규격:</label>
			<input type="text"  name="spec" class="form-control"  value="${item.spec}">
		</div>
		<div class="input-group mt-2">
			<label class="input-group-text col-2">카테고리:</label>
			<input type="text"  name="category" class="form-control"  value="${item.category}">
		</div>
		<div class="input-group mt-2">
			<label class="input-group-text col-2">제조사:</label>	
			<input type="text"  name="manufacture" class="form-control"  value="${item.manufacture}">
			
		</div>
		<div class="input-group mt-2">
			<label class="input-group-text col-2">가격:</label>
			<input type="text" name="price" class="form-control" value="${item.price}">
		</div>
		<div class="mt-2">
			<label>제품설명:</label>
			<textarea id="summernote" name="info" rows="20" cols="80">${item.info}</textarea>
		</div>
		
		<div>
			<ul>
				<c:if test="${item.images == null || item.images.size() < 1}">   <!-- images 이미지리스트 -->
					<li>등록 된 제품이미지가 없습니다.</li>
				</c:if>
				<c:forEach var="image" items="${item.images}">
				<li>${image.filename} <button type="button" class="btn btn-sm btn-danger delete" data-code="${image.code}">삭제</button> </li>
				</c:forEach>
			</ul>
		</div>
		
		<div class="mt-2">
			<label>제품이미지: </label><span id="add_image" class="btn btn-outline-primary btn-sm">추가</span>
			<input type="file" name="productImage" class="form-control" >
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