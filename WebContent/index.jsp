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
      <img src="images/main/bg1.webp" alt="...">
      <div class="carousel-caption">
      </div>
    </div>
    <div class="item">
      <img src="images/main/bg2.webp" alt="...">
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
  	  		<p>당신에게 딱 맞는 신제품</p>
  	  	</div>
  	  	<section class="container-fluid">
  	  	<div class="row">
  			<div class="col-md-4">
  			<img src="images/main/iphone1.jpg" alt=""/></div>
  			<div class="col-md-4">
  			<img src="images/main/iphone1.jpg" alt=""/>
  			</div>
  			<div class="col-md-4">
  			<img src="images/main/iphone1.jpg" alt=""/>
  			</div>
  		</div>
  		<div class="row">
  			<div class="col-md-4">
  			<img src="images/main/iphone2.jpg" alt=""/></div>
  			<div class="col-md-4">
  			<img src="images/main/iphone2.jpg" alt=""/>
  			</div>
  			<div class="col-md-4">
  			<img src="images/main/iphone2.jpg" alt=""/>
  			</div>
  		</div>
  	  	</section>

<%@ include file="footer.jsp" %>
