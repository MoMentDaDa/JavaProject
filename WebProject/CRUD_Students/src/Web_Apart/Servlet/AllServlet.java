package Web_Apart.Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.DaoMain.Student;
import JDBC_Apart.Impl.ImplementslAchieveDemo;

//servlet合并操作
@WebServlet("/crud")
public class AllServlet extends HttpServlet {
	private ImplementslAchieveDemo dao;

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		if ("save".equals(cmd)) {
			this.saveServlet(req, res);
		} else if ("edit".equals(cmd)) {
			this.editServlet(req, res);
		} else if ("delete".equals(cmd)) {
			this.deleteServlet(req, res);
		} else {
			this.list(req, res);
		}
	}

//列表操作

	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("html/text;charset=utf8");
		req.setCharacterEncoding("utf-8");
		// 1、接受请求参数，封装对象
		req.setAttribute("student", dao.listAll());
		// 2、调用业务方法，处理请求
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		// 3、控制界面跳转

	}

	protected void saveServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求参数
		req.setCharacterEncoding("utf-8");
		Student stu = new Student();
		String id = req.getParameter("id");
		stu.setName(req.getParameter("name"));
		stu.setEmail(req.getParameter("email"));
		stu.setAge(Integer.valueOf(req.getParameter("age")));
		if (hasLength(id)) {
			dao.update(Long.valueOf(id), stu);
		} else {
			dao.sava(stu);
		}
		// 3、控制界面跳转
		resp.sendRedirect("/crud/list");
	}

	protected void editServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Utf-8");
		// 接受id,是否有id
		String id = req.getParameter("id");
		if (hasLength(id)) {
			Student stu = dao.get(Long.valueOf(id));
			req.setAttribute("student", stu);
		}
		req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
	}

	protected void deleteServlet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接受请求参数
		Long id = Long.valueOf(req.getParameter("id"));
		// 2、调用业务方法处理请求
		dao.delete(id);
		// 3、控制界面跳转
		resp.sendRedirect("/crud/list");
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
