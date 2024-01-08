<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file= "/header.jsp" %>

	<div class="container-fluid">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="container-fluid subvisual ">
					<h2>자유게시판</h2>
				</div>
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<div class="container content">

		<div class="row">
			<div class="search_wrap">
				<div class="search_group">
					<form name="myform" method="get" action="board.do">
						<select name="type" class="select">
							<option value="board_title">제목</option>
							<option value="board_content">내용</option>
						</select> 
						<input type="text" name="keyword" class="search_word"> 
						<input type="hidden" name="pageNum" value="1">
						<input type="hidden" name="amount" value="${page.cri.amount }">
						<button  class="btn_search" type="submit" >
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</form>
				</div>
			</div>
			<div class="container-fluid boardList">
				<div class="bord_list">
					<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
						<caption class="sr-only">공지사항 리스트</caption>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="bno" value="${total - ((page.cri.pageNum -1)* 10)}" />
							<c:forEach var="list" items="${list}">
							<tr>
								<td>${bno}</td>
								<td class="title">
								<a href="boardview.do?board_no=${list.board_no}">${list.board_title}</a></td>
								<td>${list.board_writer}</td>
								<td>${list.board_date.substring(0,10)}</td>
								<td>${list.board_hits}</td>
							</tr>
							<c:set var="bno" value="${bno -1}" />
							</c:forEach>
						</tbody>
					</table>
						
					<div class="paging">
						
			<c:if test="${page.prev }">
				<a href="board.do?pageNum=${page.startPage-1 }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}">
					<i class="fa  fa-angle-double-left"></i>
				</a>
			</c:if>
			<c:forEach var="num" begin="${page.startPage }"
				end="${page.endPage }">
				<a
					href="board.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"
					class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
			</c:forEach>
			<c:if test="${page.next }">
				<a
					href="board.do?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}">
					<i class="fa fa-angle-double-right"></i>
				</a>
			</c:if>
			
				<button type="button" class="btn btn-primary btn-lg btn-block" 
				onclick="location.href='boardwrite.do'">글쓰기</button>
				
					</div>
				</div>
			</div>
		</div>
	</div>
	
<%@ include file = "/footer.jsp" %>
	