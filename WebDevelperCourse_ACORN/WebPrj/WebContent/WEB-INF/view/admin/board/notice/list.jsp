<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="listCount" value="${listCount}" />
<c:set var="lastNum"
	value="${fn:substringBefore(Math.ceil((listCount-1)/15), '.')}" />

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

			<jsp:include page="../../inc/aside.jsp" />
			<!-- --------------------------- main --------------------------------------- -->



			<main class="main">
				<h2 class="main title">공지사항</h2>

				<div class="breadcrumb">
					<h3 class="hidden">경로</h3>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</div>

				<div class="search-form margin-top first align-right">
					<h3 class="hidden">공지사항 검색폼</h3>
					<form action="list" method="get" class="table-form">
						<fieldset>
							<legend class="hidden">공지사항 검색 필드</legend>
							<label class="hidden">검색분류</label>
							<!--  -->
							<select name="f">
								<option value="title">제목</option>
								<option value="writerId">작성자</option>
							</select>
							<!--  -->
							<label class="hidden">검색어</label>
							<!--  -->
							<input type="text" name="q" value="${param.q}" />
							<!--  -->
							<input type="hidden" name="p" value="${param.p}">
							<!--  -->
							<input class="btn btn-search" type="submit" value="검색" />
						</fieldset>
					</form>
				</div>

				<!-- =============================================================================================  -->

				<form action="list" method="post">
					<div class="notice margin-top">
						<h3 class="hidden">공지사항 목록</h3>
						<table class="table">
							<thead>
								<tr>
									<th class="w60">번호</th>
									<th class="expand">제목</th>
									<th class="w100">작성자</th>
									<th class="w100">작성일</th>
									<th class="w60">조회수</th>
									<th class="w40">공개</th>
									<th class="w40">삭제</th>
								</tr>
							</thead>


							<tbody>
								<c:forEach var="n" items="${list}">
									<tr>
										<th>${n.id}</th>
										<td class="title indent text align-left">
											<!--  --> <a href="detail?id=${n.id}">${n.title}</a>
										</td>
										<td>${n.writerId}</td>
										<td>${n.regdate}</td>
										<td>${n.hit}</td>
										<td><input type="checkbox" name="open" value="${n.id}"></td>
										<td><input type="checkbox" name="del" value="${n.id}"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>


					<!-- 
				<nav>
					<h1>공지사항 페이지</h1>
					<ul>
						<c:forEach var="page" begin="0" end="4" varStatus="s">
							<li><a href="list?page=${page+startNum}#공지사항리스트">${page+startNum}</a></li>
						</c:forEach>
					</ul>
				</nav>
				

				 -->
					<c:set var="page" value="${(empty param.p)?1:param.p}" />
					<c:if test="${page <= 3}">
						<c:set var="startNum" value="1" />
					</c:if>
					<c:if test="${page > 3}">
						<c:set var="startNum" value="${page-2}" />
					</c:if>
					<div class="indexer margin-top align-right">
						<h3 class="hidden">현재 페이지</h3>
						<div style="text-align: right;">

							<span class="text-orange text-strong">${page}</span> / ${lastNum}
							pages
						</div>
					</div>

					<div class="text-align-right margin-top">
						<input type="submit" class="btn-text btn-default" name="cmd" value="일괄공개">
						<input type="submit" class="btn-text btn-default" name="cmd" value="일괄삭제">
						<input type="hidden" name="p" value="${param.p}">
						<input type="hidden" name="f" value="${param.f}">
						<input type="hidden" name="q" value="${param.q}"> <a class="btn-text btn-default" href="reg">글쓰기</a>
					</div>
				</form>

				<!-- =============================================================================================  -->

				<div class="margin-top align-center pager">


					<div>
						<div>
							<c:choose>
								<c:when test="${startNum <= 5}">
									<a href="javascript:alert('뒤가 없어!');"> <span
										class="btn btn-prev">이전</span>
									</a>
								</c:when>
								<c:otherwise>
									<a href="list?p=${startNum-5}&f=${param.f}&q=${param.q}"><span
										class="btn btn-prev">이전</span></a>
								</c:otherwise>
							</c:choose>
						</div>



					</div>
					&nbsp;
					<ul class="-list- center">
						<c:if test="${page >= 4}">
							<a class="-text-" href="list?p=1&f=${param.f}&q=${param.q}">1</a>
							<span>&nbsp;...&nbsp;</span>
						</c:if>

						<c:if test="${startNum <= 1}">
							<c:forEach var="i" begin="${startNum-1}" end="${startNum+3}">
								<c:if test="${(i+1)<=lastNum}">
									<li><c:if test="${i+1 == page}">
											<c:set var="currentStyle" value="orange bold" />
										</c:if> <c:if test="${i+1 != page}">
											<c:set var="currentStyle" value="" />
										</c:if> <a class="-text- ${currentStyle}"
										href="list?p=${i+1}&f=${param.f}&q=${param.q}">${i+1}</a></li>
								</c:if>
							</c:forEach>
						</c:if>

						<c:if test="${startNum > 1}">
							<c:forEach var="i" begin="${startNum-1}" end="${startNum+3}">
								<c:if test="${(i+1)<=lastNum}">
									<li><c:if test="${i+1 == page}">
											<c:set var="currentStyle" value="orange bold" />
										</c:if> <c:if test="${i+1 != page}">
											<c:set var="currentStyle" value="" />
										</c:if> <a class="-text- ${currentStyle}"
										href="list?p=${i+1}&f=${param.f}&q=${param.q}">${i+1}</a></li>
								</c:if>
							</c:forEach>
						</c:if>

						<c:if test="${page+3 <= lastNum && lastNum > 5}">
							<span>&nbsp;...&nbsp;</span>
							<a class="-text-"
								href="list?p=${lastNum}&f=${param.f}&q=${param.q}">${lastNum}</a>
						</c:if>

					</ul>
					&nbsp;
					<div>


						<div>
							<c:if test="${(startNum+5)>lastNum}">
								<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.')">다음</span>
							</c:if>
							<c:if test="${(startNum+5)<=lastNum}">
								<a href="list?p=${startNum+5}&f=${param.f}&q=${param.q}"> <span
									class="btn btn-next">다음</span></a>
							</c:if>
						</div>


					</div>

				</div>
			</main>


		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->


	<jsp:include page="/WEB-INF/view/inc/footer.jsp" />
</body>

</html>