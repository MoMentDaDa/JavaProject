package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//输出收件箱邮件内容
@WebServlet("/session/get")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		// 获取多个Session
		HttpSession s = req.getSession();
		UserInfo info = (UserInfo) s.getAttribute("info");
		String username =(String) s.getAttribute("name");
		PrintWriter out = resp.getWriter();
		out.print("欢迎:" + info.getName() + "<br/>");
		out.print("学妹好美");

	}
}
