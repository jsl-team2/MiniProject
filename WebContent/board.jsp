<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<div class="container-fluid">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header top-nav">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="">MiniProject</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav"></ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false"><span class="glyphicon glyphicon-user"></span>
								<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="member.html">회원가입</a></li>
								<li><a href="login.html">로그인</a></li>
								<li><a href="logout.html">로그아웃</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="mypage.html">마이페이지</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
				<div class="container-fluid subvisual ">
					<h2>자유게시판</h2>
				</div>
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<div class="container content">

		<div class="row">
			<div class="search_wrap">
				<div class="search_group">
					<form name="myform" method="get" action="notice.html">
						<select name="sel" class="select">
							<option value="1">제목</option>
							<option value="2">내용</option>
							<option value="3">작성자</option>
						</select> <input type="text" name="search" class="search_word">
						<button class="btn_search" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</form>
				</div>
			</div>
			<div class="col-lg-3">
				<div class="main-pane">
					<div class="write-button">
						<button type="button" class="btn btn-primary btn-lg btn-block">글쓰기</button>
					</div>
				</div>

				<div class="top_menu">
					<ul>
						<li><a type="button" class="btn btn-default bbtn-lg"><span
								class="glyphicon glyphicon-envelope"> 최신글</span></a></li>

						<li><a type="button" class="btn btn-default bbtn-lg"><span
								class="glyphicon glyphicon-pencil"> 내 게시글</span></a></li>

						<li><a type="button" class="btn btn-default bbtn-lg"><span
								class="glyphicon glyphicon-comment"> 자유게시판</span></a></li>

						<li><a type="button" class="btn btn-default bbtn-lg"><span
								class="glyphicon glyphicon-star-empty"> 중요</span></a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-9">
				<div class="bord_list">
					<table class="bord_table" summary="이표는 번호,제목,글쓴이,날자,조회수로 구성되어 있습니다">
						<caption class="sr-only">공지사항 리스트</caption>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>작성일</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>8</td>
								<td class="title"><a href="notice_view.html">입학절차에 대하여
										알고 싶어요</a></td>
								<td>관리자</td>
								<td>18-10-16</td>
								<td>187</td>
							</tr>
							<tr>
								<td>7</td>
								<td class="title"><a href="notice_view.html">무엇이 궁금한가요?</a></td>
								<td>관리자</td>
								<td>18-10-16</td>
								<td>187</td>
							</tr>
							<tr>
								<td>6</td>
								<td class="title"><a href="notice_view.html">궁굼한내용제목입니다</a></td>
								<td>관리자</td>
								<td>18-10-16</td>
								<td>187</td>
							</tr>
						</tbody>
					</table>
					<div class="paging">
						<a href=""><i class="fa  fa-angle-double-left"></i></a>
						 <a href=""><i class="fa fa-angle-left"></i></a> 
						 <a href="" class="active">1</a> 
						 <a href="">2</a> 
						 <a href="">3</a> 
						 <a href="">4</a>
						 <a href="">5</a> 
						 <a href=""><i class="fa fa-angle-right"></i></a> 
						 <a href=""><i class="fa  fa-angle-double-right"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	