<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<c:set var="dl" value="${diList}" />
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>번호</th>
						<th>부서코드</th>
						<th>부서이름</th>
						<th>부서설명</th>
						<th><input type="checkbox" id="chAll"></th>
					</tr>
				</thead>
				<tbody id='diTbody'>
					<c:forEach items="${diList}" var="di">
							<tr onclick="goPage(${di.diNum})">
								<td>${di.diNum}</td>
								<td>${di.diCode}</td>
								<td>${di.diName}</td>
								<td>${di.diDesc}</td>
								<td><input type="checkbox"></td>
							</tr>
					</c:forEach>
					<c:if test="${empty diList}">
						<tr>
							<td colspan="5">레벨이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<div class="btn">
				<button data-page="/views/depart/departInsert"> 등록</button>
			</div>
			<jsp:include page="/WEB-INF/views/common/block.jspf"></jsp:include>
		</div>
	</div>
	<script>
		function goPage(diNum){
			location.href='<%=rPath%>/depart/departView?diNum=' + diNum;
		}
	</script>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />
	