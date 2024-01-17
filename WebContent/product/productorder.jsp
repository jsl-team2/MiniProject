<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub visual -->
<div class="container-fluid subvisual">
	<h2>[カート]注文</h2>
</div>

<!-- sub contents -->
<div class="container-fluid contents">
	<div class="container">
		<div class="cart_list">
			<table class="cart_table">
				<caption class="sr-only">カートリスト</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th colspan="2">
							<p class="columns">製品</p>
						</th>
						<th>
							<p class="columns">数量</p>
						</th>
						<th>
							<p class="columns">価格</p>
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="list" items="${list}" varStatus="loopStatus">
						<tr>
							<td><img src="images/product/${list.cart_picture}" alt=""
								style="width: 120px; height: auto;"></td>
							<td><a href="productdetail.do?product_no=${list.cart_no}"
								style="font-size: 18px;">${list.cart_product}</a></td>
							<td>${list.cart_quantity}個</td>
							<c:if test="${list.cart_price ne 0}">
								<td><fmt:formatNumber value="${list.cart_price}"
										pattern="#,##0" var="formattedPrice" /> <span
									style="font-size: 18px;">${formattedPrice}￥</span></td>
							</c:if>
						</tr>
						<c:set var="totalPrice" value="${totalPrice + list.cart_price}" />
					</c:forEach>
					<tr>
						<td><img src="images/product/cart.png" alt=""
							style="width: 50px; height: auto;"></td>
						<td
							style="text-align: center; font-weight: bold; font-size: 20px; padding-right: 10px; margin: 10px;">合計</td>
						<td colspan="2"><fmt:formatNumber value="${totalPrice}"
								pattern="#,##0" var="formattedTotalPrice" /> <span
							style="font-size: 20px;">${formattedTotalPrice}￥</span></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div>
			<form name="order" id="order">
				<input type="hidden" id="user_id" name="user_id" value="${user_id}">
				<table class="table_write02" summary="제품배송을 위한 이름, 휴대전화번호, 주소">
					<caption style="font-weight: bold; font-size: 20px; color: #000;">注文者情報</caption>
					<colgroup>
						<col width="160px">
						<col width="auto">
					</colgroup>
					<tbody id="readonlyDataBody">
						<tr>
							<th><label for="name">注文者</label></th>
							<td><input type="text" name="name" id="name" class="w300"
								value="${vo.order_name}" readonly></td>
						</tr>
						<tr>
							<th><label for="tel">電話番号</label></th>
							<td><input type="text" name="tel" id="tel" class="w300"
								value="${vo.order_tel}" readonly></td>
						</tr>
						<tr>
							<th><label for="address">住所</label></th>
							<td><input type="text" name="address" id="address"
								class="w300" value="${vo.order_address}" readonly></td>
						</tr>
					</tbody>
				</table>

				<table class="table_write02" summary="제품배송을 위한 이름, 휴대전화번호, 주소"
					id="editableTable">
					<caption style="font-weight: bold; font-size: 20px; color: #000;">配送情報</caption>
					<colgroup>
						<col width="160px">
						<col width="auto">
					</colgroup>
					<tbody id="editableDataBody">
						<!-- 수정 가능한 주문자 정보 입력 필드 -->
						<tr>
							<th><label for="editableName">受取人</label></th>
							<td><input type="text" name="editableName" id="editableName"
								class="w300" value="" required></td>
						</tr>
						<tr>
							<th><label for="editableTel">電話番号</label></th>
							<td><input type="text" name="editableTel" id="editableTel"
								class="w300" value="" required></td>
						</tr>
						<tr id="editableAddressRow">
							<th><label for="editableAddress">住所</label></th>
							<td><input type="text" name="editableAddress"
								id="editableAddress" class="w300" value="" required>
								<button type="button" onclick="toggleAddress()">우편번호</button></td>
						</tr>
						<tr id="addressRow" style="display: none;">
							<th><label for="adress">주소<span class="must"><b>필수입력</b></span></label></th>
							<td><input type="text" id="sample6_postcode"
								name="sample6_postcode" placeholder="우편번호"> <input
								type="button" onclick="sample6_execDaumPostcode()"
								value="우편번호 찾기"><br> <input type="text"
								id="sample6_address" name="sample6_address" placeholder="주소"
								required><br> <input type="text"
								id="sample6_detailAddress" name="sample6_detailAddress"
								placeholder="상세주소" required> <input type="text"
								id="sample6_extraAddress" name="sample6_extraAddress"
								placeholder="참고항목" required></td>
						</tr>
					</tbody>
				</table>
				<input type="checkbox" id="modifyCheckbox"> 注文者情報と同じ
			</form>
		</div>
		<div style="margin: 20px; text-align: center;">
			<a class="btn btn-default btn-lg" href="javascript:fn_order();">決済する</a>
		</div>
	</div>
