<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/header.jsp" %>

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- sub contents -->
<div class="sub_title">
	<!-- container end -->
</div>

<div class="container__join">
	<div class="con_title">
		<h1 style="text-align: center">会員加入</h1>
	</div>
	<div class="join_write col_989">
		<div class="list_con">
			<ul class="icon_type1">
				<li style="text-align: center">会員になって様々な経験をしてみてください。</li>
			</ul>
		</div>
		<form name="join" method="post" action="joinpro.do" id="join"
			onsubmit="return check()">
			<table class="table_write02"
				summary="회원가입을 위한 이름, 아이디, 비밀번호, 비밀번호확인, 소속, 유선전화번호, 휴대전화번호, 이메일, 주소, 본인확인질문, 본인확인답, 주활용사이트, 알림여부 정보 입력">
				<colgroup>
					<col width="160px">
					<col width="auto">
				</colgroup>
				<tbody id="joinDataBody">
					<tr>
						<th><label for="name">NAME</label></th>
						<td><input type="text" name="name" id="name" class="w300" placeholder="名前を入力してください">
						</td>
					</tr>
					<tr>
						<th><label for="id">ID<span class="must"><b> *</b></span></label></th>
						<td><input type="text" name="id" id="id" class="w300" placeholder="IDを入力してください" >
							<br>
							<p id="idmsg"></p></td>
					</tr>
					<tr>
						<th><label for="pw">PW<!-- <span class="must"><b>필수입력</b></span> --></label></th>
						<td><input type="password" name="pw" id="pw" class="w300"placeholder="パスワードを入力してください">
							<p class="guideTxt">
								<span class="tc_point"></span>
					</tr>
					<tr>
						<th><label for="pw2">PW<!-- <span class="must"><b>필수입력</b></span> --></label></th>
						<td><input type="password" name="pw2" id="pw2" class="w300"placeholder="パスワードを確認してください">
							<p id="pwmsg"></p></td>
					</tr>
					<tr>
						<th><label for="tel">PHONE<span class="must"><b> *</b></span></label></th>
						<td>
						
						<%-- <div class="form-group"> --%>
						
								<label for="phone" class="col-sm-2 control-label"></label>
								<div class="col-sm-10">
								
									<select class="form-control" name="phone1" required	id="selectPhone" style="width: 25%; display: inline-block;">
										<option value="010">010</option>
									</select> 
									
									- 
									<input type="text" name="phone2" class="form-control" id="phone1" style="width: 25%; display: inline-block;">
									- 
									<input type="text" name="phone3" class="form-control" required id="phone2" style="width: 25%; display: inline-block;">
									<!-- disabled:활성화안하겠다는 뜻 -->
								</div>
							<%-- </div>--%>
							</td>
					</tr>
					<tr>
						<th><label for="adress">ADDRESS<span class="must"><b> *</b></span></label></th>
						<td>
							<input type="text" id="sample6_postcode" 		name="sample6_postcode"	placeholder="郵便番号" > 
							<input type="button" onclick="sample6_execDaumPostcode()" value="郵便番号探し"><br>
							<input type="text" id="sample6_address"		 	name="sample6_address" placeholder="住所" required><br>
							<input type="text" id="sample6_detailAddress" 	name="sample6_detailAddress" 	placeholder="詳細住所" required> 
							<input type="text" id="sample6_extraAddress" 	name="sample6_extraAddress" placeholder="参考項目" required>
						</td>
					</tr>
					<tr>
    <th><label for="email">E-MAIL<span class="must"><b> *</b></span></label></th>
    <td>
        <input type="email" name="email" id="email" class="w300" placeholder="メールアドレス入力" style="width: 70%">
        <input type="button" id="btn_email" class="btn_email" value="認証番号送信">
        <p id="emailmsg"></p>
        <input type="password" name="certinumber" id="certinumber" class="w300" style="width: 35%" placeholder="認証番号">
        <input type="button" id="email_ok" value="認証番号確認">
    </td>
</tr>
			</table>
			<div class="btnArea Acenter pt60 pb100">
				<a href="javascript:history.go(-1);"
					class="btn_round_s btn_large_s btn_BlueGray_s w180"><b>取消</b></a>
				<!-- <a href="javascript:fn_save();"
					class="btn_round btn_large btn_pointColor w180"><b>회원등록</b></a> -->
				<!-- href 다음에 자바스크립트 함수 호출 javascript:fn_save()  -->
				<input type="submit" value="会員登録" style="border: none"
					class="btn_round_s btn_large_s btn_pointColor_s w180 ">
			</div>
		</form>
	</div>
</div>
<!-- end contents -->

