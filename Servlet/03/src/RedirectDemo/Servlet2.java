package RedirectDemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect/s2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("请求之前，servlet2准备接收....");
		String data = (String) req.getAttribute("data");
		String username = (String) req.getParameter("username");
		System.out.println("这是通过在链接尾部添加数据传递过来的：" + username);
		System.out.println("请求来了，servlet2接收成功...." + data);
	}
}
