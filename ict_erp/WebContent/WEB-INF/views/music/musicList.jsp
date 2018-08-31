<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<table class="table table-bordered">
				<tr>
					<th>번호</th>
					<th>곡 제목</th>
					<th>가수</th>
					<th>유통사</th>
					<th>좋아요</th>
					<th>싫어요</th>
					<th>업로드</th>
					<th>곡 설명</th>
				</tr>
				<c:forEach var="music" items="${musicList}">
					<tr onclick="window.location='/music/musicView?mcNum=${music.mcNum}'">
						<td>${music.mcNum}</td>
						<td>${music.mcName}</td>
						<td>${music.mcSinger}</td>
						<td>${music.mcVendor}</td>
						<td>${music.mcLike}</td>
						<td>${music.mcDisLike}</td>
						<td>${music.mcCredate}</td>
						<td>${music.mcDesc}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty musicList}">
					<tr>
						<td colspan="8">등록된 노래가 없는걸~?</td>
					</tr>
				</c:if>
				<tr>
					<td colspan="8"><button class="btn btn-primary" data-page="/music/musicIn">노래 등록</button> </td>
				</tr>
			</table>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />