<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%
  // 사용자 정보 가져오기
  String user = (String) session.getAttribute("user_id"); // 여기서 "user"는 세션에 저장된 사용자 정보 객체의 키일 수 있습니다.

  // 로그인 여부 확인
   String user_id = (user != null) ? user : "";
  boolean LoginID = user != null;
%>
	
	
<%@ include file="/header.jsp"%>

<div class="container-fluid board_subvisual ">

</div>

<div class="container boardD">
	<div class="board_title">
	<h2>${view.board_title }</h2>
	</div>
	<div class="board_view">
		<div class="board_view2">
			<div class="detail-attr board_writer">
				<div class="board_detail">投稿者</div>
				<div class="board_value">${view.board_writer}</div>
			</div>	
			<div class="detail-attr board_date">
				<div class="board_detail">作成日</div>
				<div class="board_value">${view.board_date.substring(0,10) }</div>
			</div>	
			<div class="detail-attr board_hits">
				<div class="board_detail">ヒット数</div>
				<div class="board_value">👁‍🗨${view.board_hits}</div>
			</div>	
		</div>
		<div class="board_body">
			<p>${view.board_content }</p>
		</div>
		<!-- 위에가 list출력 -->

		<!-- 밑에부터 페이지 이동 기능 -->
		<div class="prev_next">
			<a href="boardview.do?board_no=${prev.getBoard_no() }"
				class="btn_prev"> <i class="fa fa-angle-left"></i> <span
				class="prev_wrap"> 
				<strong>以前</strong><span>${prev.getBoard_title() }</span>
			</span>
			</a>

			<div class="board_btn_3wrap">
				<a href="board.do" style="background:#8a6d3bcf;">リスト</a> 
				<c:if test="${view.board_writer eq user_id || user_id eq 'admin' }">
				<a href="boardmodify.do?board_no=${view.board_no }" style="background:#BF3131;">修正</a> 
				<a href="boarddelete.do?board_no=${view.board_no }" style="background:#BF3131;"
					onClick="return confirm('삭제하시겠습니까?')">削除</a>
				</c:if>
			</div>
			<a href="boardview.do?board_no=${next.getBoard_no() }"
				class="btn_next"> <span class="next_wrap"> 
				<strong>以降</strong><span>${next.getBoard_title() }</span>
			</span> <i class="fa fa-angle-right"></i></a>
		</div>
	</div>
</div>

<!-- 댓글 기능 시작  -->
<div class="container commentarea" style="padding-bottom: 35px;">
<div class="board_list_area" style="padding-bottom: 35px;">
<table style="width: 100%;">
	<thead>
		<tr>
			<th style = "width: 10%;">ID</th>
			<th style = "width: 67%;">コメント</th>
			<th style = "width: 10%;">作成日</th>
			<th style = "width: 13%;">編集</th>
		</tr>
	</thead>
	<tbody>
	
	<c:forEach var="Clist" items="${Clist }">
	<tr class="Clist" style="display:none;">
		<td>${Clist.comment_id}</td>
			<td>
				<c:if test="${Clist.comment_secret eq 1}">
				 <c:choose>
			              <c:when test="${Clist.comment_id eq user_id || user_id eq 'user_id' || user_id eq 'admin'}">
			                  <c:out value="${Clist.comment_content}"/>
			              </c:when>
			              <c:otherwise>非公開コメントは投稿者と管理人しか見れません。</c:otherwise>
			          </c:choose>
				</c:if>
				<c:if test="${Clist.comment_secret eq 0}" >
			          <c:out value="${Clist.comment_content}"/>
			      	</c:if>
				</td>
				<td>${Clist.comment_createdate.substring(0,10) }</td>
				<td>
				<div class="board_button" >
				<c:if test="${Clist.comment_id eq user_id || user_id eq 'admin' }">
					<div class="col-sm-6" >
						<button class="btn btn-sm modifybtn" id="Omodal"
							onclick="openModal('id_reply_edit_modal_${Clist.comment_no}')"
							style="color: #fff; background: #8a6d3bcf ; margin:0 -15px 0 0;">修正
						</button>
					</div>
					<div class="col-sm-6" >
						<a href="commentdelete.do?comment_no=${Clist.comment_no}&board_no=${Clist.board_no}">
						<button type="submit" class="btn btn-sm btn-info" role="button"
							style="background-color: #8a6d3b69 ; color: #fff; margin:0 0 0 -15px;">削除
						</button>
						</a> 
					</div>
				</c:if>
				</div>
		<!-- 댓글 기능 끝 -->
			</td>
		</tr>
		
		<div class="modal" id="id_reply_edit_modal_${Clist.comment_no}">
		<div class="modal-dialog" style="margin: 200px auto;">
			<!-- Modal content-->
			<div class="modal-content">
				<form name="commentmodify" action="commentmodify.do"
					method="post" onsubmit="return check2();">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"></button>
						<h4 class="modal-title">コメント修正</h4>
					</div>

					<div class="modal-body">
						<input type="hidden" name="comment_no"
							value="${Clist.comment_no }">
						<textarea rows="3" name="reContent" class="form-control">${Clist.comment_content }</textarea>
						<input type="hidden" name="reMemId" value="${user_id }">
						<input type="hidden" name="board_no"
							value="${Clist.board_no}"> <input type="hidden"
							name="redate" value="${Clist.comment_createdate }">
						<input type="hidden" id="selectedValueHidden"
							name="selectedValueHidden" value=""> <input
							type="hidden" id="selectedOrderNo" name="selectedOrderNo"
							value="${Clist.comment_no}">
					</div>

					<div class="modal-footer">
					<input type="radio" name="comment_secret" value="0" checked>公開
                    <input class="form-check-input" type="radio" name="comment_secret" id="comment_secret_checkbox" value="1"
                    <%= LoginID ? "" : "disabled" %> onchange="updateCommentSecretValue(this)"> 非公開
                    <br/>
						<button id="btn_reply_modify" type="submit" style="background: #8a6d3bcf;"
							class="btn btn-sm btn-info">設定</button>
						<button type="button" class="btn btn-default btn-sm" style="background: #e6e6e6;"
							onclick="closeModal()">閉じる</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	</c:forEach>
		
			</tbody>
			
			<!-- 더보기 기능 시작 -->
		<tr class="hidden-comment-row">
			<td colspan="4">
				<button type="button" id="BoardMorebtn" class="btn btn-default board_btn-block" >&#9660;続きを読む</button>
			</td>
		</tr>
	<!-- 더보기 기능 끝 -->
	
		</table>
	</div>


<div class="board_panel panel-default">
    <div class="board_panel-body form-horizontal">
        <form name="commentList" action="commentinsert.do" method="post" onsubmit="return validateForm();">
            <input type="hidden" name="board_no" value="${view.board_no}">
            <input type="hidden" name="comment_id" value="<%= user_id %>">
            
            <div class="form-group">
                <label class="col-sm-2 control-label" style="padding-top: 40px; text-align: center; padding-left: 45px;">コメント</label>
                
                <div class="col-sm-8">
                    <textarea rows="3" id="board_content" name="board_content" 
                    class="board_content" <%= LoginID ? "" : "disabled" %>></textarea>
                </div>
                
                <div class="col-sm-2" style="text-align: center;">
                    <div class="board_K">
                    <button id="comment_regist" type="submit" class="btn btn-sm btn-list1"
                    style="font-size: 15px; background: #8a6d3bcf; margin-top: 15px;" 
                    <%= LoginID ? "" : "disabled" %>>登録</button>
                    </div>
                 <div>
				    <input type="hidden" name="comment_secret" id="comment_secret_value" value="0">
				    <input class="form-check-input" type="checkbox" name="comment_secret" id="comment_secret_value" value="1"
			           <%= LoginID ? "" : "disabled" %> onchange="updateCommentSecretValue(this)">非公開
				</div>
                </div>
            </div>
        </form>
    </div>
</div>
</div>
<script>
	$(function() {
		$(".location  .dropdown > a").on("click", function(e) {
			e.preventDefault();
			if ($(this).next().is(":visible")) {
				$(".location  .dropdown > a").next().hide();
			} else {
				$(".location  .dropdown > a").next().hide();
				$(this).next().show();
			}
		});
	});
</script>

<script>
	function check() {
		if (commentList.Content.value == "") {
			alert("コメントを入力してください。");
			commentList.Content.focus();
			return false;
		}

		var content = document.getElementById("board_content");
		commentList.content.value = content.value.replace(/(\n|\r\n)/g, '<br>');
		return true;
	}
</script>

<script>
function check2() {
	if (commentmodify.reContent.value.trim() == "") {
		alert("修正内容を入力してください。");
		commentmodify.reContent.focus();
		return false;
	}

	var content = commentmodify.reContent;
	content.value = content.value.replace(/\n|\r\n/g, "<br>");
	commentmodify.reContent.value = content.value;
	return true;
}
</script>



<!-- <script>
document.getElementById('comment_regist').addEventListener('click', function() {
    var radioButtons = document.querySelectorAll('input[name="comment_secret"]:checked');
    
    if (radioButtons.length === 0) {
        alert('コメントを公開しますか？');
        event.preventDefault();
    }
});
</script> -->

<script>
document.getElementById('btn_reply_modify').addEventListener('click', function() {
    var radioButtons = document.querySelectorAll('input[name="comment_secret"]:checked');
    
    if (radioButtons.length === 0) {
        alert('コメントを公開しますか？');
        event.preventDefault();
    }
});
</script>

<script>
function validateForm() {
    var textareaValue = document.querySelector('.board_content').value.trim();

    console.log("Textarea Value:", textareaValue); // 디버깅 메시지

    if (textareaValue === null || textareaValue === "") {
        alert('コメントを入力してください。');
        return false; // 폼 제출을 막음
    }

    return true; // 폼 제출을 허용
}
</script>

<script>
function updateCommentSecretValue(checkbox) {
    var valueInput = document.getElementById('comment_secret_value');

    if (checkbox.checked) {
        valueInput.value = "1";
    } else {
        valueInput.value = "0";
    }
}
</script>

<script>
$(function () {
	var loadNum = 5;
	var currentShown = loadNum; 
	
	$(".Clist").slice(0,5).show();
	
	$("#BoardMorebtn").click(function(e){
		e.preventDefault();
		var hidden = $(".Clist:hidden");
		var nextThing = hidden.slice(0,loadNum);
		
		nextThing.show();
		currentShown += loadNum;
			
		if(currentShown >= $(".Clist").length){
			alert('더이상 존재하지 않습니다.');
			$("#BoardMorebtn").hide();
		}
	});
	
});

</script>


<script>
	var selectedOrderNo; // 모달을 열 때 선택된 주문 번호를 저장할 변수

	function openModal(modalId) {
		selectedOrderNo = modalId; // 선택된 모달 ID 저장
		document.getElementById(modalId).style.display = "block";
	}

	function closeModal() {
		document.getElementById(selectedOrderNo).style.display = "none";
	}
</script>

<%@ include file="/footer.jsp"%>