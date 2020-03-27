package ScopeDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class ScopeDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;chatset=utf-8");
		// 使用request
		Integer numInRequest = (Integer) req.getAttribute("NUM_IN_REQUEST");
		if (numInRequest == null) {
			req.setAttribute("NUM_IN_REQUEST", 1);
		} else {
			req.setAttribute("NUM_IN_REQUEST", numInRequest + 1);
		}

		// 使用Sesson
		Integer SES_Request = (Integer) req.getSession().getAttribute("NUM_IN_SESSION");
		if (SES_Request == null) {
			req.getSession().setAttribute("NUM_IN_SESSION", 1);
		} else {
			req.getSession().setAttribute("NUM_IN_SESSION", SES_Request + 1);
		}
		
		// 使用App
		Integer App_Request = (Integer) req.getServletContext().getAttribute("NUM_IN_APPLICATION");
		if (App_Request == null) {
			req.getServletContext().setAttribute("NUM_IN_APPLICATION", 1);
		} else {
			req.getServletContext().setAttribute("NUM_IN_APPLICATION", App_Request + 1);
		}
		
		// 设置页面跳转
		req.getRequestDispatcher("/result").forward(req, resp);
	}
}
