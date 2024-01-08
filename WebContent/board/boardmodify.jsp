<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "/header.jsp"%>

<div class="sub_title">
		<h2>공지사항</h2>
		<div class="container">
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <h2 class="sr-only">공지사항 글쓰기</h2>
	  <form name="board" method="post" action="boardmodifypro.do" onsubmit="return check()">
	  <input type="hidden" name="board_no" value="${view.board_no }">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_table">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th>글쓴이</th>
						<td><input type="text" name="writer" readonly value="${view.board_writer }"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" value="${view.board_title }"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea name="content">${view.board_content }</textarea></td>
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
			if(board.writer.value=="") {
				alert("글쓴이 입력");
				board.writer.focus();
				return false;
			}
			if(board.title.value=="") {
				alert("제목을 입력");
				board.title.focus();
				return false;
			}
			if(board.content.value=="") {
				alert("내용을 입력");
				board.content.focus();
				return false;
			}
			alert("수정완료")
			return true;
			
		}
	</script>
	<script>
		$(function() {
			$(".location  .dropdown > a").on("click",function(e) {
				e.preventDefault();
				if($(this).next().is(":visible")) {
					$(".location  .dropdown > a").next().hide();
				} else {
					$(".location  .dropdown > a").next().hide();
					$(this).next().show();
				}
			});
		});
	</script>

<%@ include file = "/footer.jsp"%>