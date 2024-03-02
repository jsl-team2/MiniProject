<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  // 사용자 정보 가져오기
  String user = (String) session.getAttribute("user_id"); // 여기서 "user"는 세션에 저장된 사용자 정보 객체의 키일 수 있습니다.

  // 로그인 여부 확인
  boolean LoginID = (user != null);
%>


<%@ include file= "/header.jsp" %>

	<div class="container-fluid">
		<nav class="container-fluid navbar navbar-default">
				<div class="board_subvisual ">
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<div class="container board_content">

		<div class="row">
			<div class="search_wrap">
				<div class="board_search_group">
					<form name="myform" method="get" action="board.do">
						<select name="type" class="select">
							<option value="board_title">件名</option>
							<option value="board_content">内容</option>
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
			<div class="container boardList">
				<div class="bord_list">
					<table class="bord_table">
						<thead>
							<tr>
								<th>No</th>
								<th>件名</th>
								<th>投稿者</th>
								<th>作成日</th>
								<th>ヒット数</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="bno" value="${total - ((page.cri.pageNum -1)* 10)}" />
							<c:forEach var="Blist" items="${Blist}">
							<tr>
								<td>${bno}</td>
								<td class="title" >
								<a href="boardview.do?board_no=${Blist.board_no}&bno=${bno}">${Blist.board_title}</a></td>
								<td>${Blist.board_writer}</td>
								<td>${Blist.board_date.substring(0,10)}</td>
								<td>${Blist.board_hits}</td>
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
			
			<c:forEach var="num" begin="${page.startPage }"	end="${page.endPage }">
				<a href="board.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"
					class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
			</c:forEach>
			
			<c:if test="${page.next }">
				<a href="board.do?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}">
					<i class="fa fa-angle-double-right"></i>
				</a>
			</c:if>
			<button type="button" class="btn btn-primary btn-lg btn-block" 
				onclick="checkLoginAndRedirect('boardwrite.do')">作成</button>
		</div>			
				
				
					</div>
				</div>
			</div>
		</div>
	
<%@ include file = "/footer.jsp" %>

<script>
    function checkLoginAndRedirect(destination) {
        // 여기에 세션에서 로그인 여부를 확인하는 코드를 추가
        var user_id = <%=LoginID%>;
        
        if (user_id) {
            // 로그인된 경우
            location.href = destination;
        } else {
            // 로그인되지 않은 경우
            alert('ロクインが必要です。');
            // 또는 다른 방식으로 사용자에게 알림을 제공하거나 로그인 페이지로 이동할 수 있습니다.
            // location.href = 'login.do'; // 로그인 페이지로 이동
        }
    }
</script>
	