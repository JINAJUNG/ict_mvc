<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>

<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">

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
				<c:if test="${empty miList}">
					<tr>
						<td colspan="7">데이터 없음</td>
					</tr>
				</c:if>
				<c:forEach var="mi" items="${miList}">
					<tr
						onclick="window.location='/member/memberView?minum=${mi.miNum}'">
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
				</c:forEach>

			</table>
			<div>
				<button class="btn btn-primary" data-page="/member/memberInsert">등록</button>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />