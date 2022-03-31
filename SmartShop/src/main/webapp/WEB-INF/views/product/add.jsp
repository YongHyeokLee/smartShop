<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		
	});
</script>

</head>
<body>
	<div class="container">
		<form method="post" enctype="multipart/form-data" class="mt-4">
		<div class="form-floating mt-2">
			<input type="text" name="name" class="form-control" placeholder="제품명">
			<label>제품명</label>
		</div>
		<div class="form-floating mt-2">
			<input type="text" name="spec" class="form-control" placeholder="규격">
			<label>규격:</label>
		</div>
		<div class="form-floating mt-2">
			<input type="text" name="category" class="form-control" placeholder="카테고리">
			<label>카테고리:</label>
		</div>
		<div class="form-floating mt-2">
			
			<input type="text" name="manufacture" class="form-control" placeholder="제조사">
			<label class="form-label">제조사:</label>
		</div>
		
		<div class="form-floating mt-2">
			<input type="text" name="price" class="form-control" placeholder="가격">
			<label>가격:</label>
		</div>
		
		<div class="mt-2">
			<label>제품설명:</label>
			<textarea id="summernote" name="info" rows="20" cols="80"></textarea>
		</div>
		
		
		<div class="mt-2">
			<label>제품이미지: </label><span id="add_image" class="btn btn-outline-primary btn-sm">추가</span>
			<input type="file" name="productImage" class="form-control" >
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