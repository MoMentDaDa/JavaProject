package Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//����ռ�������ʼ�
@WebServlet("/session/list")
public class ListServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ���Sessio���󣬺ʹ洢������
		HttpSession s = req.getSession();
		UserInfo info = (UserInfo) s.getAttribute("info");
		PrintWriter out = resp.getWriter();
		out.print("��ӭ:" + info.getName() + "<br/>");
		for (int i = 0; i < 5; i++) {
			out.print("<a href='/session/get'>һ���ʼ�</a><br/>");
		}

	}
}
