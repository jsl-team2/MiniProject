<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="wrap">
	<div class="right-section">
		<h1 class="tabs-title">個人注文履歴</h1>
		<%-- <div><p><span>${tot }</span> 個</p></div> --%>
		<table class="admin-table product">
			<thead>
				<tr>
					<th>
						<p class="columns">番号</p>
					</th>
					<th>
						<p class="columns">注文者</p>
					</th>
					<th>
						<p class="columns">電話番号</p>
					</th>
					<th>
						<p class="columns">住所</p>
					</th>
					<th>
						<p class="columns">注文日</p>
					</th>
					<th>
						<p class="columns">状態</p>
					</th>
					<th>
						<p class="columns">注文詳細</p>
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}" varStatus="loopStatus">
					<tr>
						<td>${list.order_no}</td>
						<td>${list.order_user}</td>
						<td>${list.order_tel}</td>
						<td>${list.order_address}</td>
						<td>${list.order_date}</td>
						<td>${list.order_status}</td>
						<td><a href="myorderdetail.do?order_no=${list.order_no}" class="btn btn-default" role="button">注文詳細</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging" style="margin-bottom:50px;">
				<c:if test="${page.prev }">
					<a href="myorder.do?pageNum=${page.startPage-1 }&amount=${page.cri.amount}&type=${page.cri.type}">
						<i class="fa  fa-angle-double-left"></i></a>
				</c:if>
				<c:forEach var="num" begin="${page.startPage }"
					end="${page.endPage }">
					<a href="myorder.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}"
						class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
				</c:forEach>
				<c:if test="${page.next }">
					<a href="myorder.do?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&type=${page.cri.type}">
						<i class="fa fa-angle-double-right"></i></a>
				</c:if>
			</div>
	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp"%>