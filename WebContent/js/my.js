// jquery 시작
// $(document) 선택자 : 어느 선택자에게~
// ready() 함수

// $(document).ready(function() { jquery 시작문
$(function() { // 위 문장을 줄여서 쓸 수 있다
		
//	function total(n) {
		
//	}
	var total = function(n) { // function total(n)과 같은 문장
		// java script에서 변수선언 하는 방법 let var const
		var price1 = document.getElementById("price");
//		alert(price1.dataset.price);
		var price = price1.dataset.price; // 가격
//		alert(price);
		var amount = $(".quantity").attr("value"); // 수량 attr() 속성함수 / 값을 가져올때
		var amount = parseInt(amount); // parseInt() 숫자변환
		var amount = amount + n; // 전체 수량
		if(amount < 1) {
			amount = 1;
			alert("최소 구매 수량은 1개 입니다");
		}
		
		var tot = price * amount; // 총액 = 단가 * 수량
		$(".quantity").attr("value", amount);
		
		//정규표현식
		var regexp = /\B(?=(\d{3})+(?!\d))/g;
		var tot = tot.toString().replace(regexp,',');
		$(".total").html(tot + "("+amount+" 개)");
	} 
	// .on 마우스 이벤트 핸들러
	$(".plus").on("click", function() {
		total(1);
	})
	
	$(".minus").on("click", function() {
		total(-1);
	})
	
	$("#selectEmail").change(function() {
		$("#selectEmail option:selected").each(function() { /* .each 반복 */
			if($(this).val()=='1') {
				$("#email2").val(''); /* value를 넣어라 */
				$("#email2").attr("disabled", false);
			}else{ // 직접입력이 아닌경우
				$("#email2").val($(this).text()); // 선택값 입력
				$("#email2").attr("disabled", true);
			}
			
		})
	})
	
	
})
// })

