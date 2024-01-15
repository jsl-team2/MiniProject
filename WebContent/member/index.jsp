<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>
     <link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/index.css">
   
    <!-- Bootstrap -->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    
  </head>
  <body>
  
  	<nav>
  	<div class="nav__left">
  	<a href="#">LOGO</a></div>
  	<div class="nav__middle">
  		<span class="glyphicon glyphicon-search"></span><input class="search-input" type="text">
  	</div>
  	<div class="nav__right">
  		<ul>
  		<li>
  		<a href="#">회사정보</a>
  		</li>
  		<li>
  		<a href="#">제품목록</a>
  		</li>
  		<li>
  		<a href="#">고객센터</a>
  		</li>
  		<li class="drop-down">
  		<a href="#" class="glyphicon glyphicon-user"></a>
  		<div class="drop-down__div">
	<div><a href="terms.do">회원가입</a></div>
	<div><a href="login.do">로그인</a></div>
	</div>
  </li>
  		</ul>
  	
  	</div>
  	
  	</nav>
  	
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
  	  	
  	
  	<footer>Copyright&copy;Start with this basic HTML template, or modify these examples. We hope you'll customize our templates and examples, adapting them to suit your needs.</footer>
  	   <script src="js/jquery-1.12.4.min.js" ></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

    <!-- Include all compiled plugins (below), or include individual files as needed -->

  </body>
</html>