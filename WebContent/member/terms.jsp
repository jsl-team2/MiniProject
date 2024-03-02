<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Parcel Sandbox</title>
<meta charset="UTF-8" />
</head>
<div class="logoterms">
</div>
<body>
	<div class="terms__wrap">
		<div class="contents">
			<form action="/join.do" method="POST" id="form__wrap">
				<div class="terms__check__all">
					<label for="checkAll"> 利用弱冠、個人情報の収集·利用、プロモーション情報の受信(選択)にすべて
						同意します。</label> <input type="checkbox" name="checkAll" id="checkAll">
				</div>
				<ul class="terms__list">
					<li class="terms__box">
						<div class="input__check">
							<input type="checkbox" name="agreement" id="termsOfService"
								value="termsOfService" class="required" /> <label
								for="termsOfService" class="required">利用約款同意 </label>
						</div>
						<div class="terms__content">皆さんを歓迎します。 galaxy サービス及び製品（以下
「サービス」）をご利用いただきありがとうございます。 本約款は、様々なGalaxyサービスの利用に関連して、Galaxyサービスを
提供するgalaxy株式会社（以下「galaxy」という。）と、それを利用するgalaxyサービス会員（以下「会員」という。）又は
非会員との関係を説明するとともに、皆様のGalaxyサービス利用に役立つ有益な情報を含め
あります. galaxyサービスをご利用いただくか、galaxyサービス会員としてご登録いただく場合、皆様は本約款および関連
運営ポリシーを確認したり同意したりすることになりますので、しばらくお時間を割いて、注意深くご覧ください。</div>
					</li>
					<li class="terms__box">
						<div class="input__check">
							<input type="checkbox" name="agreement" id="privacyPolicy"
								value="privacyPolicy" class="required" /> <label
								for="privacyPolicy" class="required"> 個人情報の収集及び利用に関する同意 </label>
						</div>
						<div class="terms__content">個人情報保護法に基づき、Galaxyに会員登録を申請する
方に収集する個人情報の項目、個人情報の収集及び利用目的、個人情報の保有及び利用期間、同意拒否権及び同意
拒否時の不利益に関する事項をご案内いたしますので、詳しくお読みの上、同意してください。1. 収集する個人情報利用者は
会員登録をしなくても情報検索、ニュース表示など大部分のネイバーサービスを会員と同じように利用することができます。
利用者がメール、カレンダー、カフェ、ブログなどのように個人化または会員制サービスを利用するために会員登録をする場合、
ネイバーはサービス利用のために必要最小限の個人情報を収集します。</div>
					</li>
					<li class="terms__box">
						<div class="input__check">
							<input type="checkbox" name="agreement" id="allowPromotions"
								value="allowPromotions" /> <label for="allowPromotions"
								class="required promotion">プロモーション情報の受信同意 </label>
						</div>
						<div class="terms__content">galaxyが提供するイベント/特典など様々な情報を
携帯電話(Galaxyアプリの通知またはメッセージ)、Eメールで受け取ることができます。 一部のサービス(別途会員制で運営したり
galaxy加入後、追加加入して利用するサービスなど)の場合、個別サービスに対して別途受信同意を受けることができる
あり、この際にも受信同意について別途ご案内し同意を得ます ネイバーはサービス利用のために必要最小限の個人情報を収集します。</div>
					</li>
				</ul>
				<button type="submit" class="next-button" disabled>確認</button>
			</form>
		</div>
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
		// "모두 동의" 체크박스의 상태에 따라 "필수" 동의 체크박스들과 "프로모션 정보 수신 동의" 체크박스들을 업데이트
		requiredCheckboxes.forEach(checkbox => {
			checkbox.checked = checkAllCheckbox.checked;
		});

		// "프로모션 정보 수신 동의" 체크박스도 업데이트
		allowPromotionsCheckbox.checked = checkAllCheckbox.checked;

		// 확인 버튼을 활성화
		submitButton.disabled = !checkAllCheckbox.checked;
		});

		// "이용약관" 체크박스의 변경 이벤트에 대한 핸들러 등록
		termsOfService.addEventListener('change', function () {
		// "이용약관" 체크박스의 상태에 따라 확인 버튼의 활성화/비활성화 상태 업데이트
		checkRequiredCheckboxes();
		});

		// "개인정보 수집 및 이용" 체크박스의 변경 이벤트에 대한 핸들러 등록
		privacyPolicy.addEventListener('change', function () {
		// "개인정보 수집 및 이용" 체크박스의 상태에 따라 확인 버튼의 활성화/비활성화 상태 업데이트
		checkRequiredCheckboxes();
		});

		// "프로모션 정보 수신 동의" 체크박스의 변경 이벤트에 대한 핸들러 등록
		allowPromotionsCheckbox.addEventListener('change', function () {
		// "프로모션 정보 수신 동의" 체크박스의 상태에 따라 확인 버튼의 활성화/비활성화 상태 업데이트
		checkRequiredCheckboxes();
		});

		function checkRequiredCheckboxes() {
		  // "이용약관" 체크박스와 "개인정보 수집 및 이용" 체크박스 중 하나 이상이 체크되어 있는지 확인
		  const bothChecked = (
		    termsOfService.checked && privacyPolicy.checked
		  ) || checkAllCheckbox.checked;

		  submitButton.disabled = !bothChecked;


		  // 모두 동의 체크박스가 체크되어 있지 않은 경우 확인 버튼을 비활성화

		  // "이용약관" 체크박스와 "개인정보 수집 및 이용" 체크박스 모두 체크되었을 때 확인 버튼을 클릭
		  if (
		    termsOfService.checked &&
		    privacyPolicy.checked
		  ) {
		  }
		}
	});
	</script>
</body>
</html>
<%@ include file="/footer.jsp"%>
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/jquery-1.12.4.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
