<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>商品リスト</h2>
</div>

<!-- sub contents -->
<div class="container contents" style="margin-top: 30px;">

	<div class="col-lg-12">
		<div style="text-align: center; margin-bottom: 30px;">
			<a href="javascript:void(0);" id="btnS24" class="btn btn-default btn-lg" role="button" style="width: 200px;"
				onclick="selectButton('S24')">S24</a> 
			<a href="javascript:void(0);" id="btnS23" class="btn btn-default btn-lg" role="button" style="width: 200px;"
				onclick="selectButton('S23')">S23</a> 
			<a href="javascript:void(0);" id="btnFlip" class="btn btn-default btn-lg" role="button" style="width: 200px;" 
				onclick="selectButton('Flip')">Flip</a>
			<a href="javascript:void(0);" id="btnFold" class="btn btn-default btn-lg" role="button" style="width: 200px;"
				onclick="selectButton('Fold')">Fold</a>
		</div>
		<div><p><span>${tot }</span> 個</p></div>
		<div class="row">
			<c:forEach var="product" items="${list}">
				<div class="col-md-4">
					<div class="thumbnail">
						<img src="images/product/${product.product_picture}" alt="..."
							style="width: 300px; height: auto; margin: 0 auto;">
						<div class="caption">
							<h3>${product.product_name}</h3>
							<p>${product.product_capacity}</p>
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

			<a href="productcart.do?user_id=${user_id}" class="btn btn-default btn-lg" role="button">カート</a>
			<div class="paging" style="margin-bottom:50px;">

				<c:if test="${page.prev }">
					<a href="productlist.do?pageNum=${page.startPage-1 }&amount=${page.cri.amount}&type=${page.cri.type}">
						<i class="fa  fa-angle-double-left"></i></a>
				</c:if>
				<c:forEach var="num" begin="${page.startPage }"
					end="${page.endPage }">
					<a href="productlist.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}"
						class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
				</c:forEach>
				<c:if test="${page.next }">
					<a href="productlist.do?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&type=${page.cri.type}">
						<i class="fa fa-angle-double-right"></i></a>
				</c:if>
			</div>
		</div>
	</div>
</div>
<script>
	function selectButton(selectedButton) {
		// 모든 버튼의 스타일 초기화
		document.getElementById('btnS24').classList.remove('active');
		document.getElementById('btnS23').classList.remove('active');
		document.getElementById('btnFlip').classList.remove('active');
		document.getElementById('btnFold').classList.remove('active');
		// 선택한 버튼에 스타일 추가
		document.getElementById('btn' + selectedButton).classList.add('active');

		// 선택한 버튼에 따라 필요한 동작 수행 (예: 페이지 이동 또는 기타 작업)
		// 여기에서는 페이지 이동 예제를 표시하고 있습니다.
		window.location.href = 'productlistmenu.do?keyword=' + selectedButton;
	}
</script>

<%@ include file="/footer.jsp"%>