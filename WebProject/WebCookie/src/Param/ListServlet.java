package Param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//输出收件箱里的邮件
@WebServlet("/Param/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String name = req.getParameter("username");
		PrintWriter out = resp.getWriter();
		out.print("欢迎:" + name + "<br/>");
		for (int i = 0; i < 5; i++) {
			out.print("<a href='/Param/Get?username="+name+">一封邮件</a><br/>");
		}

	}
}
