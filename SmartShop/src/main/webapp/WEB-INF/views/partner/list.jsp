<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<jsp:include page="../include/header.jsp"></jsp:include>
</head>
<body>

	<div class="container-fluid">
		<h3>거래처 목록</h3>
		<div class="mb-2">
			<form class="row">
			<div class="col-6"></div>    <!-- 그리드 12 -->
			<div class="col-auto">
				<select name="search" class="form-select">
					<option value="0">검색항목</option>
					<option value="1" ${pager.search == 1 ? 'selected' : ''}>코드</option>
					<option value="2" ${pager.search == 2 ? 'selected' : ''}>거래처</option>
					<option value="3" ${pager.search == 3 ? 'selected' : ''}>전화번호</option>
					<option value="4" ${pager.search == 4 ? 'selected' : ''}>주소</option>
				</select>
			</div>
				
				<div class="col-auto">
				<input type="text" name="keyword" value="${pager.keyword}" class="form-control">
				</div>
				
				<div class="col-auto">
				<button class="btn btn-dark">검색</button>
				</div>
				
			</form>
		</div>
		<div>
			<table border="1" class="table table-sm">
				<thead class="table-dark">
					<tr>
						<td>코드</td>
						<td>거래처</td>
						<td>전화번호</td>
						<td>주소</td>
						<td>관리</td>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.code}</td>
						<td>${item.name}</td>
						<td>${item.tel}</td>
						<td>${item.address}</td>
						<td><a href="delete/${item.code}" class="btn btn-sm btn-danger">삭제</a> <a href="update/${item.code}" class="btn btn-sm btn-primary">변경</a></td>
					</tr>
				</c:forEach>
							
				<c:if test="${list.size() < 1}">
					<tr>
						<td colspan="5">등록된 거래처가 없습니다</td>
					</tr>
				</c:if>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="7">
						<div class="pagination justify-content-center">
							<div class="page-item"><a href="?page=1&${pager.query}" class="page-link">처음</a></div>
							<div class="page-item"><a href="?page=${pager.prev}&${pager.query}" class="page-link">이전</a></div>
							
							<c:forEach var="page" items="${pager.list}">
							<div class="page-item ${page == pager.page ? 'active' : '' }"><a href="?page=${page}&${pager.query}" class="page-link">${page}</a></div>
							</c:forEach>
							
							<div class="page-item"><a href="?page=${pager.next}&${pager.query}" class="page-link">다음</a></div>
							<div class="page-item"><a href="?page=${pager.last}&${pager.query}" class="page-link">마지막</a></div>
						</div>
						</td>
					</tr>					
				</tfoot>
				
			</table>
		</div>
		<div>
			<a href="add" class="btn btn-sm btn-primary">등록</a>
			<a href="dummy" class="btn btn-sm btn-info">대량등록</a>
			<a href="init" class="btn btn-sm btn-danger">초기화</a>
			<a href=".." class="btn btn-sm btn-primary">이전 메뉴</a>
		</div>
		
	</div>

<jsp:include page="../include/body.jsp"></jsp:include>
</body>
</html>