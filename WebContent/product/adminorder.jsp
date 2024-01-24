<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="admin__wrap">

	<div class="left-section">
		<div><a href="admin.do">会員照会</a></div>
		<div><a href="productmanagement.do">商品管理</a></div>
		<div><a href="adminorder.do">全体注文内訳</a></div>
	</div>
	<div class="right-section">
		<h1 class="tabs-title">全体注文内訳</h1>
		<table class="admin-table">
			<thead>
				<tr style="border-bottom: 1px solid black;">
					<th>番号</th>
					<th>注文者</th>
					<th>電話番号</th>
					<th>住所</th>
					<th>注文日</th>
					<th>状態</th>
					<th>注文詳細</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}" varStatus="loopStatus">
					<tr>
						<td>${list.order_no}</td>
						<td>${list.order_user}</td>
						<td>${list.order_tel}</td>
						<td>${list.order_address}</td>
						<td>${list.order_date}</td>
						<td>${list.order_status}</td>
						<td style="text-align: center;"><a
							href="adminorderdetail.do?order_no=${list.order_no}"
							class="btn btn-default" role="button">注文詳細</a>
							
							<button class="btn btn-default" onclick="openModal(${list.order_no})">状態変更</button>
							<div id="myModal" class="modal">
								<div class="modal-content">
									<span class="close" onclick="closeModal()">&times;</span>
									<form id="myForm" action="adminorderstatus.do" method="post">
										<label for="selectBox">状態:</label> <select id="selectBox"
											name="selectedValue">
											<option value="注文完了">注文完了</option>
											<option value="注文確認">注文確認</option>
											<option value="配送開始">配送開始</option>
											<option value="配送中">配送中</option>
											<option value="配送完了">配送完了</option>
											<option value="取り消し">取り消し</option>
										</select> <input type="hidden" id="selectedValueHidden"
											name="selectedValueHidden" value=""> <input
											type="hidden" id="selectedOrderNo" name="selectedOrderNo"
											value="${list.order_no}">
										<button type="button" class="btn btn-default"
											style="border: 1px solid #ccc;" onclick="submitForm()">提出</button>
									</form>
								</div>
							</div>
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging" style="margin-bottom:50px;">
				<c:if test="${page.prev }">
					<a href="adminorder.do?pageNum=${page.startPage-1 }&amount=${page.cri.amount}&type=${page.cri.type}">
						<i class="fa  fa-angle-double-left"></i></a>
				</c:if>
				<c:forEach var="num" begin="${page.startPage }"
					end="${page.endPage }">
					<a href="adminorder.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}"
						class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
				</c:forEach>
				<c:if test="${page.next }">
					<a href="adminorder.do?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&type=${page.cri.type}">
						<i class="fa fa-angle-double-right"></i></a>
				</c:if>
			</div>

	</div>
</div>
</body>
</html>

<script>
	var selectedOrderNo; // 모달을 열 때 선택된 주문 번호를 저장할 변수

	function openModal(orderNo) {
		selectedOrderNo = orderNo; // 선택된 주문 번호 저장
		document.getElementById("myModal").style.display = "block";
	}

	function closeModal() {
		selectedOrderNo = null; // 선택된 주문 번호 초기화
		document.getElementById("myModal").style.display = "none";
	}

	function submitForm() {
		var selectBox = document.getElementById("selectBox");
		var selectedValueHidden = document
				.getElementById("selectedValueHidden");

		selectedValueHidden.value = selectBox.value;
		document.getElementById("selectedOrderNo").value = selectedOrderNo; // 저장된 주문 번호 설정

		document.getElementById("myForm").submit();

		// 모달 닫기
		closeModal();
	}
</script>

<%@ include file="../footer.jsp"%>