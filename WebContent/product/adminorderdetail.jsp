<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="wrap">
	<div class="left-section">
		<div>
			<a href="admin.do">会員照会</a>
		</div>
		<div>
			<a href="admin/productmanagement.do">商品管理</a>
		</div>
		<div>
			<a href="adminorder.do">全体注文内訳</a>
		</div>
	</div>
	<div class="right-section">
		<h1 class="tabs-title">注文内訳</h1>
		<table class="admin-table">
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
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${vo.order_no}</td>
					<td>${vo.order_user}</td>
					<td>${vo.order_tel}</td>
					<td>${vo.order_address}</td>
					<td>${vo.order_date}</td>
					<td>${vo.order_status}</td>
				</tr>
			</tbody>
		</table>
		<table class="admin-table product"
			style="margin-top: -30px; text-align: center;">
			<tbody>
				<c:forEach var="list" items="${list}" varStatus="loopStatus">
					<tr>
						<td><img src="images/product/${list.orderdetail_picture}"
							alt="" style="width: 80px; height: auto;"></td>
						<td>${list.orderdetail_product}</td>
						<td>${list.orderdetail_quantity}</td>
						<fmt:formatNumber value="${list.orderdetail_price}"
							pattern="#,##0" var="formattedPrice" />
						<td>${formattedPrice}￥</td>
					</tr>
					<c:set var="totalPrice" value="${totalPrice + list.orderdetail_price}" />
				</c:forEach>
				<tr>
					<td><img src="images/product/cart.png" alt=""
						style="width: 50px; height: auto;"></td>
					<td colspan="2"
						style="text-align: center; font-weight: bold; font-size: 20px; padding-right: 10px; margin: 10px;">合計</td>
					<td colspan="2"><fmt:formatNumber value="${totalPrice}"
							pattern="#,##0" var="formattedTotalPrice" /> <span
						style="font-size: 20px;">${formattedTotalPrice}￥</span></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp"%>