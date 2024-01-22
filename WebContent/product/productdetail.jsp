<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>商品詳細</h2>
</div>

<!-- sub contents -->
<div class="container-fluid contents">
	<div class="container" style="text-align: center;">
		<div class="col-lg-12">
			<div class="productrow">

				<div class="col-lg-5">
					<img src="images/product/${vo.product_picture}" alt=""
						style="width: 500px; height: auto;">
				</div>
				<div class="col-lg-1"></div>
				<div class="col-lg-5" style="margin-bottom: 20px;">
					<div
						style="background: #FAFAFA; border-radius: 15px; padding: 10px; margin-top: 35px;">
						<p class="productname" style="margin-bottom: 80px;">${vo.product_name}</p>
						<div class="specifications">
							<p style="text-align: right;">容量: ${vo.product_capacity}</p>
						</div>
						<p id="price" data-price="${vo.product_price}"></p>
						<div class="total"
							style="font-size: 20px; font-weight: bold; text-align: center; color: #000;">価格:
							100,000￥ (数量: 1個)</div>
						<div style="text-align: right;">
							<button class="minus" type="button"
								style="width: 25px; height: 25px;">-</button>
							<input type="text" name="quantity" value="1" class="quantity"
								style="width: 20px; height: 25px;">
							<button class="plus" type="button"
								style="width: 25px; height: 25px; margin-right: 20px; margin-bottom: 5px;">+</button>
						</div>

						<c:choose>
							<c:when test="${not empty user_id}">
								<!-- user_id가 비어있지 않은 경우 -->
								<div style="border-radius: 15px; padding: 10px;">
									<div>
										<div style="text-align: center;">
											<button class="btn btn-default btn-lg"
												onclick="showConfirmation('${vo.product_no}')">カートに入れる</button>
											<a
												href="productorderone.do?product_no=${vo.product_no}&user_id=${user_id}&quantity="
												id="purchaseLink" class="btn btn-default btn-lg"
												role="button">購入する</a>
										</div>
										<div id="confirmationModal" class="modal"
											style="display: none;">
											<div class="modal-content">
												<p>カートに入れますか？</p>
												<button onclick="addToCart('${vo.product_no}', true)">はい</button>
												<button onclick="addToCart('${vo.product_no}', false)">いいえ</button>
											</div>
										</div>
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<!-- user_id가 비어있는 경우 -->
								<P style="text-align: center;">会員のみ購入可能です</P>
								<a href="/terms.do" class="btn btn-default btn-lg">会員加入</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
				<div class="col-lg-1"></div>
			</div>
		</div>
	</div>
	<div class="container" style="text-align: center;">
		<div class="horizontal-line"
			style="border-top: 1px solid #000; margin-top: 10px; margin-bottom: 10px;">
		</div>
		<div class="productdetail_1"
			style="font-weight: bold; font-size: 20px;">
			<p>基本構成品</p>
		</div>
		<div>
			<img src="images/product/${vo.product_detailpicture}" alt=""
				style="width: 500px; height: auto;">
		</div>
		<div>
			<div class="specifications">
				<table style="font-size:20px; width:600px; margin-bottom: 40px;">
					<tr>
						<td>画面</td>
						<td>${vo.product_display}</td>
					</tr>
					<tr>
						<td>カメラ</td>
						<td>${vo.product_camera}</td>
					</tr>
					<tr>
						<td>容量</td>
						<td>${vo.product_capacity}</td>
					</tr>
					<tr>
						<td>ラム</td>
						<td>${vo.product_ram}</td>
					</tr>
					<tr>
						<td>重量</td>
						<td>${vo.product_weight}</td>
					</tr>
					<tr>
						<td>バッテリー</td>
						<td>${vo.product_battery}</td>
					</tr>
					<tr>
						<td>色</td>
						<td>${vo.product_color}</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</div>

<script>
	function showConfirmation(productNo) {
		document.getElementById('confirmationModal').style.display = 'block';
	}

	function addToCart(productNo, confirmed) {
		document.getElementById('confirmationModal').style.display = 'none';

		if (confirmed) {
			var form = document.createElement('form');
			form.action = 'productcart.do';
			form.method = 'POST';
			form.style.display = 'none';

			var input = document.createElement('input');
			input.type = 'hidden';
			input.name = 'product_no';
			input.value = productNo;
			form.appendChild(input);

			var inputQuantity = document.createElement('input');
			inputQuantity.type = 'hidden';
			inputQuantity.name = 'quantity';
			inputQuantity.value = $(".quantity").val();
			form.appendChild(inputQuantity);

			var inputUserId = document.createElement('input');
			inputUserId.type = 'hidden';
			inputUserId.name = 'user_id';
			inputUserId.value = "${user_id}"; // `${user_id}`는 서버사이드에서 동적으로 값을 가져오는 방법이므로 주의 필요
			form.appendChild(inputUserId);

			document.body.appendChild(form);
			form.submit();
		}
	}
	// 'purchaseLink' 링크 요소를 가져오기
	var purchaseLink = document.getElementById('purchaseLink');

	// 링크에 클릭 이벤트 추가
	purchaseLink.addEventListener('click', function(event) {
		// 클릭 시 수량 값을 가져와서 동적으로 링크에 추가
		var quantityValue = $(".quantity").val();
		purchaseLink.href = "productorderone.do?product_no="
				+ '${vo.product_no}' + "&user_id=" + '${user_id}'
				+ "&quantity=" + quantityValue;
	});
</script>

<script>
	$(document).ready(
			function() {
				var total = function(n) {
					var price1 = document.getElementById("price");
					var price = parseInt(price1.dataset.price); // 가격
					var amount = $(".quantity").val(); // 수량
					amount = parseInt(amount); // 숫자 변환
					amount = amount + n; // 전체 수량

					if (amount < 1) {
						amount = 1;
						alert("1つ以上を選択してください");
					}

					var tot = price * amount; // 총액 = 단가 * 수량
					$(".quantity").val(amount);

					// 정규표현식
					var regexp = /\B(?=(\d{3})+(?!\d))/g;
					var formattedTot = tot.toString().replace(regexp, ',');
					$(".total").html(
							"価格: " + formattedTot + "￥ (数量: " + amount + "個)");
				}

				// .on 마우스 이벤트 핸들러
				$(".plus").on("click", function() {
					total(1);
				})

				$(".minus").on("click", function() {
					total(-1);
				})
			})
</script>

<%@ include file="/footer.jsp"%>