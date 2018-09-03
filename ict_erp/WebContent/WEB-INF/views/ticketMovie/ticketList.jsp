<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<style>
img{
width: 150px;
height: auto;
}
</style>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<table class="table table-bordered">
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
				<c:forEach var="t" items="${tList}">
					<tr<%--  onclick="window.location='/music/musicView?mcNum=${t.tmNum}'" --%>>
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
				</c:forEach>
				<c:if test="${empty tList}">
					<tr>
						<td colspan="9">등록된 영화가 없는걸~?</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="9"><button class="btn btn-primary" data-page="/ticketMovie/ticketMovieInsert">영화 등록</button> </td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />