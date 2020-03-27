package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//输出收件箱里的邮件
@WebServlet("/cookie/list")
public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = "";
		// 获取多个Cookie
		Cookie[] cs = req.getCookies();
		for (Cookie cookie : cs) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if ("currentName".equals(name)) {
				username = URLDecoder.decode(value, "utf-8");
				// 通过设置值覆盖原有值
				cookie.setValue("hello");
				resp.addCookie(cookie);
			}
		}
		PrintWriter out = resp.getWriter();
		out.print("欢迎:" + username + "<br/>");
		for (int i = 0; i < 5; i++) {
			out.print("<a href='/session/get'>一封邮件</a><br/>");
		}

	}
}
