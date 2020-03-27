package Web_Apart.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Impl.ImplementslAchieveDemo;

//����ɾ��ָ��ѧ��
@WebServlet("/crud/delete")
public class DeleteServlet extends HttpServlet {
	private ImplementslAchieveDemo dao;

	// ��ʼ��dao����
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����������
		Long id = Long.valueOf(req.getParameter("id"));
		// 2������ҵ�񷽷���������
		dao.delete(id);
		// 3�����ƽ�����ת
		resp.sendRedirect("/crud/list");
	}
}
