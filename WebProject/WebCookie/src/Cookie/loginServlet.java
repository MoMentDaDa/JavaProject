package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//输出收件箱
@WebServlet("/cookie/login")
public class loginServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String name =req.getParameter("username") ;
		// 创建Cookie，用于存储数据
		Cookie c = new Cookie("currentName", URLEncoder.encode(name,"utf-8"));
		// 把Cookie响应给浏览器
		resp.addCookie(c);
		PrintWriter out = resp.getWriter();
		out.print("欢迎:" + name + "<br/>");
		out.print("<a href='/cookie/list'>收件箱</a>");
	}

}
