package Cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
@WebServlet("/cookie/s3")
public class Servlet3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置response的编码
		response.setContentType("text/html;charset=UTF-8");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				response.getWriter().write(cookieName + ":" + cookieValue + "<br>");
			}
		}
		



		
	}
}
