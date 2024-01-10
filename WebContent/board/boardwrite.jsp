<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ include file = "/header.jsp" %>
    
			<div class="container-fluid">
				<div class="container-fluid subvisual ">
					<h2>자유게시판 글쓰기</h2>
				</div>
			</div>


	<div class="container writeBox">
		<div class="write_wrap">
			<form name="board" method="post" action="boardinsert.do" onsubmit="return check()">
				<table class="bord_table">
					<colgroup>
						<col width="20%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr class="first">
							<th>글쓴이</th>
							<td><input type="text" name="writer"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td><input type="text" name="title"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea name="content" id="content"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="btn_wrap">
					<input type="submit" value="저장" class="btn_ok">
					<input type="reset" value="다시쓰기" class="btn_reset">
					<input type="button" value="목록" class="btn_list" onClick="location.href='board.do';">
				</div>
			</form>
		</div>
	</div>
	<!-- end contents -->
	<script>
		function check() {
			if (board.writer.value == "") {
				alert("글쓴이 입력");
				board.writer.focus();
				return false;
			}
			if (board.title.value == "") {
				alert("제목을 입력");
				board.title.focus();
				return false;
			}
			if (board.content.value == "") {
				alert("내용을 입력");
				board.content.focus();
				return false;
			}
			var content = document.getElementById("content");
			board.content.value = content.value.replace(/(\n|\r\n)/g, '<br>');
			return true;
		}
	</script>
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click", function(e) {
				e.preventDefault();
				if ($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>
    
    <%@ include file ="/footer.jsp" %>