package Web_Apart.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JDBC_Apart.DaoMain.Student;
import JDBC_Apart.Impl.ImplementslAchieveDemo;

@WebServlet("/crud/edit")
public class Jump extends HttpServlet {
	private ImplementslAchieveDemo dao;

	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Utf-8");
		// 接受id,是否有id
		String id = req.getParameter("id");
		if (hasLength(id)) {
			Student stu = dao.get(Long.valueOf(id));
			req.setAttribute("student", stu);
		}
		req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
