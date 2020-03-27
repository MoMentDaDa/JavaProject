package Web_Apart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JDBC_Apart.Impl.ImplementslAchieveDemo;
import JDBC_Apart.Impl.StudentDaoInterface;

@WebServlet("/")
public class ListStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDaoInterface dao;

	@Override
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		req.setAttribute("student", dao.get(2));
		resp.setContentType("html/text;charset=utf8");
		req.getRequestDispatcher("/JspDemo/EL_Method.jsp").forward(req, resp);
	
	}
}
