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
			<div class="row">
				<c:forEach var="product" items="${list}">
					<div class="col-md-4">
						<div class="thumbnail">
							<img src="images/product/${product.product_picture}" alt="..." style="width: 300px; height: auto; margin:0 auto;">
							<div class="caption">
								<h3>${product.product_name}</h3>
								<p>${product.product_capacity}</p>
								<%-- <p>${product.product_color}</p> --%>
								<fmt:formatNumber value="${product.product_price}"
									pattern="#,##0" var="formattedPrice" />
								<p>${formattedPrice}￥</p>
								<p>
									<a href="productdetail.do?product_no=${product.product_no}"
										class="btn btn-default" role="button">製品詳細</a>
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


<%@ include file="/footer.jsp"%>