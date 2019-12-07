<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- 
블록의 종류

1. 콘텐츠를 가지고 있는 블록 : 5가지 종류 + 기타(section)
2. 상위 블록 : 방 > 레이아웃(배치하기)을 위한 방
3. 인라인 블록 : 콘텐츠 안에서 영역을 가지는 공간

위에서 1(옵션), 2(필수)번은 제목 필요. 3번은 없음.



jsp 코드블록의 종류
< % % >

1. 출력코드 (서비스 함수로감)   

out.write("");

2. 코드블록 (서비스 함수로감)

< % y = x + 3; % >

y의 값은 : < % out.print(y); % >
y의 값은 : < %= y %> (위의 값을 단순화)

3. 선언부(Declaration)
(함수, 변수는 멤버에 선언 / 지역변수, 알고리즘은 서비스에 선언됨)

< % ! (서비스가 아닌 멤버에 선언하기위해 차이점 ! 를 넣음)
public int sum (int a, int b)
{
	return a+b;
}

4. 초기설정을위한 page 지시자

< %@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> (자바코드가 아닌 메타데이터를 위해 @ 사용)

${a}


1. 저장소에 담긴 값의 종류에 따라서 EL을 사용하는 방법

${ar[0]} (배열의 값을꺼냄)

2. 저장소가 4개가 있는데, 저장소에서 값을 꺼내는 방식을 이해

범위가 좁은것부터 넓은순서로 우선순위를 가짐
pageComtext > request > session > application

한정사(우선순위를 무시하고 사용하게해줌)
pageScope: 페이지 값만 가져옴
requestScope: 리퀘스트 값만 가져옴
sessionScope: 세션 값만 가져옴
applicationScope: 앱 값만 가져옴

${sessionScope.cnt}

3. 4대 저장소 외에 사용할 수 있는 저장소는 없는지?

//

1. MVC > View 에는 자바 코드가 없어야함
		ㄴ 그럴려면 > 데이터의 출력하는 표현식이 필요하다 > EL
		
2. EL(Expression Language)
	데이터 형식에 따른 표현식을 작성할 수 있는가? (단일데이터, 복합 데이터)
	데이터를 뽑아내기위한 저장소 4개를 암기 (pageComtext > request > session > application)
	
4. EL로 사용할수있는 데이터
	param / paramValues
	header / headerValues
	cookie
	pageContext 로부터 get 함수를 전부 사용가능

 -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>뉴렉처</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/inc/header.jsp" />
	<!-- header end -->
	<!-- side menu start -->
	<jsp:include page="inc/aside.jsp" />
	<!-- side menu end -->
	<!-- main start -->
	<main>
		<section>
			<h1>공지사항</h1>
			<nav>
				<h1>고객센터메뉴</h1>
				<ol>
					<li><a href="">home</a></li>
					<li><a href="">고객센터</a></li>
					<li><a href="">공지사항</a></li>
				</ol>
			</nav>
			<section>
				<h1 id="공지사항리스트">공지사항 리스트</h1>
				<table border="1">
					<thead>
						<tr>
							<td>방번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${list}" begin="0" end="14" step="1"
							varStatus="status">
							<tr>
								<th>${status.current}/${status.index}</th>
								<td><a href="detail?id=" ${n.ID}>${n.TITLE}</a></td>
								<td>${n.WRITER_ID}</td>
								<td><fmt:formatDate value="${n.REGDATE}"
										pattern="yy년 MM월 dd일 / HH시 mm분 ss초" /></td>
								<td><c:set var="price" value="1235555512341234.11" /> <fmt:formatNumber
										value="${price}" type="number" />원</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</section>
			<c:set var="page" value="${(empty param.page)?0:param.page}" />
			<c:set var="startNum" value="${page-(page-1)%5}" />
			<span>startNum = ${startNum}</span>
			<div>${page}/${startNum+4}pages</div>
			<div>
				<!--<c:if test="${startNum == 1}">
					<a href="javascript:alert('뒤가 없어!');">이전</a>
				</c:if>
				<c:if test="${startNum > 1}">
					<a	href="list?page=${startNum-1}#공지사항리스트">이전</a>
				</c:if>-->

				<c:choose>
					<c:when test="${startNum == 1}">
						<a href="javascript:alert('뒤가 없어!');">이전</a>
					</c:when>
					<c:otherwise>
						<a href="list?page=${startNum-1}#공지사항리스트">이전</a>
					</c:otherwise>
				</c:choose>
			</div>
			<nav>
				<h1>공지사항 페이지</h1>
				<ul>
					<c:forEach var="page" begin="0" end="4" varStatus="s">
						<li><a href="list?page=${page+startNum}#공지사항리스트">${page+startNum}</a></li>
					</c:forEach>
				</ul>
			</nav>
			<div>
				<a href="list?page=${startNum+5}#공지사항리스트">다음</a>
			</div>
		</section>
	</main>
	<!-- main end -->
	<!-- footer start -->
	<jsp:include page="/WEB-INF/view/inc/footer.jsp" />
	<!-- footer end -->
</body>
</html>
