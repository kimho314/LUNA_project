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

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {

	// GET은 껍데기 처리를 하고
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter(); // response 출력

		int result = 0;
		
		Object result_ = request.getAttribute("result");
		if(result_ != null)
			result = (Integer)result_;
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<title>계산기</title>");
		out.write("</head>");
		out.write("<body>");

		out.write("	<form action=\"calc2\" method = \"post\">");
		out.printf("		<input type =\"text\" name =\"num\" readonly=\"readonly\" value = \"%d\" dir =\"rtl\"><br>",
				result);
		out.write("		<input type = \"submit\" name=\"btn\" value = \"1\">");
		out.write("		<input type = \"submit\" name=\"btn\" value = \"2\">");
		out.write("		<input type = \"submit\" name=\"btn\" value = \"3\"><br>");
		out.write("		<input type = \"submit\" name=\"btn\" value = \"덧셈\">");
		out.write("		<input type = \"submit\" name=\"btn\" value = \"뺄셈\">");
		out.write("		<input type = \"submit\" name=\"btn\" value = \"계산\">");

		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
	}
	
	// POST는 업무 처리....
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int result = 0;
		String num = request.getParameter("num"); // request 입력
		String btn = request.getParameter("btn"); // request 입력
		String status = num;

		switch (btn) {
		case "1":
		case "2":
		case "3":
			status += btn;
			break;
		}

		result = Integer.parseInt(status);
		
		request.setAttribute("result", result);
		
//		생각이나 구조는 맞으나 서블릿/웹이 생각하는 개념과는 통하지 않아서 막혔다.
//		이것은 마치 관람하는 곳에서 경로를 이탈하는 행위로 인식이 된다.
		
		doGet(request, response); 
	}
}