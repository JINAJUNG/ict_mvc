<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
	<table class="table table-bordered">
	<tr>
		<th>번호</th>
		<th>코드</th>
		<th>이름</th>
		<th>설명</th>
	</tr>
	<c:set var="di" value="${diOne}"></c:set>
	<tr>
		<th>${di.diNum}</th>
		<th>${di.diCode}</th>
		<th>${di.diName}</th>
		<th>${di.diDesc}</th>
	</tr>
	</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />