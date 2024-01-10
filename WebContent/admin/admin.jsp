<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div class="wrap">

	<div class="left-section">
		<div><a href="admin.do">회원조회</a></div>
		<div><a href="admin/productmanagement.do">상품관리</a></div>
	</div>
	<div class="right-section">
    	<h1 class="tabs-title" >회원 리스트</h1>
    	<form name=userSearchForm class="admin-search" method="get" action="usersearch.do">
    	<select name="type" style="padding:10px 20px;border-radius:30px;">
    		<option value="user_id">아이디</option>
    		<option value="user_name">이름</option>
    		<option value="user_email">이메일</option>
    	</select>
    	<input name="keyword" style="padding:10px 20px; border-radius:30px;" placeholder="Search..">
    	<span style="position:relative;
	right: 30px;"class="glyphicon glyphicon-search"></span>
    	</form>
    	 <table class="admin-table">
    <thead>
    	<tr style="border-bottom: 1px solid black;">
    		<th>회원번호</th>
    		<th>회원ID</th>
    		<th>회원이름</th>
    		<th>전화번호</th>
    		<th>이메일</th>
    		<th>주소</th>
    	</tr>
    </thead>
    <tbody>
    <c:set var="bno" value="${tot-((page.cri.pageNum - 1 )*10) }"/>
				<c:forEach var="list" items="${list }">
				<tr>
				<td>${list.user_no }</td>
    		<td>${list.user_id }</td>
   			<td>${list.user_name }</td>
    		<td>${list.user_phone }</td>
   			<td>${list.user_email }</td>
    		<td>${list.user_address }</td>
					
				</tr>
				<c:set var="bno" value="${bno-1}"/>
				</c:forEach>
    	
    	</tbody>
    	</table>
    	
    	<div class="paging">
		<c:if test="${page.prev }">
			<a href="$admin.do?pageNum=${page.startPage -1 }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"><span class="glyphicon glyphicon-chevron-left"></span></a>
		</c:if>	
		<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
			<a href="admin.do?pageNum=${num }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}" class="${page.cri.pageNum == num? 'active' : '' }">${num }</a>
		</c:forEach>
		<c:if test="${page.next }">
			<a href="admin.do?pageNum=${page.endPage +1}&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"><span class="glyphicon glyphicon-chevron-right"></span></a>
		</c:if>
		</div>
    	</div>
    </div>
</body>
</html>
<%@ include file="../footer.jsp" %>