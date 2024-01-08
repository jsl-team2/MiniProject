<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<c:set var="keyword" value="${keyword }"/>
<c:choose >
<c:when test="${empty productList && empty boardList }">
	<div class="center">
	<span>'${keyword }'</span><span>검색 결과가 없습니다.</span>
	</div>
	</c:when> 
 	<c:otherwise>
 	<div class="product-container container-fluid">
		<div class="main__title">상품</div>
		<div class="row">
	<c:forEach var="productList" items="${productList }">
	<a href="productdetail.do?product_no=${productList.product_no}"
											>
		<div class="col-md-3 product">
		<img class="product__image" src="images/product/${productList.product_picture }"/>
		<p class="product__title">${productList.product_name }</p>
		<p class="product__price">${productList.product_price }</p>
		</div>
		</a>
	</c:forEach>
		</div>
		</div>
	<div class="border-line"></div>
	<div class="board-container">
		<div class="main__title">게시글</div>
		<c:forEach var="boardList" items="${boardList }">
		<div class="board">
		<p class="board__title">${boardList.board_title }</p>
		<div class="board__section">
		<p class="board__content">${boardList.board_content}</p>
		<div class="board__detail">
		<p>${boardList.board_writer} | ${boardList.board_date.substring(0,10)}</p>
		</div>
		</div>
		</div>
		</c:forEach>
		</div>
 	</c:otherwise>
</c:choose>

<%@ include file="footer.jsp" %>
