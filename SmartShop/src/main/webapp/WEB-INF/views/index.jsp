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
					 <span>${sessionScope.member.id}</span><span>�� ȯ��</span>
				</div>
				<div>
					<a href="logout">�α׾ƿ�</a>
				</div>
			</c:if>
			
			<c:if test="${sessionScope.member == null }">
		
			<div>
				<a href="login">�α���</a>
			</div>
			<div>
				<a href="signup">ȸ������</a>
			</div>
		</c:if>

	

	<ul>
		<li><a href="product/">��ǰ����</a></li>
		<li><a href="html/product.html/">��ǰ���� (AJAX)</a></li>
		<li><a href="partner/">�ŷ�ó ����</a></li>
		<li><a href="purchase/">�԰� ����</a></li>
		<li><a href="sales/">��� ����</a></li>
	</ul>
	</div>

</body>
</html>