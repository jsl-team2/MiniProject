<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>MiniProject</title>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/product.css">
<link rel="stylesheet" href="css/search.css">
<link rel="stylesheet" href="css/mystyle.css">

<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/productadd.css">

  <link rel ="stylesheet" href="css/board.css">





<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div style="padding: 0 100px">
		<nav>
			<div class="nav__left">
				<a href="main.do"><img class="logo" alt=""
					src="images/team_logo2.jpg"></a>
			</div>
			<div class="nav__middle">
				<form class="searchForm" name="searchForm" method="get"
					action="search.do">
					<span style="position: relative; left:55px;"
						class="glyphicon glyphicon-search"></span><input name="keyword"
						class="search-input" type="text">
				</form>
			</div>
			<div class="nav__right">
				<ul>
					<li><a href="productlist.do">製品リスト</a></li>
					<li><a href="/board.do">カスタマーセンター</a></li>
					<li class="drop-down"><a href="#"
						class="glyphicon glyphicon-user"></a>
						<div class="drop-down__div">
							<c:choose>
								<c:when test="${empty user_id }">
									<div class="first">
										 <a href="login.do">ログイン</a>
									</div>
									<div>
										<a href="terms.do">会員加入</a>
									</div>
								</c:when>
								<c:when test="${not empty user_id && user_id != 'admin' }">
									<div class="first">
										<a href="logout.do">ログアウト</a>
									</div>
									<div>
										<a href="myorder.do">個人注文の内訳</a>
									</div>
									</c:when>
									
								<c:when test="${not empty user_id && user_id eq 'admin'}" >
								<div>
									<a href="logout.do">ログアウト</a>
								</div>
								<div>	
									<a href="admin.do">管理者ページ</a>
								</div>	
								</c:when>
							</c:choose>
						</div></li>
				</ul>
			</div>
		</nav>
	</div>
</body>