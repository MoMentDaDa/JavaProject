package Session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/s1")
@SuppressWarnings("all")
public class SessionUse extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();// 得到Session对象
		session.setAttribute("name", "看完博客就要点赞！！");// 设置Session属性
		out.println("创一个session并放入姓名属性" + "<br>");
		//String url = "/04/session/s2";
		//out.write("<a href='" + response.encodeUrl(url)+ "'>跳转到s2</a>");
		// response.sendRedirect(response.encodeUrl(url));
		
		// 把该session id保存cookie，在id时，一定要按照规范命名，这里区分大小写
		// Cookie cookie = new Cookie("name", session.getId());
		// cookie.setMaxAge(60 * 30);
		// response.addCookie(cookie);
		// 设置有效期，单位为秒，-1代表永不过期。tomcat默认30分钟
		// session.setMaxInactiveInterval(-1);
	

	}
}