</div>

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function sample6_execDaumPostcode() {
		// 기존의 editableAddress를 비워줌
        document.getElementById('editableAddress').value = '';
		
		new daum.Postcode(
				{
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

						// 각 주소의 노출 규칙에 따라 주소를 조합한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var addr = ''; // 주소 변수
						var extraAddr = ''; // 참고항목 변수

						//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
						if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
							addr = data.roadAddress;
						} else { // 사용자가 지번 주소를 선택했을 경우(J)
							addr = data.jibunAddress;
						}

						// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
						if (data.userSelectedType === 'R') {
							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraAddr += (extraAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraAddr !== '') {
								extraAddr = ' (' + extraAddr + ')';
							}
							// 조합된 참고항목을 해당 필드에 넣는다.
							document.getElementById("sample6_extraAddress").value = extraAddr;

						} else {
							document.getElementById("sample6_extraAddress").value = '';
						}

						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById('sample6_postcode').value = data.zonecode;
						document.getElementById("sample6_address").value = addr;
						// 커서를 상세주소 필드로 이동한다.
						document.getElementById("sample6_detailAddress")
								.focus();
					}
				}).open();
	}
</script>
<script>
	function fn_order() {
		if (!order.name.value) {
			alert("受取人を入力してください");
			order.name.focus();
			return false;
		}
		if (!order.tel.value) {
			alert("電話番号を入力してください");
			order.tel.focus();
			return false;
		}
		if (!order.address.value) {
			alert("住所を入力してください");
			order.address.focus();
			return false;
		}

		// 자바스크립트로 form 태그 속성을 지정할 수 있다
		var form = document.order;
		form.method = "post";
		form.action = "productordercomplete.do";
		form.submit();

		var msg = "${msg}"; // 자바 속성값을 자바 변수에 저장 할 수 있다.
	}
</script>
<script>
	//체크박스 상태에 따라 수정 가능한 테이블을 표시하거나 숨김
	document
			.getElementById('modifyCheckbox')
			.addEventListener(
					'change',
					function() {
						var nameField = document.getElementById('editableName');
						var telField = document.getElementById('editableTel');
						var addressField = document
								.getElementById('editableAddress');

						// 체크박스 선택 여부에 따라 수정 가능한 테이블의 값을 설정
						if (this.checked) {
							// 체크된 경우, readonly 테이블의 값을 가져와서 수정 가능한 테이블에 설정
							nameField.value = document.getElementById('name').value;
							telField.value = document.getElementById('tel').value;
							addressField.value = document
									.getElementById('address').value;
						} else {
							// 체크 해제된 경우, 모든 입력 필드 초기화
							nameField.value = '';
							telField.value = '';
							addressField.value = '';
						}
					});
</script>
<script>
	function toggleAddress() {
		var editableAddressRow = document.getElementById('editableAddressRow');
		var addressRow = document.getElementById('addressRow');

		// 주소 수정 버튼을 클릭하면 행을 숨기고, 주소 입력 부분을 나타나게 함
		editableAddressRow.style.display = 'none';
		addressRow.style.display = 'table-row';
	}
</script>

<%@ include file="/footer.jsp"%>