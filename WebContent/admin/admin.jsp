<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div class="admin__wrap">

	<div class="left-section">
		<div><a href="admin.do">会員照会</a></div>
		<div><a href="productmanagement.do">商品管理</a></div>
		<div><a href="adminorder.do">全体注文内訳</a></div>
	</div>
	<div class="right-section">
    	<h1 class="tabs-title" >会員リスト</h1>
    	<form name=userSearchForm class="admin-search" method="get" action="usersearch.do">
    	<select class="select-tag form-control" name="type">
    		<option value="user_id">会員ID</option>
    		<option value="user_name">会員名</option>
    		<option value="user_email">email</option>
    	</select>
    	<input class="search-tag form-control" name="keyword" placeholder="Search..">
    	<span class="search-icon glyphicon glyphicon-search"></span>
    	</form>
    	 <table class="admin-table">
    <thead>
    	<tr style="border-bottom: 1px solid black;">
    		<th>会員番号</th>
    		<th>会員ID</th>
    		<th>会員名</th>
    		<th>電話番号</th>
    		<th>email</th>
    		<th>住所</th>
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