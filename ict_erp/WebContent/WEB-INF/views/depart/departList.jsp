<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>dino</th>
						<th>dicode</th>
						<th>diname</th>
						<th>didesc</th>
						<th><input type="checkbox" id="chAll"></th>
					</tr>
				</thead>
				<tbody id='diTbody'>
					<c:forEach items="${diList}" var="di">
						<tr>
							<td>${di.diNum}</td>
							<td><input type="number" value="${di.diCode}" name="uliLevel"></td>
							<td><input type="text" value="${di.liName}" name="uiName"></td>
							<td><input type="text" value="${di.liDesc}" name="uiDesc" onchange=""></td>
							<td><input type="checkbox" name="liNum" value="${di.liNum}"></td>
						</tr>
					</c:forEach>
					<c:if test="${empty liList}">
						<tr>
							<td colspan="5">레벨이 없습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
	<c:set var ="dl" value="${diList}"/>
	${diList}
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />