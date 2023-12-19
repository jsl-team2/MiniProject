<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>joinmembership</title>

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
		alert("로그인이 완료되었습니다.");
		return true;
		}
	function resetAlert() {
		alert("입력한 정보를 다시 입력합니다!");
		my.user.id.focus();
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
					<a class="navbar-brand" href="navbar.jsp">project</a>

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
			</div>
		</nav>
	</div>
	
	  <div class="col-lg-9">
            <h2 class="title">Project 로그인</h2>
           
            <div class="col-lg-12">

               <form class="form-horizontal" name="my" method="post" action="login2.jsp" onsubmit="return check()">
                  <div class="form-group">
                     <label for="id" class="col-sm-2 control-label">ID</label>
                     <div class="col-sm-10">
                        <input type="text" name="id" class="form-control" id="id" style ="width:40%" placeholder="6글자 이상 아이디를 입력하세요">
                     </div>
                  </div>
                  <div class="form-group">
                     <label for="pw" class="col-sm-2 control-label">PASSWORD</label>
                     <div class="col-sm-10">
                        <input type="password" name="pw" class="form-control" id="pw"
                          style ="width:40%" placeholder="패스워드를 입력하세요">
                     </div>
                  </div>
                  <div class="form-group">
                     <div class="col-sm-offset-2 col-sm-10">
                        <div class="checkbox">
                           <label> <input type="checkbox"> ID저장</label>
                        </div>
                     </div>
                     </div>
                  <div class="form-group">
                     <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-danger">로그인</button>
                         <button type="reset" class="btn btn-warning" onclick="resetAlert()">다시쓰기</button>
                     </div>
                  </div>
                </form>
            </div>
        </div>
<script> 
	let id = $('#id');
	let pw = $('#pw');
	let btn = $('#btn');
	
	$(btn).on('click',function(){
		if($(id).val() == "") {
			$(id).next('label').addClass('warning');
		}
		else if($(pw).val() == ""){
			$(id).next('label').addClass('warning');
			
		}	
	};
</script>	
	<script src="js/jquery-1.12.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	
</body>
</html>