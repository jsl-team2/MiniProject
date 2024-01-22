<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>カート</h2>
</div>

<!-- sub contents -->
<div class="container-fluid contents">
	<div class="container">
		<div class="cart_list">
			<table class="cart_table">
				<caption class="sr-only">カートリスト</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
					<col width="10%">
					<col width="20%">
					<col width="10%">
				</colgroup>
				<thead>
					<tr>
						<th colspan="2">
							<p class="columns">製品</p>
						</th>
						<th>
							<p class="columns">数量</p>
						</th>
						<th>
							<p class="columns">価格</p>
						</th>
						<th>
							<p class="columns">削除</p>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="cart" items="${list}" varStatus="loopStatus">

						<tr>
							<td><img src="images/product/${cart.cart_picture}" alt=""
								style="width: 120px; height: auto;"></td>
							<td><a
								href="productdetail.do?product_no=${cart.cart_productno}"
								style="font-size: 18px;">${cart.cart_product}</a></td>
							<td>${cart.cart_quantity}個</td>
							<td><fmt:formatNumber value="${cart.cart_price}"
									pattern="#,##0" var="formattedPrice" /> <span
								style="font-size: 18px;">${formattedPrice}￥</span></td>
							<td><a href="productcartdelete.do?product_no=${cart.cart_productno}&user_id=${user_id}" class="btn btn-default" role="button">削除</a></td>
						</tr>
						<c:set var="totalPrice" value="${totalPrice + cart.cart_price}" />
					</c:forEach>
					<tr>
						<td><img src="images/product/cart.png" alt=""
							style="width: 50px; height: auto;"></td>
						<td colspan="2"
							style="text-align: center; font-weight: bold; font-size: 20px; padding-right: 10px; margin: 10px;">合計</td>
						<td colspan="2"><fmt:formatNumber value="${totalPrice}" pattern="#,##0"
								var="formattedTotalPrice" /> <span style="font-size: 20px;">${formattedTotalPrice}￥</span>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div style="margin: 20px; text-align: center;">
			<a href="productlist.do" class="btn btn-default btn-lg" role="button">製品リスト</a>
			<a href="productorder.do?user_id=${user_id}" class="btn btn-default btn-lg" role="button">購入する</a>
			<!-- ?cart_user=user -->
		</div>
	</div>

</div>



<%@ include file="/footer.jsp"%>