<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="images/product/banner_up_1.webp" alt="...">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img src="images/product/banner_up_2.webp" alt="...">
				<div class="carousel-caption"></div>
			</div>
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
</div>

<!-- sub contents -->
<div class="container content">
	<div class="row">
		<div class="col-lg-12">
			<h2>PRODUCT_LIST</h2>
			<div class="col-lg-12">
				<div class="row">
					<c:forEach var="product" items="${list}">
						<div class="col-md-4">
							<div class="thumbnail">
								<img src="images/${product.product_picture}" alt="...">
								<div class="caption">
									<h3>${product.product_name}</h3>
									<p>${product.product_capacity}</p>
									<p>${product.product_color}</p>
									<fmt:formatNumber value="${product.product_price}" pattern="#,##0" var="formattedPrice" />
									<p>${formattedPrice} 원</p>
									<p>
										<a href="productdetail.do?product_no=${product.product_no}"
											class="btn btn-primary" role="button">제품보기</a>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>