<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>

	<div class="container">
		<div>
			<label>제품번호:</label>
			<span>${item.code}</span>
		</div>
		<div>
			<label>제품명:</label>
			<span>${item.name}</span>
		</div>
		<div>
			<label>제품규격:</label>
			<span>${item.spec}</span>
		</div>
		<div>
			<label>카테고리:</label>
			<span>${item.category}</span>
		</div>
		<div>
			<label>제조사:</label>
			<span>${item.manufacture}</span>
		</div>
		<div>
			<label>가격:</label>
			<span>${item.price}</span>
		</div>
		<div>
			<label>제품설명:</label>
		</div>
		
		<div>
			<ul>
				<c:if test="${item.images == null || item.images.size() < 1}">   <!-- images 이미지리스트 -->
					<li>등록 된 제품이미지가 없습니다.</li>
				</c:if>
				<c:forEach var="image" items="${item.images}">
				<li><img src="/upload/${image.uuid}_${image.filename}"/></li>
				</c:forEach>
			</ul>
		</div>
		
		<div>
			<a href="..">목록</a>
		</div>
	</div>
	
<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>