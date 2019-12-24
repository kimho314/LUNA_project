<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- ========main=================================== -->
<main>
	<section>
		<h1>공지사항</h1>

		<section>
			<h1>경로</h1>
			<ol>
				<li>home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ol>
		</section>

		<section>
			<h1>공지사항목록</h1>
			<table border="1">
				<thead>
					<tr>
						<th>순번</th>
						<th>번호</th>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일</td>
						<td>조회수</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="n" items="${list}" begin="0" end="4" step="2" varStatus="status">
						<tr>
							<th>${status.index}</th>
							<th>${n.id}</th>
							<td>
								<a href="${n.id}/detail">${n.title}</a>
							</td>
							<td>${n.writerId}</td>
							<td>
								<fmt:formatDate value="${n.regdate}" pattern="yyyy년 MM월 dd일 HH시 mm분 ss초" />
							</td>
							<td>
								<c:set var="price" value="12345678901.23" />
								${price} /
								<fmt:formatNumber value="${price }" type="number" />
								원

							</td>
						</tr>
					</c:forEach>
					<%-- <%} %> --%>

				</tbody>
			</table>
		</section>


		<div>1 / 1 pages</div>

		<c:set var="page" value="${(empty param.p)?0:param.p}" />
		<c:set var="startNum" value="${page - (page-1)%5}" />
		<div>startNum: ${startNum }</div>

		<c:choose>
			<c:when test="${startNum == 1}">
				<a href="javascript:alert('못가');">이전</a>
			</c:when>
			<c:otherwise>
				<a href="list?p=${startNum-1}">이전</a>
			</c:otherwise>
		</c:choose>

		<!-- --------------------------------- -->
		<div>
			<c:if test="${startNum == 1}">
				<a href="javascript:alert('못가');">이전</a>
			</c:if>
			<c:if test="${startNum > 5 }">
				<a href="list?p=${startNum-1}">이전</a>
			</c:if>
		</div>

		<ul>
			<c:forEach var="idx" begin="0" end="4" varStatus="s">
				<li><a href="list?p=${startNum+idx}">${startNum+idx}</a></li>
			</c:forEach>
		</ul>
		<div>
			<a href="list?p=${startNum+5}">다음</a>
		</div>
	</section>
</main>