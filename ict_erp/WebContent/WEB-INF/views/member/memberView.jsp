<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${!empty rMap}">
	<script>
alert('${rMap.msg}');
if(${rMap.cnt}==1){
	location.href='/member/memberList';
}
</script>
</c:if>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<form action="/member/memberDelete" method="post">
				<table class="table table-bordered table-hover">
					<tr>
						<th>번호</th>
						<th>아이디</th>
						<th>이름</th>
						<th>부서코드</th>
						<th>레벨</th>
						<th>이메일</th>
						<th>사원비고</th>
						<th>핸드폰</th>
						<th>지번코드</th>
						<th>주소1</th>
						<th>주소2</th>
					</tr>

					<c:set var="mi" value="${mi}"></c:set>
					<tr>
						<td>${mi.miNum}</td>
						<td>${mi.miName}</td>
						<td>${mi.miId}</td>
						<td>${mi.diName}</td>
						<td>${mi.liName}</td>
						<td>${mi.miEmail}</td>
						<td>${mi.miDesc}</td>
						<td>${mi.miPhone}</td>
						<td>${mi.miZipcode}</td>
						<td>${mi.miAddress1}</td>
						<td>${mi.miAddress2}</td>
					</tr>
					<tr>
						<td colspan="6"><button data-page="/member/memberUpdate?miNum=${mi.miNum}">수정</button></td>
						<td colspan="5"><button>삭제</button></td>
					</tr>
				</table>
				<input type="hidden" name="miNum" value="${mi.miNum}">
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />