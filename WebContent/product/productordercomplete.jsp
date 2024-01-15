<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/header.jsp"%>

<!-- sub contents -->
<div class="container contents"
	style="margin: 0 auto; text-align: center;">
	<img src="images/product/ordercompletepic.png" alt=""
		style="width: 700px; height: auto;">
	<div class="ordercomplete">
		<p>ご注文が完了しました。</p>
		<p> ありがとうございます。</p>
		<p>注文番号 : ${orderno}</p>
	</div>

	<div style="text-align: center; margin-bottom: 30px;">
		<a href="main.do" class="btn btn-default btn-lg" role="button">ホーム</a>
		<a href="productlist.do" class="btn btn-default btn-lg" role="button">製品リスト</a>
	</div>
</div>

<%@ include file="/footer.jsp"%>