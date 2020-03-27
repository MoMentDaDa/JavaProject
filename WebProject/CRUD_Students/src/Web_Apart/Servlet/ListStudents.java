package Web_Apart.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Impl.ImplementslAchieveDemo;

//处理学生列表的请求
@WebServlet("/crud/list")
public class ListStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ImplementslAchieveDemo dao;

//初始化dao对象
	@Override
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("html/text;charset=utf8");
		req.setCharacterEncoding("utf-8");
		// 1、接受请求参数，封装对象
		req.setAttribute("student", dao.listAll());
		// 2、调用业务方法，处理请求
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		// 3、控制界面跳转

	}
}