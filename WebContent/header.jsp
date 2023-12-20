<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSL인재개발원</title>

<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/common.css" rel="stylesheet">
<link href="css/layout.css" rel='stylesheet'>

<!--
  	jquery언어 사용법
	1. jquey.js을 기반으로 프로그램을 작성하기 때문에 jquery.js 파일을 다운 또는 CDN 방식으로 링크를 건다
	2. $(function() {
		실행문;
	});
  -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="js/jquery-3.3.1.min.js"></script>


</head>
<body>
	<!-- 
 웹문서 만들기 기본 공식
 1. 요소를 어떻게 묶을 것인가? 그룹만들기
 2. 그룹안에 적절한 태그 사용
 3. class 이름 붙이고 css 적용
 -->
	<div class="sr-only">
		<p>
			<a href="#contents">본문 바로가기</a>
		</p>
	</div>

	<div class="top_navigation">

		<header class="header">
			<nav class="top_left">
				<ul>
					<li class="first"><a href="">HOME</a></li>
					<li><a href="">모집안내</a></li>
					<li><a href="">입학상담</a></li>
					<li><a href="">교육신청</a></li>
				</ul>
			</nav>
			<nav class="top_right">
				<ul>
					<li class="first"><a href="">로그인</a></li>
					<li><a href="">회원가입</a></li>
				</ul>
			</nav>

			<div class="gnb_group">
				<h1 class="logo">Project</h1>
				<nav class="gnb">
					<ul class="nav_1depth">
						<li><a href="">기업소개</a>
							<ul class="nav_2depth">
								<li><a href="">인사말</a></li>
								<li><a href="">연혁 및 </a></li>
								<li><a href="">교직원소개</a></li>
								<li><a href="">대우갤러리</a></li>
								<li><a href="">찾아오시는길</a></li>
							</ul></li>
						<li><a href="">포트폴리오</a>
							<ul class="">
								<li><a href="">포트폴리오</a></li>
							</ul></li>
						<li><a href="">커뮤니티</a>
							<ul class="nav_2depth">
								<li><a href="">공지사항</a></li>
								<li><a href="">질문과답변</a></li>
								<li><a href="">FAQ</a></li>
								<li><a href="">자료실</a></li>
								<li><a href="">관리자</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</header>

		<div class="line"></div>

	</div>

	<script>
		$(function() {
			$(".gnb>.nav_1depth>li").hover(function() {
				$(".gnb>.nav_1depth>li").removeClass();
				$(this).addClass("active");

				$(this).children(".nav_2depth").stop().slideDown("fast");
			}, function() {
				$(".gnb>.nav_1depth>li").removeClass();
				$(this).children(".nav_2depth").stop().slideUp("fast");
			});

		});
	</script>