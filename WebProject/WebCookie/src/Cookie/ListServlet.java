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

//����ռ�������ʼ�
@WebServlet("/cookie/list")
public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username = "";
		// ��ȡ���Cookie
		Cookie[] cs = req.getCookies();
		for (Cookie cookie : cs) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if ("currentName".equals(name)) {
				username = URLDecoder.decode(value, "utf-8");
				// ͨ������ֵ����ԭ��ֵ
				cookie.setValue("hello");
				resp.addCookie(cookie);
			}
		}
		PrintWriter out = resp.getWriter();
		out.print("��ӭ:" + username + "<br/>");
		for (int i = 0; i < 5; i++) {
			out.print("<a href='/session/get'>һ���ʼ�</a><br/>");
		}

	}
}
