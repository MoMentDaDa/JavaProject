package Web_Apart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Impl.Mouse_Impl;
import JDBC_Apart.Object.Mouse;

@WebServlet("/mouse/manage")
public class MouseManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static private Mouse_Impl dao;

	// ��ʼ��dao����
	public void init() throws ServletException {
		dao = new Mouse_Impl();
	}

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		// ����û��Ƿ��Ѿ���¼
		Object user = req.getSession().getAttribute("USER_IN_SEESSION");
		if (user == null) {
			req.setAttribute("errorMsg", "�ף������ȵ�¼");
			req.getRequestDispatcher("/login.jsp").forward(req, res);
		} else if ("save".equals(cmd)) {
			this.saveServlet(req, res);
		} else if ("edit".equals(cmd)) {
			this.editServlet(req, res);
		} else if ("delete".equals(cmd)) {
			this.deleteServlet(req, res);
		} else if ("shop".equals(cmd)) {
			this.shopServlet(req, res);
		}
	}

	protected void saveServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �����������
		req.setCharacterEncoding("utf-8");
		Mouse m = new Mouse();
		String id = req.getParameter("id");
		m.setName(req.getParameter("name"));
		m.setPrice(req.getParameter("price"));
		m.setWeight(req.getParameter("weight"));
		m.setMaterial(req.getParameter("material"));
		m.setEngine(req.getParameter("engineering"));
		m.setWire(req.getParameter("wire"));
		m.setFootstick(req.getParameter("footstick"));
		m.setClassiFication(Integer.valueOf(req.getParameter("dirId")));
		if (hasLength(id)) {
			dao.update(m, Integer.valueOf(id));
		} else {
			dao.save(m);
		}
		// 3�����ƽ�����ת
		resp.sendRedirect("/mouse");
	}

	protected void editServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("Utf-8");
		String id = req.getParameter("id");// ����id,�ж��Ƿ���id
		if (hasLength(id)) {
			Mouse m = dao.get(Integer.valueOf(id));
			req.setAttribute("m", m);
		}
		req.getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
	}

	protected void deleteServlet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// �����������
		int id = Integer.valueOf(req.getParameter("id")); // 2������ҵ�񷽷���������
		dao.delete(id); // 3�����ƽ�����ת
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
