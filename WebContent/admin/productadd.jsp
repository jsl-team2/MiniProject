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
<div class="wrap">

<div>
<img id="image-preview" src="images/admin/noImage.jpg" />
</div>
<div>
	<div>상품 번호: <input></div>
	<div>상품 이름: <input></div>
	<div>디스플레이: <input></div>
	<div>카메라: <input></div>
	<div>용량: <input></div>
	<div>색상: <input></div>
	<div>램: <input></div>
	<div>무게: <input></div>
	<div>배터리: <input></div>
	<div>가격: <input></div>
	<div>출시일: <input></div>
	<div>사진 :<input type="file" id="image-input" />
	</div>
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

</script>
<%@ include file="../footer.jsp" %>