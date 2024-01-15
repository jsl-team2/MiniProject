<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/login.css">
  <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>

<body>

<section class="login-form">
  <h1>Welcome</h1>
  <form name="login" action="loginpro.do" method="post" onsubmit="javascript:fn_login();">
    <div class="int-area">
      <input type="text" name="id" id="id" autocomplete="off" required>
      <label for="id">USER NAME</label>
    </div>
    <div class="int-area">
      <input type="password" name="pw" id="pw" autocomplete="off" required>
      <label for="pw">PASSWORD</label>
    </div>
    <div class="btn-area">
      <button id ="btn" type="submit">LOGIN</button>
    </div>
  </form>
  <div class="caption">
    <a href="join.do">Would you like to sign up as a member?</a>
  </div>
</section>

<script>


$(document).ready(function () {
	  let id = $('#id');
	  let pw = $('#pw');
	  let btn = $('.btn-area button');

	  if ($(id).val() === "" || $(pw).val() === "") {
	    $(id).next('label').addClass('warning');
	    $(pw).next('label').addClass('warning');
	    setTimeout(function () {
	      $('label').removeClass('warning');
	    }, 1500);
	  } else {
	    // 아이디와 비밀번호가 모두 입력된 경우
	    $.ajax({
	      url: '/loginpro.do',
	      data: {
	        id: $(id).val(),
	        pw: $(pw).val()
	      },
	      dataType: 'json',
	      success: function (data) {
	        if (data.result === 'success') {
	          // 로그인 성공
	          location.href = '/main.do';
	        } else {
	          // 로그인 실패
	          alert('아이디 또는 비밀번호가 틀렸습니다.');
	        }
	      }
	    });
	  }
	});

</script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
</body>
</html>