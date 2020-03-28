package IncludeDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include/showInclude")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.getRequestDispatcher("/include/Head").include(req, resp);
		resp.getWriter().write("<br>");
		resp.getWriter().write("--------------------------------------------");
		resp.getWriter().write("<br>");
		// 设置包含转发，可以跨域访问，底层是两个独立的请求，不能访问WEB-INF内的资源
		String data = (String) req.getAttribute("data");
		resp.getWriter().write(data);
		resp.getWriter().write("<br>");
		req.getRequestDispatcher("/include/Foot").include(req, resp);

	}
}