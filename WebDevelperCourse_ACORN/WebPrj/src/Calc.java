import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// servlet-api.jar를 설정하는 방법
// 1. 번역할 때만 오류가 발생하지 않도록 classpath를 설정하기
// 2. 배포될 때 같이 가져가게 하기 위한 설정

@WebServlet("/calc")
public class Calc extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter(); // response 출력

		int x = 0;
		int y = 0;
		String temp = request.getParameter("x"); // request 입력
		String temp1 = request.getParameter("y"); // request 입력
		int result = 0;

		if (temp != null && temp1 != null) {
			x = Integer.parseInt(temp);
			y = Integer.parseInt(temp1);
		}
		String op = request.getParameter("op");
		
		switch(op) {
			case "덧셈" : result = x+y; break;
			case "뺄셈" : result = x-y; break;
			case "곱셈" : result = x*y; break;
			case "나눗셈" : result = x/y; break;
		}
		
		out.println("계산 결과 : "+result);
		out.println("<a href= \"calc.html\"> 이전페이지. </a>");
	}
}