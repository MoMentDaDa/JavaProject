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

//����ռ���
@WebServlet("/session/login")
public class loginServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		//����user�������ڷ�װ�û���Ϣ
		UserInfo user=new UserInfo();
		user.setId(1L);
		user.setName(req.getParameter("username"));
		user.setPasswrod(req.getParameter("password"));
		// ����Session�����ڴ洢���ݣ��ײ���Զ�������Ӧ�У����ڻỰ���رռ�û�У����Բ����ñ����ʽ
		HttpSession s = req.getSession();
		s.setAttribute("info", user);
		//���ó�ʱʱ��Ϊ15s��Ĭ��30s
		s.setMaxInactiveInterval(15);
		PrintWriter out = resp.getWriter();
		out.print("��ӭ:" + user.getName() + "<br/>");
		out.print("<a href='/session/list'>�ռ���</a>");
	}

}
