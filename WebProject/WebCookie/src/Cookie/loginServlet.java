package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//����ռ���
@WebServlet("/cookie/login")
public class loginServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String name =req.getParameter("username") ;
		// ����Cookie�����ڴ洢����
		Cookie c = new Cookie("currentName", URLEncoder.encode(name,"utf-8"));
		// ��Cookie��Ӧ�������
		resp.addCookie(c);
		PrintWriter out = resp.getWriter();
		out.print("��ӭ:" + name + "<br/>");
		out.print("<a href='/cookie/list'>�ռ���</a>");
	}

}
