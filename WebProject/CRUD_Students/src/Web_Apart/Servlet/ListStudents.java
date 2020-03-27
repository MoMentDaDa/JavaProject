package Web_Apart.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Impl.ImplementslAchieveDemo;

//����ѧ���б������
@WebServlet("/crud/list")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImplementslAchieveDemo dao;

//��ʼ��dao����
	@Override
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("html/text;charset=utf8");
		req.setCharacterEncoding("utf-8");
		// 1�����������������װ����
		req.setAttribute("student", dao.listAll());
		// 2������ҵ�񷽷�����������
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		// 3�����ƽ�����ת

	}
}