<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function sample6_execDaumPostcode() {
	new daum.Postcode(
			{
				oncomplete : function(data) {
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

					// 각 주소의 노출 규칙에 따라 주소를 조합한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var addr = ''; // 주소 변수
					var extraAddr = ''; // 참고항목 변수

					//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
					if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
						addr = data.roadAddress;
					} else { // 사용자가 지번 주소를 선택했을 경우(J)
						addr = data.jibunAddress;
					}

					// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
					if (data.userSelectedType === 'R') {
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== ''
								&& /[동|로|가]$/g.test(data.bname)) {
							extraAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== ''
								&& data.apartment === 'Y') {
							extraAddr += (extraAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraAddr !== '') {
							extraAddr = ' (' + extraAddr + ')';
						}
						// 조합된 참고항목을 해당 필드에 넣는다.
						document.getElementById("sample6_extraAddress").value = extraAddr;

					} else {
						document.getElementById("sample6_extraAddress").value = '';
					}

					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById('sample6_postcode').value = data.zonecode;
					document.getElementById("sample6_address").value = addr;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("sample6_detailAddress")
							.focus();
				}
			}).open();
}
</script>
<script>

	$("#btn_join").on(
			"click",
			function() {
				var data = {
					name : $("#name").val(),
					id : $("#id").val(),
					pw : $("#pw").val(),
					pw2 : $("#pw2").val(),
					
					phone : $("#selectPhone").val()+$("#phone1").val()+$("#phone2").val(),
					address : $("#sample6_postcode").val() + $("#sample6_address").val() + $("#sample6_detailAddress").val()
							+ $("#sample6_extraAddress").val(),
							
					email : $("#email").val(),
					certinumber : $("#certinumber").val()
				};

				$.ajax({
					type : "post",
					url : "joinpro.do",
					data : data,
					success : function(data) {
						if (data.check == "ok") {
							alert("회원가입이 완료되었습니다.");
							history.go(-1);
						} else {
							alert(data.msg);
						}
					},
					error : function() {
						alert("통신에러!");
					}
				});
			});
</script>

<script>
function check() { // 자바스크립트 문법
    if(!join.name.value){ // member.name.value == ""
       alert("이름을 입력하세요");
       join.name.focus();
       return false;
    }   
  if(!join.id.value){ // member.name.value == ""
     alert("아이디 입력하세요");
     join.id.focus();
     return false;
  }   
  if(!join.pw.value){ // member.name.value == ""
      alert("비밀번호 입력하세요");
      join.pw.focus();
      return false;
   }   
  if(!join.pw2.value){ // member.name.value == ""
      alert("비밀번호 확인하세요");
      join.pw2.focus();
      return false;
   }   
  if(!join.phone.value){ // member.name.value == ""
      alert("휴대폰 번호를 입력하세요");
      join.phone.focus();
      return false;
   }   
  if(!join.address.value){ // member.name.value == ""
      alert("주소를 입력하세요");
      join.addrss.focus();
      return false;
   }   
  if(!join.email.value){ // member.name.value == ""
      alert("email 입력하세요");
      join.email.focus();
      return false;
   }   
 }

</script>

<script>
$(function() { // jquery 문법
   $(".location  .dropdown > a").on("click",function(e) {
      e.preventDefault();
      if($(this).next().is(":visible")) {
         $(".location  .dropdown > a").next().hide();
      } else {
         $(".location  .dropdown > a").next().hide();
         $(this).next().show();
      }
   });
    $("#id").blur(function() {
       if(!$("#id").val()) {
         $("#idmsg").html("<span style='color:#f00;'>아이디는 필수 입력사항 입니다</span>");
       }else {
         $("#idmsg").html("");
       }
       
      $.ajax({
          type:'post', //비동기식 데이터 전송방식
           url:'memberidcheck.do', // 서버에게 보내는 url 주소
       data:{id:$("#id").val()}, // 서버에게 보내는 데이터
       success:function(data) {  // 비동기식 데이터 처리가 성공했을때
          if(data != 1){
             if($("#id").val() != "") {
                $("#idmsg").html("<span style='color:#0f0;'>사용가능 합니다</span>");
             }
          }else{
             if($("#id").val() != ""){
                $("#idmsg").html("<span style='color:#f00;'>사용할 수 없는 아이디 입니다.</span>");
                $("#id").val("");
                $("#id").focus();
             }
          }
       }, 
       
       
        })
            
    }) //

    $("#pw2").blur(function() {
       var pw1 = $("#pw").val();
       var pw2 = $("#pw2").val();
       if(pw1 != pw2) {
          $("#pwmsg").html("<span style='color:#f00;'>비밀번호 확인 바랍니다</span>");
      }else {
         $("#pwmsg").html("<span style='color:#0f0;'>비밀번호가 일치 합니다</span>");
      }
       
    })
    
$("#btn_email").on("click", function(){
     var email = $("#email").val();
     if(email == ""){
        alert("이메일 주소를 입력하세요.");
        $("#email").focus();
     } else {
        $.ajax({
           type:'post',
           url:'emailsend.do',
           data:{"email":$("#email").val()},
           dataType:'json', //서버에서 return해주는 값은 json형식{key:value}의 데이터 값으로 받겠다
           success:function(data){
              alert(data.check);
           }, error:function(){
              alert("통신에러");
           }
        })
     }
  })
  
  //인증확인
  $("#email_ok").on("click", function() {
  	var certinumber = $("#certinumber").val();
  	if(certinumber == "") {
  		alert("인증번호 입력");
  		$("#certinumber").focus();
  	}else{
  		$.ajax({
  		type:"post",
  		data:{"certinumber":certinumber},
  		url:"certinumber.do",
  		dataType:"json",
  		success:function(data){
  			if(data.check == "nok") {
  				alert(data.mag);
  				}else{
  					
  					alert(data.msg);
  				}
  			},error:function() {
  				alert("통신에러!");
  			}
  		})
		 }
 	 })
});
</script>
<%@ include file="/footer.jsp" %>
<script src="js/bootstrap.min.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->