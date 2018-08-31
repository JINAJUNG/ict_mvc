<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<c:if test="${musicDe.cnt eq 1}">
	<script>
		alert('삭제 성공');
		location.href = '/music/musicList';
	</script>
</c:if>

<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/menu/left.jsp" />
		<div id="page-content-wrapper">
			<form action="/music/musicDe" method="post">
				<table class="table table-bordered">
					<tr>
						<th>번호</th>
						<td>${music.mcNum}</td>

					</tr>
					<tr>
						<th>곡 제목</th>
						<td>${music.mcName}</td>
					</tr>
					<tr>
						<th>가수</th>
						<td>${music.mcSinger}</td>
					</tr>
					<tr>
						<th>유통사</th>
						<td>${music.mcVendor}</td>
					</tr>
					<tr>
						<th>좋아요</th>
						<td>${music.mcLike}</td>
					</tr>
					<tr>
						<th>싫어요</th>
						<td>${music.mcDisLike}</td>
					</tr>
					<tr>
						<th>업로드</th>
						<td>${music.mcCredate}</td>
					</tr>
					<tr>
					<th>곡 설명</th>
						<td>${music.mcDesc}</td>
					</tr>
					<tr>
						<td><button class="btn btn-success"
								data-page="/music/musicUp">노래 수정</button></td>
						<td><button class="btn btn-danger">노래
								삭제</button></td>
					</tr>
				</table>
				<input type="hidden" value="${music.mcNum}" name="mcNum">
			</form>

		</div>
	</div>
	<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />