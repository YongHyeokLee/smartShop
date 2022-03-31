<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title></title>
</head>
<body>
<jsp:include page="include/header.jsp"></jsp:include>

<div>

	<div>
	<c:if test="${msg != null}">
		<div><h3>${msg}</h3></div>
	</c:if>
	</div>
	
	<c:if test="${sessionScope.member != null }">
				<div>
					 <span>${sessionScope.member.id}</span><span>님 환영</span>
				</div>
				<div>
					<a href="logout">로그아웃</a>
				</div>
			</c:if>
			
			<c:if test="${sessionScope.member == null }">
		
			<div>
				<a href="login">로그인</a>
			</div>
			<div>
				<a href="signup">회원가입</a>
			</div>
		</c:if>

	

	<ul>
		<li><a href="product/">제품관리</a></li>
		<li><a href="html/product.html/">제품관리 (AJAX)</a></li>
		<li><a href="partner/">거래처 관리</a></li>
		<li><a href="purchase/">입고 관리</a></li>
		<li><a href="sales/">출고 관리</a></li>
	</ul>
	</div>

</body>
</html>