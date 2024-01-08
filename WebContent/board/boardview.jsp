<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<div class="container-fluid">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="container-fluid subvisual ">
				<h2>자유게시판</h2>
			</div>
		</div>
	</nav>
</div>

<div class="container">
	<div class="board_view">
		<h2>${view.board_title }</h2>
		<p class="info">
			<span class="user">${view.board_writer}</span> | ${view.board_date.substring(0,10) }| <i class="fa fa-eye">${view.board_hits}</i>
		</p>
		<div class="board_body">
			<p>${view.board_content }</p>
		</div>
		<!-- 위에가 list출력 -->
		
		<!-- 밑에부터 페이지 이동 기능 -->
		<div class="prev_next">
			<a href="boardview.do?board_no=${prev.getBoard_no() }" class="btn_prev">
			<i class="fa fa-angle-left"></i> 
			<span class="prev_wrap">
			 <strong>이전글</strong><span>${prev.getBoard_title() }</span>
			</span> </a>
			
			<div class="btn_3wrap">
				<a href="board.do">목록</a> 
				<a href="boardmodify.do?board_no=${view.board_no }">수정</a> 
				<a href="boarddelete.do?board_no=${view.board_no }" onClick="return confirm('삭제하시겠어요?')">삭제</a>
			</div>
			<a href="boardview.do?board_no=${next.getBoard_no() }" class="btn_next"> 
			<span class="next_wrap"> 
			<strong>다음글</strong><span>${next.getBoard_title() }</span>
			</span> 
			<i class="fa fa-angle-right"></i></a>
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


<%@ include file="/footer.jsp"%>