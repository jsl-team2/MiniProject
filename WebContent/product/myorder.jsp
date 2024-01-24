<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<div class="admin__wrap">
	<div class="right-section">
		<h1 class="tabs-title">個人注文履歴</h1>
		<table class="admin-table product">
			<thead>
				<tr>
					<th>
						番号
					</th>
					<th>
						注文者
					</th>
					<th>
						電話番号
					</th>
					<th>
						住所
					</th>
					<th>
						注文日
					</th>
					<th>
						状態
					</th>
					<th>
						注文詳細
					</th>
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
						<td><a href="myorderdetail.do?order_no=${list.order_no}"
							class="btn btn-default" role="button">注文詳細</a>
						<c:if test="${list.order_status eq '注文完了'}">
							<a
								href="myordercancel.do?order_no=${list.order_no}&user_id=${user_id}"
								class="btn btn-default" role="button">キャンセル要請</a>
						</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paging" style="margin-bottom: 50px;">
			<c:if test="${page.prev }">
				<a
					href="myorder.do?pageNum=${page.startPage-1 }&amount=${page.cri.amount}&type=${page.cri.type}">
					<i class="fa  fa-angle-double-left"></i>
				</a>
			</c:if>
			<c:forEach var="num" begin="${page.startPage }"
				end="${page.endPage }">
				<a
					href="myorder.do?pageNum=${num}&amount=${page.cri.amount}&type=${page.cri.type}"
					class="${page.cri.pageNum == num?'active' : ''}">${num }</a>
			</c:forEach>
			<c:if test="${page.next }">
				<a
					href="myorder.do?pageNum=${page.endPage+1 }&amount=${page.cri.amount}&type=${page.cri.type}">
					<i class="fa fa-angle-double-right"></i>
				</a>
			</c:if>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp"%>