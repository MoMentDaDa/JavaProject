package Web_Apart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Impl.MouseImpl;

@WebServlet("/mouse")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static private MouseImpl dao;

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new MouseImpl();
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		// 检查用户是否已经登录
		/*
		 * Object user = req.getSession().getAttribute("USER_IN_SEESSION"); if (user ==
		 * null) { req.setAttribute("errorMsg", "亲，请你先登录");
		 * req.getRequestDispatcher("/login.jsp").forward(req, res); }
		 */

		if ("save".equals(cmd)) {
			this.saveServlet(req, res);
		} else if ("edit".equals(cmd)) {
			this.editServlet(req, res);
		} else if ("delete".equals(cmd)) {
			this.deleteServlet(req, res);
		} else if ("shop".equals(cmd)) {
			this.shopServlet(req, res);
		} else {
			this.list(req, res);

		}
	}

//列表操作

	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("html/text;charset=utf8");
		req.setCharacterEncoding("utf-8");
		List<Mouse> li = (dao.list());
		req.setAttribute("mouses", dao.list());
		// 2、调用业务方法，处理请求
		req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
		// 3、控制界面跳转

	}

	protected void saveServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接受请求参数
		req.setCharacterEncoding("utf-8");
		Mouse m = new Mouse();
		String id = req.getParameter("id");
		m.setName(req.getParameter("name"));
		m.setPrice(req.getParameter("price"));
		m.setWeight(req.getParameter("weight"));
		m.setMaterial(req.getParameter("material"));
		m.setEngineering(req.getParameter("engineering"));
		if (hasLength(id)) {
			dao.update(m, Integer.valueOf(id));
		} else {
			dao.save(m);
		}
		// 3、控制界面跳转
		resp.sendRedirect("/mouse");
	}

	protected void editServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Utf-8");
		String id = req.getParameter("id");// 接受id,判断是否有id
		if (hasLength(id)) {
			Mouse m = dao.get(Integer.valueOf(id));
			req.setAttribute("m", m);
		}
		req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
	}

	protected void deleteServlet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 接受请求参数
		int id = Integer.valueOf(req.getParameter("id")); // 2、调用业务方法处理请求
		dao.delete(id); // 3、控制界面跳转
		resp.sendRedirect("/mouse");
	}

	private void shopServlet(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		Mouse m = dao.get(Integer.valueOf(id));
		req.setAttribute("m", m);
		try {
			req.getRequestDispatcher("/WEB-INF/shop/product.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

}
