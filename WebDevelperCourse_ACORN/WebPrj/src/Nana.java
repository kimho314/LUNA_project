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

@WebServlet("/hello")
public class Nana extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter(); // response 출력

		// localhost:8080/hello?cnt=3
		String temp = request.getParameter("cnt"); // request 입력
		int cnt = 10;

		if (temp != null && !temp.equals(""))
			cnt = Integer.parseInt(temp);

		for (int i = 0; i < cnt; i++) {
			out.print("안녕 <br>");
		}
		
		String x = request.getParameter("x");
			out.print(x);
			
		out.println("<a href= \"index.html\"> 이전페이지. </a>");
	}
}