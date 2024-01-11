<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="margin-top: 100px;"class="wrap">

<div class="add-left-section">
<img class="display-image" id="image-preview" src="images/admin/noImage4.jpg" />
</div>
<div class="add-right-section">
<form name="productForm" method="post" action="productaddpro.do" enctype="multipart/form-data" onsubmit="return check()">
	<ul class="menu">
		<li><div>상품 이름</div> <input name="product_name" type="text"/></li>
		<li><div>디스플레이</div> <input name="product_display" type="text"/></li>
		<li><div>카메라</div> <input name="product_camera" type="text"/></li>
		<li><div>용량</div> <input name="product_capacity" type="text"/></li>
		<li><div>색상</div> <input name="product_color" type="text"/></li>
		<li><div>램</div> <input name="product_ram" type="text"/></li>
		<li><div>무게</div> <input name="product_weight" type="text"/></li>
		<li><div>배터리</div> <input name="product_battery" type="text"/></li>
		<li><div>가격</div> <input name="product_price" type="text"/></li>
		<li><div>출시일 </div><input name="product_rdate" type="text"/></li>
		<li><div>사진</div> <input name="product_picture" type="file" id="image-input" /></li>
	</ul>
		<input type="submit" value="상품등록하기">
	</form>
</div>
</div>
</body>
</html>
<script>
const imageInput = document.getElementById("image-input");
const imagePreview = document.getElementById("image-preview");

imageInput.addEventListener("change", () => {
  const files = imageInput.files;
  if (files.length > 0) {
    const file = files[0];
    const reader = new FileReader();

    reader.onload = () => {
      imagePreview.src = reader.result;
    };

    reader.readAsDataURL(file);
  }
});
	function check(){
		if(!productForm.product_name.value){
			alert("상품 이름을 입력하세요")
			productForm.product_name.focus()
			return false
		}
		if(!productForm.product_display.value){
			alert("디스플레이를 입력하세요")
			productForm.product_display.focus()
			return false
		}
		if(!productForm.product_camera.value){
			alert("카메라를 입력하세요")
			productForm.product_camera.focus
			return false
		}
		if(!productForm.product_capacity.value){
			alert("용량을 입력하세요")
			productForm.product_capacity.focus
			return false
		}
		if(!productForm.product_color.value){
			alert("색상을 입력하세요")
			productForm.product_color.focus
			return false
		}
		if(!productForm.product_ram.value){
			alert("램을 입력하세요")
			productForm.product_ram.focus
			return false
		}
		if(!productForm.product_weight.value){
			alert("무게를 입력하세요")
			productForm.product_weight.focus
			return false
		}
		if(!productForm.product_battery.value){
			alert("배터리를 입력하세요")
			productForm.product_battery.focus
			return false
		}
		if(!productForm.product_price.value){
			alert("가격을 입력하세요")
			productForm.product_price.focus
			return false
		}
		if(!productForm.product_rdate.value){
			alert("출시일을 입력하세요")
			productForm.product_rdate.focus
			return false
		}
		if(!productForm.product_picture.value){
			alert("사진을 선택하세요")
			productForm.product_picture.focus
			return false
		}
		
		alert("상품이 등록되었습니다")
		return true;
		
	}
</script>
<%@ include file="../footer.jsp" %>