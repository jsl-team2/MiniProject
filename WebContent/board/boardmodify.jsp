<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "/header.jsp"%>

<div class="sub_title">
		<div class="container">
		</div><!-- container end -->
	</div>

	<div class="container">
	  <div class="write_wrap">
	  <form name="board" method="post" action="boardmodifypro.do" onsubmit="return check()">
	  <input type="hidden" name="board_no" value="${view.board_no }">
	  <!-- action을 처리하기전에 check()사용자 함수를 실행하고 되돌아 와라-->
			<table class="bord_modifytable">
				<caption class="sr-only">공지사항 입력 표</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
				</colgroup>
				<tbody>
					<tr class="first">
						<th style="color: #333;">投稿者</th>
						<td><input type="text" name="writer" readonly value="${user_id}"></td>
					</tr>
					<tr>
						<th style="color: #333;">タイトル</th>
						<td><input type="text" name="title" value="${view.board_title }"></td>
					</tr>
					<tr>
						<th style="color: #333;">内容</th>
						<td><textarea name="content" id="summernote" class="summernote">${view.board_content }</textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="btn_wrap">
				<input type="reset" value="リセット" class="board_reset">
				<input type="submit" value="保存" class="board_ok">
				<input type="button" value="リスト" class="board_list" onClick="location.href='board.do';">
			</div>
		</form>
	  </div>
	  
	</div>
	<!-- end contents -->
	<script>
		function check() {
			if(board.writer.value=="") {
				alert("投稿者を入力してください。");
				board.writer.focus();
				return false;
			}
			if(board.title.value=="") {
				alert("タイトルを入力してください。");
				board.title.focus();
				return false;
			}
			if(board.content.value=="") {
				alert("内容を入力してください。");
				board.content.focus();
				return false;
			}
			alert("修正を完了しました。")
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
	
	<script>
  $('.summernote').summernote({
      height: 300,
      minHeight: null,
      maxHeight: null,
      lang : 'ko-KR',
      onImageUpload: function(files, editor, welEditable) {
              sendFile(files[0], editor, welEditable);
          }
  });
</script>

<%@ include file = "/footer.jsp"%>