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
						<div
							style="background: #fff; border-radius: 15px; padding: 10px; margin-top: 100px;">
							<p class="pickup">매장픽업 가능</p>
							<p class="productname">${vo.product_name}</p>
							<p>기준가 ${vo.product_price}원</p>
							<p id="price" data-price="1259739"></p>
							<p>diplay: ${vo.product_display}</p>
							<p>cpu: ${vo.product_cpu}</p>
							<p>capacity: ${vo.product_capacity}</p>
							<p>camera: ${vo.product_camera}</p>
							<p>color: ${vo.product_color}</p>
							
							<div style="margin: 20px;">
							</div>


							<div
								style="background: #fff; border-radius: 15px; padding: 10px;">
								<div>
									

									<!-- <div class="">
										<button class="minus" type="button">-</button>
										<input type="text" name="quantity" value="1" class="quantity">
										<button class="plus" type="button">+</button>
									</div> -->
									
									<div>
										<button type="button" class="btn btn-primary">장바구니 담기</button>
										<button type="button" class="btn btn-danger">구매하기</button>
									</div>
								</div>
							</div>


						</div>






					</div>





				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12" style="margin-top: 40px;">
				<div>

					<!-- Nav tabs -->
					<!-- <ul class="nav nav-tabs mynav" role="tablist">
					<li role="presentation" class="active"><a href="#detail"
						aria-controls="home" role="tab" data-toggle="tab">상품상세설명</a></li>
					<li role="presentation"><a href="#review"
						aria-controls="profile" role="tab" data-toggle="tab">제품후기</a></li>
					<li role="presentation"><a href="#qna"
						aria-controls="messages" role="tab" data-toggle="tab">질문답변</a></li>
				</ul> -->

					<!-- Tab panes -->
					<div class="tab-content">
						<div class="container-fluid">
						
							<p style="font-size:30px; font-weight:bold;">제품설명</p>
							
							<img class="product-banner-image" src="${vo.product_pic2}" alt="">
							
							<p style="font-size:30px; font-weight:bold; text-align:center;">나만의 특별한</p>
							<p style="font-size:30px; font-weight:bold; text-align:center;">삼성닷컴/삼성 강남 전용 컬러</p>
							<p style="font-size:20px; text-align:center;">삼성닷컴과 삼성 강남에서 만나볼 수 있는 전용 컬러로 나만의 스타일을 연출해보세요.</p>
							<p style="font-size:20px; text-align:center;">어디에 있어도 돋보이는 유니크한 컬러가 나를 더욱 특별하게 만들어주죠.</p>
							
							<img class="product-banner-image" src="${vo.product_pic3}" alt="">
						
						</div>
						

					</div>




				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/footer.jsp"%>