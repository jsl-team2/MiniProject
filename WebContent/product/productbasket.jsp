<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub contents -->
<div class="container-fluid content" style="background: #FAFAFA;">
	<div class="container">
		<h2>Basket</h2>

		<div class="bord_list">
			<table class="bord_table">
				<caption class="sr-only">장바구니 리스트</caption>
				<colgroup>
					<col width="20%">
					<col width="*">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<th></th>
						<th>제품</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
					<%-- <c:set var="bno" value="${tot - ((page.cri.pageNum-1)*10)}" /> --%>
					<c:forEach var="product" items="${list}">
						<tr>
							<td><img src="${vo.product_picture}" alt=""
								style="width: 100%;"></td>
							<td><a href="noticeview.do?idx=${list.idx }">${vo.product_name}</a></td>
							<td>${vo.product_price}</td>
						</tr>
						<%-- <c:set var="bno" value="${bno-1}" /> --%>
					</c:forEach>
				</tbody>
			</table>
			<div class="record_group">
				<p>
					총게시글 <span> </span>건
				</p>
			</div>
		</div>
		<div>
			<a href="productorder.do" class="btn btn-primary" role="button">구매하기</a>
		</div>
	</div>

</div>



<%@ include file="/footer.jsp"%>