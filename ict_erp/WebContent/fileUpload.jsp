<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>업로드 테스트</title>
</head>
<body>
	<form action="/fu/upload" enctype="multipart/form-data" method="post">
		업로더 : <input type="text" name="upName"><br> 성별 : <select
			name="upTrans">
			<option value="1">남</option>
			<option value="2">여</option>
		</select><br>
		나이 : <input type="number" name="upAge"><br>
		생일 : <input type="date" name="upBirth"><br>
		취미 : 영화<input type="checkbox" name="upHobby" value="movie"><br>
		자기소개 : <textarea name="upDesc"></textarea><br>
		 파일 : <input type="file" name="upFile"><br>
		<button>전송</button>
		
	</form>
</body>
</html>