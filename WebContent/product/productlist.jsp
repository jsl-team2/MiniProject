<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>제품목록</h2>
</div>

<!-- sub contents -->
<div class="container contents" style="margin-top: 30px;">

	<div class="col-lg-12">
		<div style="text-align: center; margin-bottom: 30px;">
			<a href="javascript:void(0);" id="btnS23" class="btn btn-default btn-lg" role="button" style="width:200px;" onclick="selectButton('S23')">S23</a>
			<a href="javascript:void(0);" id="btnFlip" class="btn btn-default btn-lg" role="button" style="width:200px;" onclick="selectButton('Flip')">Flip</a>
			<a href="javascript:void(0);" id="btnFold" class="btn btn-default btn-lg" role="button" style="width:200px;" onclick="selectButton('Fold')">Fold</a>
		</div>

		<div class="row">
			<c:forEach var="product" items="${list}">
				<div class="col-md-4">
					<div class="thumbnail">
						<img src="images/product/${product.product_picture}" alt="..."
							style="width: 300px; height: auto; margin: 0 auto;">
						<div class="caption">
							<h3>${product.product_name}</h3>
							<p>${product.product_capacity}</p>
							<%-- <p>${product.product_color}</p> --%>
							<fmt:formatNumber value="${product.product_price}"
								pattern="#,##0" var="formattedPrice" />
							<p>${formattedPrice}￥</p>
							<p>
								<a href="productdetail.do?product_no=${product.product_no}"
									class="btn btn-default btn-lg" role="button">製品詳細</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script>
	function selectButton(selectedButton) {
		// 모든 버튼의 스타일 초기화
		document.getElementById('btnS23').classList.remove('active');
		document.getElementById('btnFlip').classList.remove('active');
		document.getElementById('btnFold').classList.remove('active');

		// 선택한 버튼에 스타일 추가
		document.getElementById('btn' + selectedButton).classList
				.add('active');

		// 선택한 버튼에 따라 필요한 동작 수행 (예: 페이지 이동 또는 기타 작업)
		// 여기에서는 페이지 이동 예제를 표시하고 있습니다.
		window.location.href = 'productlistmenu.do?keyword=' + selectedButton;
	}
</script>

<%@ include file="/footer.jsp"%>