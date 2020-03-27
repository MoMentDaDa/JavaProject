package Web_Apart.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.DaoMain.Student;
import JDBC_Apart.Impl.ImplementslAchieveDemo;

//保存更新学生信息
@WebServlet("/crud/save")
public class UpdateStudnet extends HttpServlet {
	private ImplementslAchieveDemo dao;

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}
}
