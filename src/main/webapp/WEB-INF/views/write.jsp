<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/webjars/jquery/dist/jquery.min.js"></script>
<title>write</title>
</head>
<body>
<form id="fromWrite" action="/write" method="post" onsubmit="return check();">
	<table>
		<tr>
			<td>글쓰기</td>
		</tr>
		<tr>
			<td>제목<input type="text" name="title"></td>
			<td>내용<input type="text" name="contents"></td>
		</tr>
		<tr>
			<td><input type="submit" value="저장"></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
// 	$("#no").keyup(function() {
// 		if (isNaN(fromWrite.no.value)) {
// 			$("#no").val("");
// 			return false;
// 		}
// 		return true;
// 	});
// 	function check() {
// 		var num = $("#no").val();
// 		if (num == 0) {
// 			alert("번호 입력해주세요")
// 			return false;
// 		}
// 		return true;
// 	}
</script>
</body>
</html>