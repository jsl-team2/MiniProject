<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>제품상세</h2>
</div>

<!-- sub contents -->
<div class="container-fluid contents">
	<div class="container">
		<div class="col-lg-12">
			<div class="row">
				<div class="col-lg-1"></div>
				<div class="col-lg-5">
					<img src="images/product/${vo.product_picture}" alt=""
						style="width: 500px; height: auto;">
				</div>
				<div class="col-lg-5" style="margin-bottom: 20px;">
					<div
						style="background: #FAFAFA; border-radius: 15px; padding: 10px; margin-top: 35px;">
						<p class="productname" style="">${vo.product_name}</p>
						<div class="specifications">
							<p>画面: ${vo.product_display}</p>
							<p>容量: ${vo.product_capacity}</p>
							<p>カメラ: ${vo.product_camera}</p>
							<p>ラム: ${vo.product_ram}</p>
							<p>重量: ${vo.product_weight}</p>
							<p>バッテリー: ${vo.product_battery}</p>
							<p>色: ${vo.product_color}</p>
						</div>
						
						<p id="price" data-price="${vo.product_price}"></p>
						<div style="text-align:right;">
							<button class="minus" type="button" style="width:25px; height:25px;" >-</button>
							<input type="text" name="quantity" value="1" class="quantity" style="width:20px; height:25px;">
							<button class="plus" type="button" style="width:25px; height:25px; margin-right:20px; margin-bottom:20px;">+</button>
						</div>
						<div class="total" style="font-size:20px; font-weight:bold; text-align:center;">価格: 100,000￥ (数量: 1個)</div>

						<div style="border-radius: 15px; padding: 10px;">
							<div>
								<div style="text-align: center;">
									<button class="btn btn-default"
										onclick="showConfirmation('${vo.product_no}')">カートに入れる</button>
									<a href="productorderone.do?product_no=${vo.product_no}&quantity=${quantity}"
										class="btn btn-default" role="button">購入する</a>
								</div>
								<div id="confirmationModal" class="modal" style="display: none;">
									<div class="modal-content">
										<p>カートに入れますか？</p>
										<button onclick="addToCart('${vo.product_no}', true)">はい</button>
										<button onclick="addToCart('${vo.product_no}', false)">いいえ</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-1"></div>
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

			document.body.appendChild(form);
			form.submit();
		}
	}
</script>

<script>
$(document).ready(function() { 
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
        $(".total").html("価格: " + formattedTot + "￥ (数量: " + amount + "個)");
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