<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<style>
img{
width: 150px;
height: auto;
}
</style>
<c:if test="${!empty rMap}">
	<script>
alert('${rMap.msg}');
if(${rMap.cnt}==1){
	location.href='/ticketMovie/ticketList';
}
</script>
</c:if>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<form action="/ticketMovie/deleteTicket" method="post">
				<table class="table table-bordered table-hover">
					<tr>
					<th>번호</th>
					<th>영화 제목</th>
					<th>영화 가격</th>
					<th>시작일</th>
					<th>종료일</th>
					<th>배급날짜</th>
					<th>영화 설명</th>
					<th>관객 수</th>
					<th>포스터</th>
					</tr>

					<c:set var="t" value="${tm}"></c:set>
					<tr>
						<td>${t.tmNum}</td>
						<td>${t.tmName}</td>
						<td>${t.tmPrice}</td>
						<td>${t.tmStartDat}</td>
						<td>${t.tmEndDat}</td>
						<td>${t.tmCreDat}</td>
						<td>${t.tmDesc}</td>
						<td>${t.tmCnt}</td>
						<td><img src="${t.tmImg}"></td>
					</tr>
					<tr>
						<td colspan="6"><button data-page="/ticketMovie/ticketUpdate?tiNum=${t.tmNum}">수정</button></td>
						<td colspan="5"><button>삭제</button></td>
					</tr>
				</table>
				<input type="hidden" name="tmNum" value="${t.tmNum}">
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />