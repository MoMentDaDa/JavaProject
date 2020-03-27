package Forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/s1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		req.setAttribute("data","师姐，你好漂亮");
		System.out.println("我Servlet1来了........");
		req.getRequestDispatcher("/forward/s2").forward(req, resp);
		System.out.println("Servlet1请求转发完成，相应结果由servlet2决定........");
	}
}
