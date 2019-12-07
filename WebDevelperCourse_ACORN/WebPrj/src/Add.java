import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		
		String varX = request.getParameter("x");
		String varY = request.getParameter("y");
		int sum = 0;
		
		if(varX != null && varX.equals("") && varY != null && varY.equals(""))
		{
			sum = Integer.parseInt(varX) + Integer.parseInt(varY);
		}
		out.println("µ¡¼À °á°ú: " + Integer.toString(sum));
		
	}
}
