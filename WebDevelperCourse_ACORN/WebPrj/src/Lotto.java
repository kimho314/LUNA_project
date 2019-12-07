import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto")
public class Lotto extends HttpServlet {
	
	public static void bubbleSort(int[] _lottoNumArr)
	{
		for(int i=_lottoNumArr.length; i>=0; i--)
		{
			for(int j=0; j<i-1; j++)
			{
				if(_lottoNumArr[j] > _lottoNumArr[j+1])
				{
					int tmp = _lottoNumArr[j];
					_lottoNumArr[j] = _lottoNumArr[j+1];
					_lottoNumArr[j+1] = tmp;
				}
			}
			
		}
	}
	
	public static void printArr(int[] _lottoNumArr)
	{
		for(int i=0; i<_lottoNumArr.length; i++)
			System.out.print(_lottoNumArr[i] + " ");
		System.out.println();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String result = "";
		String auto = request.getParameter("auto");
		String manual = request.getParameter("manual");
		String num = request.getParameter("num");
		int[] lottoNumArr = new int[6];
		boolean err = false;


		if (auto != null && !auto.equals("")) {
			int[] lottoNum = new int[45];
			for (int i = 0; i < lottoNum.length; i++) {
				lottoNum[i] = i + 1;
			}

			for (int i = 0; i < lottoNumArr.length; i++) {
				while (true) {
					int idx = 0;
					idx = (int) (Math.random() * 45.0);
					if (lottoNum[idx] != -1) {
						lottoNumArr[i] = lottoNum[idx];
						lottoNum[idx] = -1;
						break;
					}
				}
			}
			
			bubbleSort(lottoNumArr);
			//printArr(lottoNumArr);
			
			for(int i=0; i<lottoNumArr.length; i++)
			{
				result += (lottoNumArr[i] + " ");
			}
		}

		if (manual != null && !manual.equals("")) {
			String[] n = request.getParameterValues("n");
			
			if (n != null) 
			{
				if(n.length == 6)
				{
					for (int i = 0; i < lottoNumArr.length; i++) 
					{
						lottoNumArr[i] = Integer.parseInt(n[i]);
						bubbleSort(lottoNumArr);
						//printArr(lottoNumArr);
						result += (lottoNumArr[i] + " ");
					}
				}
				else
				{
					err = true;
				}
				
			}
		}

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<form action=\"lotto\">");
		out.write("<div>");
		out.write("<label>로또 프로그램입니다.</label>");
		out.write("<div>");

		out.write("<input type=\"text\" name=\"num\" readonly=\"readonly\" value=\"" + result
				+ "\" dir=\"ltr\"><br><br>");

		for (int i = 1; i <= 45; i++) {
			out.write("<input type=\"checkbox\" name=\"n\" value=\"" + i + "\"><label>" + i + "</label>");
			if (i % 5 == 0) {
				out.write("<br>");
			}
		}
		
		if(err)
		{
			out.write("<br>");
			out.write("6개 숫자를 입력해주세요!!!");
			err = false;
		}
		
		out.write("<br>");
		out.write("<input type=\"submit\" name=\"auto\" value=\"자동발급\">");
		out.write("<input type=\"submit\" name=\"manual\" value=\"수동발급\">");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}
}
