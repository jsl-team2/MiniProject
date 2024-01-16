<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>[カート]注文</h2>
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
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus="loopStatus">
						<tr>
							<td><img src="images/product/${list.cart_picture}" alt=""
								style="width: 120px; height: auto;"></td>
							<td><a href="productdetail.do?product_no=${list.cart_no}"
								style="font-size: 18px;">${list.cart_product}</a></td>
							<td>${list.cart_quantity}個</td>	
							<c:if test="${list.cart_price ne 0}">
								<td><fmt:formatNumber value="${list.cart_price}"
										pattern="#,##0" var="formattedPrice" /> <span
									style="font-size: 18px;">${formattedPrice}￥</span></td>
							</c:if>
						</tr>
						<c:set var="totalPrice" value="${totalPrice + list.cart_price}" />
					</c:forEach>
					<tr>
						<td><img src="images/product/cart.png" alt=""
							style="width: 50px; height: auto;"></td>
						<td
							style="text-align: center; font-weight: bold; font-size: 20px; padding-right: 10px; margin: 10px;">合計</td>
						<td colspan="2"><fmt:formatNumber value="${totalPrice}" pattern="#,##0"
								var="formattedTotalPrice" /> <span style="font-size: 20px;">${formattedTotalPrice}￥</span></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div>
			<form name="order" id="order">
				<!-- 유저정보 히든인풋 -->
				<table class="table_write02" summary="제품배송을 위한 이름, 휴대전화번호, 주소">
					<caption style="font-weight: bold; font-size: 20px; color:#000;">配送情報</caption>
					<colgroup>
						<col width="160px">
						<col width="auto">
					</colgroup>
					<tbody id="joinDataBody">
						<tr>
							<th><label for="name">受取人</label></th>
							<td><input type="text" name="name" id="name" class="w300" value="${vo.order_name}">
							</td>
						</tr>
						<tr>
							<th><label for="tel">電話番号</label></th>
							<td><input type="text" name="tel" id="tel" class="w300" value="${vo.order_tel}">
							</td>
						</tr>
						<tr>
							<th><label for="address">住所</label></th>
							<td><input type="text" name="address" id="address"
								class="w300" value="${vo.order_address}"></td>
						</tr>
				</table>
			</form>
		</div>
		<div style="margin: 20px; text-align: center;">
			<a class="btn btn-default btn-lg" href="javascript:fn_order();">決済する</a>
		</div>
	</div>
</div>

<script>
	function fn_order() {
		if (!order.name.value) {
			alert("受取人を入力してください");
			order.name.focus();
			return false;
		}
		if (!order.tel.value) {
			alert("電話番号を入力してください");
			order.tel.focus();
			return false;
		}
		if (!order.address.value) {
			alert("住所を入力してください");
			order.address.focus();
			return false;
		}

		// 자바스크립트로 form 태그 속성을 지정할 수 있다
		var form = document.order;
		form.method = "post";
		form.action = "productordercomplete.do";
		form.submit();

		var msg = "${msg}"; // 자바 속성값을 자바 변수에 저장 할 수 있다.
	}
</script>

<%@ include file="/footer.jsp"%>