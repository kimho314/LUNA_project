<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
	String sql = "SELECT * FROM NOTICE";

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<a href="">공지사항 페이지</a>
	</h1>

	<ul>
		<li><a href="../index.html">home</a></li>
		<li><a href="list.html">공지사항목록</a></li>
		<li><a href="../member/login.html">로그인</a></li>
	</ul>


	<header>
		<h1>뉴렉처 온라인</h1>

		<section>
			<h2>헤더</h2>

			<nav>
				<h4>메인 메뉴</h4>
				<ul>
					<li><a href="">학습가이드</a></li>
					<li><a href="">강좌선택</a></li>
					<li><a href="">AnswerIs</a></li>
				</ul>
			</nav>

			<div>
				<h4>강좌검색 홈</h4>
				<form>과정검색</form>
			</div>

			<nav>
				<h4>회원메뉴</h4>
				<ul>
					<li>HOME</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</nav>

			<div>
				<h4>자주사용하는 메뉴</h4>
				<ul>
					<li>마이페이지</li>
					<li>고객센터</li>
				</ul>
			</div>
		</section>
	</header>

	<!-- ======================================= -->
	<aside>
		<h1>고객센터</h1>
		<h2>고객을 위한 서비스</h2>

		<section>
			<h3>고객센터메뉴</h3>

			<ul>
				<li>공지사항</li>
				<li>자주하는 질문</li>
				<li>수강문의</li>
				<li>이벤트</li>
			</ul>


			<h3>협력업체</h3>

			<ul>
				<li>노트펍스</li>
				<li>나무랩연구소</li>
				<li>한빛미디어</li>
			</ul>
		</section>
	</aside>
	<!-- ============== main ===================== -->
	<main>
		<section>
			<h1>공지사항</h1>

			<ol>
				<li>home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ol>

			<h3>
				공지사항목록<%
				out.write("haha");
			%>
			</h3>
			<table border="1">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < 10; i++)
						{
					%>
					<tr>
						<td>
							<%
								out.print(i + 1);
							%>
						</td>
						<td>오라클 수업용 테이블 생성용 스크립트</td>
						<td>newlec</td>
						<td>2019-10-04</td>
						<td>109</td>
					</tr>
					<%
						}
					%>
					
					<% while(rs.next()){ %>
					<tr>
						<td><%= rs.getInt("ID") %></td>
						<td><%= rs.getString("TITLE") %></td>
						<td><%= rs.getString("writer_id") %></td>
						<td><%= rs.getString("REGDATE") %></td>
						<td><%= rs.getInt("hit") %></td>
					</tr>
					<% } %>
					<tr>
						<td>8</td>
						<td>스프링 8강까지의 예제 코드</td>
						<td>newlec</td>
						<td>2019-08-18</td>
						<td>235</td>
					</tr>
					<tr>
						<td>7</td>
						<td>스프링 DI 예제 코드</td>
						<td>newlec</td>
						<td>2019-08-15</td>
						<td>200</td>
					</tr>
					<tr>
						<td>6</td>
						<td>뉴렉쌤 9월 초 국기과정 모집 안내</td>
						<td>newlec</td>
						<td>2019-06-11</td>
						<td>626</td>
					</tr>
					<tr>
						<td>5</td>
						<td>뉴렉처 강의 수강 방식 안내</td>
						<td>newlec</td>
						<td>2019-05-24</td>
						<td>522</td>
					</tr>
					<tr>
						<td>4</td>
						<td>자바 구조적인 프로그래밍 강의 예제 파일</td>
						<td>newlec</td>
						<td>2019-04-24</td>
						<td>595</td>
					</tr>
				</tbody>
			</table>

			<div>1 / 1 pages</div>

			<div>이전</div>
			<ul>
				<li>1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
				<li>5</li>
			</ul>
			<div>다음</div>
		</section>
	</main>
	<!-- ================footer===================== -->
	<footer>
		<section>
			<h1>저작자 정보</h1>

			<section>
				<h3>회사정보</h3>

				<dl>
					<dt>주소:</dt>
					<dd>서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호</dd>
					<dt>관리자메일:</dt>
					<dd>admin@newlecture.com</dd>
					<dt>사업자 등록번호:</dt>
					<dd>132-18-46763</dd>
					<dt>통신 판매업:</dt>
					<dd>신고제 2013-서울강동-0969호</dd>
					<dt>상호:</dt>
					<dd>뉴렉처</dd>
					<dt>대표:</dt>
					<dd>박용우</dd>
					<dt>전화번호:</dt>
					<dd>070-4206-4084</dd>
				</dl>
			</section>

			<section>
				<h3>저작권 정보</h3>
				<div>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
					Contact admin@newlecture.com for more information</div>
			</section>
		</section>
	</footer>
</body>
</html>
<%
 rs.close();
 st.close();
 con.close();
 %>