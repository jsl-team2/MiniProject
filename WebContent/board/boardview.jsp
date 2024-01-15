<%@page import="java.util.ArrayList"%>
<%@page import="dao.CommentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<div class="container-fluid subvisual ">
	<h2>자유게시판</h2>
</div>

<div class="container">
	<div class="board_view">
		<h2>${view.board_title }</h2>
		<p class="info">
			<span class="user">${view.board_writer}</span> |
			${view.board_date.substring(0,10) }| <i class="fa fa-eye">${view.board_hits}</i>
		</p>
		<div class="board_body">
			<p>${view.board_content }</p>
		</div>
		<!-- 위에가 list출력 -->

		<!-- 밑에부터 페이지 이동 기능 -->
		<div class="prev_next">
			<a href="boardview.do?board_no=${prev.getBoard_no() }"
				class="btn_prev"> <i class="fa fa-angle-left"></i> <span
				class="prev_wrap"> <strong>이전글</strong><span>${prev.getBoard_title() }</span>
			</span>
			</a>

			<div class="btn_3wrap">
				<a href="board.do">목록</a> <a
					href="boardmodify.do?board_no=${view.board_no }">수정</a> <a
					href="boarddelete.do?board_no=${view.board_no }"
					onClick="return confirm('삭제하시겠습니까?')">삭제</a>
			</div>
			<a href="boardview.do?board_no=${next.getBoard_no() }"
				class="btn_next"> <span class="next_wrap"> <strong>다음글</strong><span>${next.getBoard_title() }</span>
			</span> <i class="fa fa-angle-right"></i></a>
		</div>
	</div>
</div>

<!-- 댓글 기능 시작  -->
<div class="container commentarea" style="padding-bottom: 35px;">
	<div class="list_area" style="padding-bottom: 35px;">
		<table style="width: 100%;">
			<thead>
				<tr>
					<th>아이디</th>
					<th>댓글</th>
					<th>날짜</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="Clist" items="${Clist }">
					<tr>
						<td>${Clist.comment_id}</td>
						<td>${Clist.comment_content}</td>
						<td>${Clist.comment_createdate.substring(0,10) }</td>
						<td><div class="col-sm-2" style="padding-right: 40px;">
								<button class="btn btn-sm modifybtn"
									onclick="openModal('id_reply_edit_modal_${Clist.comment_no}')"
									style="color: #fff; border-color: #fff; background: #007dc6">수정</button>
							</div>
							<div class="col-sm-2">
								<a type="submit" class="btn btn-sm btn-info" role="button"
									style="background-color: #FF6A89; color: #fff; border-color: #fff;"
									href="commentdelete.do?comment_no=${Clist.comment_no}&board_no=${Clist.board_no}">삭제</a>
							</div> 
							
							<!-- START : 댓글 수정용 Modal -->
							<div class="modal" id="id_reply_edit_modal_${Clist.comment_no}">
								<div class="modal-dialog">
									<!-- Modal content-->
									<div class="modal-content">
										<form name="commentmodify" action="commentmodify.do"
											method="post" onsubmit="return check2();">

											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"></button>
												<h4 class="modal-title">댓글수정</h4>
											</div>

											<div class="modal-body">
												<input type="hidden" name="comment_no"
													value="${Clist.comment_no }">
												<textarea rows="3" name="reContent" class="form-control">${Clist.comment_content }</textarea>
												<input type="hidden" name="reMemId" value="mini14">
												<input type="hidden" name="board_no"
													value="${Clist.board_no}"> <input type="hidden"
													name="redate" value="${Clist.comment_createdate }">
												<input type="hidden" id="selectedValueHidden"
													name="selectedValueHidden" value=""> <input
													type="hidden" id="selectedOrderNo" name="selectedOrderNo"
													value="${Clist.comment_no}">
											</div>

											<div class="modal-footer">
												<button id="btn_reply_modify" type="submit"
													class="btn btn-sm btn-info">저장</button>
												<button type="button" class="btn btn-default btn-sm"
													onclick="closeModal()">닫기</button>
											</div>
										</form>
									</div>
								</div>
							</div> <!-- END : 댓글 수정용 Modal --></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div class="panel panel-default">
		<div class="panel-body form-horizontal">
			<form name="commentList" action="commentinsert.do" method="post"
				onsubmit="return check();">
				<input type="hidden" name="board_no" value="${view.board_no }">
				<input type="hidden" name="comment_id" value="mini14">

				<div class="form-group">
					<label class="col-sm-2  control-label"
						style="padding-top: 30px; text-align: center;">댓글</label>
					<div class="col-sm-8">
						<textarea rows="3" name="content" class="form-control"></textarea>
					</div>
					<div class="col-sm-2">
						<button id="comment_regist" type="submit"
							class="btn btn-sm btn-list1"
							style="font-size: 15px; background: #007dc6;">등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>



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

<script>
	function check() {
		if (commentList.Content.value == "") {
			alert("댓글을 입력하시오.");
			commentList.Content.focus();
			return false;
		}

		var content = document.getElementById("content");
		commentList.content.value = content.value.replace(/(\n|\r\n)/g, '<br>');
		return true;
	}
</script>

<script>
	function check2() {
		if (commentmodify.reContent.value == "") {
			alert("수정내용을 입력하시오.");
			commentmodify.reContent.focus();
			return false;
		}

		var content = document.getElementById("reContent");
		commentmodify.reContent.value = content.value.replace(/(\n|\r\n)/g,
				'<br>');
		return true;
	}
</script>

<script>
	var selectedOrderNo; // 모달을 열 때 선택된 주문 번호를 저장할 변수

	function openModal(modalId) {
		selectedOrderNo = modalId; // 선택된 모달 ID 저장
		document.getElementById(modalId).style.display = "block";
	}

	function closeModal() {
		document.getElementById(selectedOrderNo).style.display = "none";
	}
</script>



<%@ include file="/footer.jsp"%>