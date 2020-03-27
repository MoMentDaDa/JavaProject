package Cookie;

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

//����ռ����ʼ�����
@WebServlet("/cookie/get")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String username="";
		// ��ȡ���Cookie
		Cookie[] cs = req.getCookies();
		for (Cookie cookie : cs) {
			String name = cookie.getName();
			String value = cookie.getValue();
			if ("currentName".equals(name)) {
				 username = URLDecoder.decode(value, "utf-8");
			}
		}
		PrintWriter out = resp.getWriter();
		out.print("��ӭ:" + username + "<br/>");
		out.print("ѧ�ú���");

	}
}
