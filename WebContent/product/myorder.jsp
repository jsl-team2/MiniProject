<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="wrap">

	<div class="left-section">
		<div>
			<a href="admin.do">회원조회</a>
		</div>
		<div>
			<a href="admin/productmanagement.do">상품관리</a>
		</div>
		<div>
			<a href="myorder.do">주문내역</a>
		</div>
	</div>
	<div class="right-section">
		<h1 class="tabs-title">주문내역</h1>
		<table class="admin-table">
			<caption class="sr-only">주문내역</caption>
			<colgroup>
				<col width="12%">
				<col width="10%">
				<col width="17%">
				<col width="*%">
				<col width="12%">
				<col width="10%">
				<col width="12%">
			</colgroup>
			<thead>
				<tr>
					<th>
						<p class="columns">注文番号</p>
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
						<td><a href="myorderdetail.do?order_no=${list.order_no}">注文詳細</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp"%>