<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub contents -->
<div class="container-fluid content" style="background: #FAFAFA;">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h2>PRODUCT_DETAIL</h2>
				<p>Galaxy</p>
				<div class="row">
					<div class="col-lg-7">
						<img src="${vo.product_picture}" alt="" style="width: 100%;">
					</div>
					<div class="col-lg-5">
						<div style="background: #fff; border-radius: 15px; padding: 10px; margin-top: 100px;">
							<p class="productname">${vo.product_name}</p>
							<p>display: ${vo.product_display}</p>
							<p>capacity: ${vo.product_capacity}</p>
							<p>camera: ${vo.product_camera}</p>
							<p>ram: ${vo.product_ram}</p>
							<p>weight: ${vo.product_weight}</p>
							<p>battery: ${vo.product_battery}</p>
							<p>color: ${vo.product_color}</p>
							<p>기준가 ${vo.product_price}원</p>
							<!-- <p id="price" data-price="1259739"></p> -->
							
							<div style="background: #fff; border-radius: 15px; padding: 10px;">
								<div>
									<div>
										<a href="productbasket.do?product_no=${product.product_no}" class="btn btn-danger" role="button">장바구니 담기</a>
										<a href="productorder.do?product_no=${product.product_no}" class="btn btn-primary" role="button">구매하기</a>	
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>