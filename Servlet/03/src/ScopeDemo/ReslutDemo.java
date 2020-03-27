package ScopeDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ReslutDemo extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;chatset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("Request:" + req.getAttribute("NUM_IN_REQUEST")+"<br/>");
		out.println("Session:" + req.getSession().getAttribute("NUM_IN_SESSION"));
		out.println("<br/>"+"Application:" + req.getServletContext().getAttribute("NUM_IN_APPLICATION"));

	}
}
