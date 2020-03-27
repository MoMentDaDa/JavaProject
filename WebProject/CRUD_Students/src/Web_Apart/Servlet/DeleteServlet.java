package Web_Apart.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Impl.ImplementslAchieveDemo;

//处理删除指定学生
@WebServlet("/crud/delete")
public class DeleteServlet extends HttpServlet {
	private ImplementslAchieveDemo dao;

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new ImplementslAchieveDemo();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求参数
		Long id = Long.valueOf(req.getParameter("id"));
		// 2、调用业务方法处理请求
		dao.delete(id);
		// 3、控制界面跳转
		resp.sendRedirect("/crud/list");
	}
}
