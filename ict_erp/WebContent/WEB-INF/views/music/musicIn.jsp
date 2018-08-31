<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${musicIn.cnt eq 1}">
<script>
alert('등록 성공');
location.href='/music/musicList';
</script>
</c:if>

<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<form action="/music/musicIn" method="post">
				<table class="table table-bordered">
					<tr>
						<th>곡 제목</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>가수</th>
						<td><input type="text" name="singer"></td>
					</tr>
					<tr>
						<th>유통사</th>
						<td><input type="text" name="vendor"></td>
					</tr>
					<tr>
						<th>곡 설명</th>
						<td><input type="text" name="desc"></td>
					</tr>
					<tr>
						<td colspan="8"><button class="btn btn-primary">노래 등록</button></td>
					</tr>
				</table>

			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />