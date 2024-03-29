package RedirectDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用URL重定向实现网页的跳转ת
@WebServlet("/redirect/s1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		req.setAttribute("data", "师姐，你好漂亮");
		System.out.println("请求来了servlet1........");
		// 设置URL重定向，可以跨域访问，底层是两个独立的请求，不能访问WEB-INF内的资源,也不能传递数据,但是可以在资源尾部添加，即是get方式，路径应该补齐
		//resp.sendRedirect("https://www.baidu.com");
		//resp.sendRedirect(""/WEB-INF/web-inf.html"");
		resp.sendRedirect("/03/redirect/s2?username=will");
		System.out.println("请求之后servlet1........");
	}
}
