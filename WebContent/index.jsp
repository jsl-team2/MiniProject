<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

  	
  	<main>
  	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
       <img style="height:600px; width:100%; object-fit:cover;" src="images/main/phone1.jpg" alt="...">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
       <img style="height:600px; width:100%; object-fit:cover;" src="images/main/phone2.jpg" alt="..."> 
      <div class="carousel-caption">
      </div>
    </div>
  </div>

  <!-- Controls -->
  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
  	  	</main>
  	  	<div class="mid">
  	  		<p>新しい製品をご紹介します</p>
  	  	</div>
  	  	<section class="mid-section">
  	  	<div class="mid-product-container">
  	  		<c:forEach var="list" items="${list }" begin="0" end="5">
  	  		<a href="productdetail.do?product_no=${list.product_no}">
	  			<div>
	  				<img src="images/product/${list.product_picture }" alt=""/>
  	  			<div class="main__product__name">${list.product_name }</div>
  	  			<fmt:formatNumber value="${list.product_price}" var="formattedPrice"/> 
  	  			<div class="main__product__price">${formattedPrice }원</div>
	  			</div>
	  			</a>
  			</c:forEach>
  			
  		</div>
  		
  	  	</section>

<%@ include file="footer.jsp" %>