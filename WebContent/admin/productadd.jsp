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
<div class="admin__wrap" style="display: block">

<img style="width:40px; cursor:pointer; margin-top:20px;"src="images/admin/back-arrow.png"/ onclick="history.back()">
<form name="productForm" method="post" action="productaddpro.do" enctype="multipart/form-data" onsubmit="return check()">
	<ul class="admin__menu">
		<li><div>商品名</div> <input class="form-control" name="product_name" type="text"/></li>
<div class="row" style="text-align:left;">
<div class="col-md-4">
<img class="admin__display-image" id="image-preview" src="images/admin/noImage4.jpg" />
		</div>
		<div class="col-md-4" style="padding-left:100px;">
		<li><div>ディスプレー</div> <input class="form-control" name="product_display" type="text"/></li>
		<li><div>カメラ</div> <input class="form-control" name="product_camera" type="text"/></li>
		<li><div>容量</div> <input class="form-control" name="product_capacity" type="text"/></li>
		</div>
		<div class="col-md-4">
		<li><div>色相</div> <input class="form-control" name="product_color" type="text"/></li>
		<li><div>メモリー</div> <input class="form-control" name="product_ram" type="text"/></li>
		<li><div>重さ</div> <input class="form-control" name="product_weight" type="text"/></li>
		</div>
		<div class="col-md-8" style="padding-left:100px;">
		<li><div>バッテリー</div> <input class="form-control" name="product_battery" type="text"/></li>
		<li><div>価格</div> <input class="form-control" name="product_price" type="text"/></li>
		<li><div>発売日 </div><input class="form-control" name="product_rdate" type="text"/></li>
		<li><div>写真</div><label class="input-file-button btn btn-default" for="image-input">アップロード</label> <input name="product_picture" type="file" style="display:none;"id="image-input" /></li>
		<li><div>写真2</div><label class="input-file-button btn btn-default" for="image2-input">アップロード</label> <input name="product_picture2" type="file" style="display:none;" id="image2-input"/></li>
	</div>
	</div>
	
	</ul>
		<input type="submit" class="admin__product-add-btn btn btn-default" value="商品を登録する">
	</form>
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
			alert("商品名を入力してください")
			productForm.product_name.focus()
			return false
		}
		if(!productForm.product_display.value){
			alert("ディスプレイを入力してください")
			productForm.product_display.focus()
			return false
		}
		if(!productForm.product_camera.value){
			alert("カメラを入力してください")
			productForm.product_camera.focus
			return false
		}
		if(!productForm.product_capacity.value){
			alert("容量を入力してください")
			productForm.product_capacity.focus
			return false
		}
		if(!productForm.product_color.value){
			alert("色を入力してください")
			productForm.product_color.focus
			return false
		}
		if(!productForm.product_ram.value){
			alert("メモリを入力してください")
			productForm.product_ram.focus
			return false
		}
		if(!productForm.product_weight.value){
			alert("重さを入力してください")
			productForm.product_weight.focus
			return false
		}
		if(!productForm.product_battery.value){
			alert("バッテリーを入力してください")
			productForm.product_battery.focus
			return false
		}
		if(!productForm.product_price.value){
			alert("価格を入力してください")
			productForm.product_price.focus
			return false
		}
		if(!productForm.product_rdate.value){
			alert("発売日を入力してください")
			productForm.product_rdate.focus
			return false
		}
		if(!productForm.product_picture.value){
			alert("写真を選択してください")
			productForm.product_picture.focus
			return false
		}
		
		alert("商品が登録されました")
		return true;
		
	}
</script>
<%@ include file="../footer.jsp" %>