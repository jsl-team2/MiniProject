<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Project</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/mystyle.css">

<!--[if lt IE 9]>
      <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
<script>
	function check() {
		if (my.id.value == "") {
			alert("아이디가 입력되지 않았습니다!");
			my.id.focus();
			return false;
		}
		if (my.pw.value == "") {
			alert("비밀번호를 입력하세요");
			my.pw.focus();
			return false;
		}
		if (my.nam.value == "") {
			alert("이름을 입력하세요");
			my.nam.focus();
			return false;
		}
		if (my.phone.value == "") {
			alert("휴대폰번호가 입력되지 않았습니다!");
			my.phone.focus();
			return false;
		}
		if (my.email.value == "") {
			alert("이메일을 입력하세요");
			my.email.focus();
			return false;
		}
		if (my.address.value == "") {
			alert("주소가 입력되지 않았습니다");
			my.address.focus();
			return false;
		}
		alert("회원가입이 완료되었습니다.");
		return true;
	}
	function resetAlert() {
		alert("정보를 지우고 처음부터 다시 입력합니다!");
		my.user_id.focus();
		return false;
	}
</script>
</head>


<body>
	<div class="container-fluid">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="navbar.jsp">PROJECT</a>
				</div>

				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false"><span class="glyphicon glyphicon-user"></span>
							<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="singup.jsp">회원가입</a></li>
							<li><a href="login.jsp">로그인</a></li>
							<li><a href="logout.html">로그아웃</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="mypage.html">MY Page</a></li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- /.container-fluid -->

	<!-- sub visual -->


	<!-- sub contents -->

	<div class="row">
		<div class="col-lg-9">
			<h2 class="title">회원가입</h2>
			<div class="col-lg-12">
				
				<section>
					<form class="form-horizontal" name="my" method="post"
						action="singupPro.jsp" onsubmit="return check()">
						<div class="form-group">
							<label for="id" class="col-sm-2 control-label">ID</label>
							<div class="col-sm-10">
								<input type="text" name="id" class="form-control" id="id"
									style ="width:40%" placeholder="6글자 이상 아이디를 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="pw" class="col-sm-2 control-label">PW</label>
							<div class="col-sm-10">
								<input type="password" name="pw" class="form-control" id="pw"
									 style ="width:40%" placeholder="패스워드를 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="nam" class="col-sm-2 control-label">NAME</label>
							<div class="col-sm-10">
								<input type="text" name="nam" class="form-control" id="nam"
									 style ="width:40%" placeholder="이름을 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-sm-2 control-label">PHONE</label>
							<div class="col-sm-10">
								<select class="form-control" name="selectPhone" id="selectPhone"
									style="width: 12%; display: inline-block;">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="012">012</option>
								</select> 
								<input type="text" name="phoneID" class="form-control"
									id="phone1" style="width: 12%; display: inline-block;">
								<input type="text" name="phone" class="form-control" id="phone2"
									style="width: 12%; display: inline-block;">
								<!-- disabled:활성화안하겠다는 뜻 -->
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">EMAIL</label>
							<div class="col-sm-10">
								<input type="text" name="emailId" class="form-control"
									id="email1" style="width: 20%; display: inline-block"
									placeholder="이름을 입력하세요">@ <input type="text"
									name="email" class="form-control" id="email2"
									style="width: 20%; display: inline-block;">
								<!-- disabled:활성화안하겠다는 뜻 -->
								<select class="form-control" name="selectEmail" id="selectEmail"
									style="width: 20%; display: inline-block;">
									<option value="1">직접입력</option>
									<option value="naver.com">naver.com</option>
									<option value="gmail.com">gmail.com</option>
									<option value="nate.com">nate.com</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-sm-2 control-label">ADDRESS</label>
							<div class="col-sm-10">
								<input type="text" name="address" class="form-control" id="address"
									style ="width:65%" placeholder="주소를 입력하세요 ">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-danger" >회원가입</button>
								<button type="reset" class="btn btn-warning"
									onclick="resetAlert()">다시쓰기</button>
							</div>
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
	<!-- footer -->
	<div class="container-fluid footer">
		<div class="container">
			<div class="col-lg-2">
				<h2>LOGO</h2>
			</div>
			<div class="col-lg-10">
				<p>CopyRight All Rights Reserved</p>
			</div>
		</div>
	</div>



	<!-- jQuery (자주사용하는 기능을 자바스크립트언어로 만들어 놓은 함수들) -->
	<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/my.js"></script>

</body>
</html>