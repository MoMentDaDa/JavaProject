package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//输出收件箱
@WebServlet("/session/login")
public class loginServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//创建user对象用于封装用户信息
		UserInfo user=new UserInfo();
		user.setId(1L);
		user.setName(req.getParameter("username"));
		user.setPasswrod(req.getParameter("password"));
		// 创建Session，用于存储数据，底层会自动放入响应中，属于会话，关闭即没有，可以不设置编码格式
		HttpSession s = req.getSession();
		s.setAttribute("info", user);
		//设置超时时间为15s，默认30s
		s.setMaxInactiveInterval(15);
		PrintWriter out = resp.getWriter();
		out.print("欢迎:" + user.getName() + "<br/>");
		out.print("<a href='/session/list'>收件箱</a>");
	}

}
