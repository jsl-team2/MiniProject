<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/header.jsp" %>

<div class="container1">
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
    <a href="terms.do">Would you like to sign up as a member?</a>
  </div>
</section>
</div>
<script>


document.addEventListener('DOMContentLoaded', function () {
    // "모두 동의" 체크박스
    const checkAllCheckbox = document.getElementById('checkAll');

    // "필수" 동의 체크박스들
    const requiredCheckboxes = document.querySelectorAll('.terms__list .required');

    // "프로모션 정보 수신 동의" 체크박스
    const allowPromotionsCheckbox = document.getElementById('allowPromotions');

    // 확인 버튼
    const submitButton = document.querySelector('.next-button');

    // "모두 동의" 체크박스의 변경 이벤트에 대한 핸들러 등록
    checkAllCheckbox.addEventListener('change', function () {
        // "모두 동의" 체크박스의 상태에 따라 "필수" 동의 체크박스들을 업데이트
        requiredCheckboxes.forEach(checkbox => {
            checkbox.checked = checkAllCheckbox.checked;
        });

        // "프로모션 정보 수신 동의" 체크박스도 업데이트
        allowPromotionsCheckbox.checked = checkAllCheckbox.checked;

        // 확인 버튼의 활성화/비활성화 상태 업데이트
        submitButton.disabled = !checkAllCheckbox.checked || !areAllRequiredChecked();
    });

    // "필수" 동의 체크박스들의 변경 이벤트에 대한 핸들러 등록
    requiredCheckboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            // "모두 동의" 체크박스의 상태 업데이트
            checkAllCheckbox.checked = areAllRequiredChecked();

            // "프로모션 정보 수신 동의" 체크박스도 업데이트
            allowPromotionsCheckbox.checked = checkAllCheckbox.checked;

            // 확인 버튼의 활성화/비활성화 상태 업데이트
            submitButton.disabled = !checkAllCheckbox.checked || !areAllRequiredChecked();
        });
    });

    // "프로모션 정보 수신 동의" 체크박스의 변경 이벤트에 대한 핸들러 등록
    allowPromotionsCheckbox.addEventListener('change', function () {
        // 확인 버튼의 활성화/비활성화 상태 업데이트
        submitButton.disabled = !checkAllCheckbox.checked || !areAllRequiredChecked();
    });

    // 초기 상태에서 확인 버튼의 상태 업데이트
    submitButton.disabled = true;
});

// 모든 "필수" 동의 체크박스가 체크되었는지 확인하는 함수
function areAllRequiredChecked() {
    return [...requiredCheckboxes].every(checkbox => checkbox.checked);
}


</script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<%@ include file="/footer.jsp" %>
