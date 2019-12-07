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

@WebServlet("/sum")
public class Sum extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		PrintWriter out = response.getWriter(); // response 출력

		int x = 0;
		int y = 0;
		String[] xs_ = request.getParameterValues("x");
		int sum = 0;

		for (int i = 0; i < xs_.length; i++) {
			if (xs_[i] != null & !xs_[i].equals("")) {
				sum += Integer.parseInt(xs_[i]);
			}
		}

		out.println("계산 결과 : " + sum);
		out.println("<a href= \"sum.html\"> 이전페이지. </a>");
	}
}