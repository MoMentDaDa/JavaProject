package Web_Apart.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Util.User;
import Util.uploadUtil;

@WebServlet("/file/receive2")
public class receive2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = uploadUtil.service(req);
			req.setAttribute("info", user);
			req.getRequestDispatcher("/jsp/show.jsp").forward(req, resp);
		} catch (Exception e) {
			String msg = e.getMessage();
			req.setAttribute("errorMsg", msg);
			req.getRequestDispatcher("/jsp/input.jsp").forward(req, resp);
		}

	}
}
