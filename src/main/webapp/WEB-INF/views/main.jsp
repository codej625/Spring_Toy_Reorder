<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>Board</title>
<style type="text/css">
#write{
	text-align: right;
}

#footer {
	padding: 15px;
	overflow: auto;
}

.table {
	width: 383.322px;
	margin-left: auto;
	margin-right: auto;
	margin-top: auto;
}

.num:hover {
	color: aqua;
}

#reorder {
	color: #ff2f3b;
}

#comment {
	float: left;
}

#menu {
	float: right;
}

.btn {
	margin: 5px !important;
}

</style>
</head>
<body>
	<div class="table">
		<table class="table" border="1">
			<tr>
				<td>NO</td>
				<td>TITLE</td>
			</tr>
			<c:forEach var="item" items="${list}">
				<tr>
					<td class="num" data-target="#layerpop" data-toggle="modal" no="${item.no}">${item.no}</td>
					<td>${item.title} <span id="reorder">[${item.reorder}]</span></td>
				</tr>
			</c:forEach>
		</table>
		<div id="write">
			<a href="/write">글쓰기</a>
		</div>
	</div>
	
	<!-- bootstrap modal div -->
	<!-- <button class="btn btn-default" data-target="#layerpop" data-toggle="modal">버튼ver</button> -->
	<div class="modal fade" id="layerpop">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- modal header -->
				<div class="modal-header">
					<!-- 닫기(X) 버튼 -->
					<button type="button" class="close" data-dismiss="modal">X</button>
					<!-- modal header title -->
					<h4 class="modal-title"></h4>
				</div>
				<!-- modal body -->
				<div id="body" class="modal-body"></div>
				<!-- modal footer -->
<!-- 			<div class="modal-footer"> -->
<!-- 				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button> -->
<!-- 			</div> -->
				<div id="footer">
				
				</div>
				<div id="comment-body">
				
				</div>
			</div>
		</div>
	</div>
	
<!-- 	<button id="" delete="" onclick="();"></button> -->
<!-- 	<input id="delete" type="hidden"> -->

	<script type="text/javascript">
		$('.num').click(function() {
			const num = $(this).attr('no');

			$.ajax({
				url : '/content',
				type : 'GET',
				data : {'no' : num},
				dataType : 'json',
				success : function onData(res) {
					const title = res.content.title
					const no    = res.content.no
					let   btn   = "<span id='comment'><button id='comment-btn' class='btn'>댓글</button></span>"
						  btn  += "<span id='menu'><button id='update-btn' class='btn'>수정</button>";
						  btn  += "<button id='delete-btn' class='btn'>삭제</button></span>";
					let   html  = "<table class='table' border='1'>";
						  html += "<tr><td>" + res.content.contents + "</td></tr>";
					      html += "</table>";
					$(".modal-title").html(title);
					$("#body").html(html);
					$("#footer").html(btn);
					
					$('#comment-body').hide();
					$('#comment-btn').click(function() {
						if($('#comment-body').css('display') == 'none'){
							// test 중
							let html  = "<table class='table' border='1'>";
							    html += "<tr><td>" + no + "</td></tr>";
							    html += "</table>";
							$('#comment-body').html(html);
							
							// 1.일반적인 display show
							// $('#comment-body').show();
							
							// 2.부드러운 display show 
							$('#comment-body').slideDown();
					      }else{
					        $('#comment-body').hide();
					      }
						// 게시판(PK) 가져오기
					});
				},
				error : function onError(error) {
					console.error(error);
				}
			});
		});
	</script>
	<script type="text/javascript">
		$(document).ready(function() {
			const resp = ${result};
			if (resp != null) {
				alert('글쓰기 입력 성공')
			}
		});
	</script>
	
</body>
</html>