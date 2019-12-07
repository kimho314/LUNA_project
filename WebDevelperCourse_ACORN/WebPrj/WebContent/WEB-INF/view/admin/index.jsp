<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta name="viewport" content="width=device-width,initial-scale=1"> -->
<title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
<link href="/css/admin/layout.css" type="text/css" rel="stylesheet" />
<style>
#visual .content-container {
	height: inherit;
	display: flex;
	align-items: center;
	background: url("/images/mypage/visual.png") no-repeat center;
}
</style>
</head>
<body>
	<!-- header 부분 -->


	<jsp:include page="/WEB-INF/view/inc/header.jsp" />

	<!-- --------------------------- <visual> --------------------------------------- -->
	<!-- visual 부분 -->

	<div id="visual">
		<div class="content-container"></div>
	</div>
	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside 부분 -->



			<aside class="aside">
				<h1>ADMIN PAGE</h1>

				<nav class="menu text-menu first margin-top">
					<h1>마이페이지</h1>
					<ul>
						<li><a href="/admin/index">관리자홈</a></li>
						<li><a href="/teacher/index">선생님페이지</a></li>
						<li><a href="/student/index">수강생페이지</a></li>
					</ul>
				</nav>

				<nav class="menu text-menu">
					<h1>알림관리</h1>
					<ul>
						<li><a href="/admin/board/notice/list">공지사항</a></li>
					</ul>
				</nav>

			</aside>
			<!-- --------------------------- main --------------------------------------- -->

			<!-- content 부분 -->

			<main class="main">
				<h2 class="main title">관리자홈</h2>

				<div class="breadcrumb">
					<h3 class="hidden">breadlet</h3>
					<ul>
						<li>home</li>
						<li>마이페이지</li>
						<li>홈</li>
					</ul>
				</div>

				<div class="margin-top first"></div>

			</main>

		</div>
	</div>
	<!-- ------------------- <footer> --------------------------------------- -->


	<jsp:include page="/WEB-INF/view/inc/footer.jsp" />
</body>
</html>