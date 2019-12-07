<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
<meta charset="UTF-8">
<title>공지사항목록</title>

<link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
<style>
#visual .content-container {
	height: inherit;
	display: flex;
	align-items: center;
	background: url("../../images/customer/visual.png") no-repeat center;
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

			<jsp:include page="inc/aside.jsp" />

			<!-- --------------------------- main --------------------------------------- -->




			<main>
				<h2 class="main title">공지사항</h2>

				<div class="breadcrumb">
					<h3 class="hidden">breadlet</h3>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</div>

				<div class="margin-top first">
					<h3 class="hidden">공지사항 내용</h3>
					<table class="table">
						<tbody>
							<tr>
								<th>제목</th>
								<td class="text-align-left text-indent text-strong text-orange"
									colspan="3">${title}<!-- 아래의 자바코드에 해당하는 값과 동일한 코드 --> <%--=request.getAttribute("title")--%></td>
							</tr>
							<tr>
								<th>작성일</th>
								<td class="text-align-left text-indent" colspan="3">${date}</td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${writer}</td>
								<th>조회수</th>
								<td>${hit}</td>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3"></td>
							</tr>
							<tr class="content">
								<td colspan="4">${content}</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="margin-top text-align-center">
					<a class="btn btn-list" href="list">목록</a>
				</div>

				<div class="margin-top">
					<table class="table border-top-default">
						<tbody>

							<tr>
								<th>다음글</th>
								<td colspan="3" class="text-align-left text-indent">다음글이
									없습니다.</td>
							</tr>




							<tr>
								<th>이전글</th>
								<td colspan="3" class="text-align-left text-indent"><a
									class="text-blue text-strong" href="">스프링 DI 예제 코드</a></td>
							</tr>


						</tbody>
					</table>
				</div>

			</main>

		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->


	<jsp:include page="/WEB-INF/view/inc/footer.jsp" />
</body>
</html>
