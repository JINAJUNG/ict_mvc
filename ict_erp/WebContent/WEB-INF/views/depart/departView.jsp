<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${map.cnt eq 1 }">
<script>
alert('${map.msg}');
location.href='/depart/departList';
</script>
</c:if>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<form action="/depart/departUpdate" method="post">
				<table class="table table-bordered">
					<tr>
						<th>번호</th>
						<th>코드</th>
						<th>이름</th>
						<th>설명</th>
					</tr>
					<c:set var="di" value="${diOne}"></c:set>
					<tr>
						<td><input type="hidden" name="diNum" value="${di.diNum}">${di.diNum}</td>
						<td><input type="text" name="diCode" value="${di.diCode}"></td>
						<td><input type="text" name="diName" value="${di.diName}"></td>
						<td><input type="text" name="diDesc" value="${di.diDesc}"></td>
					</tr>
					<tr>
						<td colspan="2"><button class="btn btn-primary">수정</button></td>
						<td colspan="2"><button class="btn btn-primary"
								data-action="/depart/departDelete">삭제</button></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />