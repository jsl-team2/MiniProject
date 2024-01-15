<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<div class="wrap">

	<div class="left-section">
		<div><a href="admin.do">회원조회</a></div>
		<div><a href="productmanagement.do">상품관리</a></div>
		<div><a href="adminorder.do">주문조회</a></div>
	</div>
	<div class="right-section">
    	<h1 class="tabs-title" >상품관리</h1>
    	<form name=productSearchForm class="admin-search" method="get" action="productsearch.do">
    	<select class="select-tag form-control" name="type" >
    		<option value="product_name">상품명</option>
    		<option value="product_capacity">용량</option>
    		<option value="product_ram">메모리</option>
    	</select>
    	<input class="search-tag form-control" name="keyword" placeholder="Search..">
    	<span class="search-icon glyphicon glyphicon-search"></span>
    	</form>
    	 <table class="admin-table" >
    <thead>
    	<tr style="border-bottom: 1px solid black;">
    		<th>상품번호</th>
    		<th>상품사진</th>
    		<th>상품이름</th>
    		<th>용량</th>
    		<th>메모리</th>
    		<th>무게</th>
    		<th>배터리</th>
    		<th>가격</th>
    		<th>출시일</th>
    		<th></th>
    	</tr>
    </thead>
    <tbody>
    <c:set var="bno" value="${tot-((page.cri.pageNum - 1 )*10) }"/>
				<c:forEach var="list" items="${list }">
				<tr>
					<td>${list.product_no }</td>
					<td><img style="width:50px;"src="images/product/${list.product_picture }" alt=""/></td>
					<td>${list.product_name }</td>
					<td>${list.product_capacity }</td>
		    		<td>${list.product_ram }</td>
		   			<td>${list.product_weight }</td>
		    		<td>${list.product_battery }</td>
		   			<td>${list.product_price }</td>
		    		<td>${list.product_rdate }</td>
		    		<td><button class="update-btn btn btn-warning" onclick="updateCheck(${list.product_no})">수정</button>
		    		<button class="delete-btn btn btn-danger" onclick="deleteCheck(${list.product_no})">삭제</button></td>
				</tr>
				<c:set var="bno" value="${bno-1}"/>
				</c:forEach>
    	</tbody>
    	</table>
    	
    	<a href="productadd.do">
    		<button class="product-add btn btn-primary">상품 추가</button>
    	</a>
    	<div class="paging-admin">
		<c:if test="${page.prev }">
			<a href="$productmanagement.do?pageNum=${page.startPage -1 }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"><span class="glyphicon glyphicon-chevron-left"></span></a>
		</c:if>	
		<c:forEach var="num" begin="${page.startPage }" end="${page.endPage }">
			<a href="productmanagement.do?pageNum=${num }&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}" class="${page.cri.pageNum == num? 'active' : '' }">${num }</a>
		</c:forEach>
		<c:if test="${page.next }">
			<a href="productmanagement.do?pageNum=${page.endPage +1}&amount=${page.cri.amount}&type=${page.cri.type}&keyword=${page.cri.keyword}"><span class="glyphicon glyphicon-chevron-right"></span></a>
		</c:if>
		</div>
    	</div>
    </div>
    <script>
    function deleteCheck(product_no){
    	  		let check = confirm("정말로 삭제하시겠습니까?")
    	  		 if(check){
    	  			window.location.href = "productdelete.do?product_no="+product_no;
    	  		}else{
    	  			return false;
    	  		}  
    	  	}
    
    function updateCheck(product_no){
    	  			window.location.href = "productupdateview.do?product_no="+product_no;
    	  	}

    </script>
</body>
</html>

<%@ include file="../footer.jsp" %>