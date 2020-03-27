package Day3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/day2/login")
public class login extends HttpServlet {
	static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String password = req.getParameter("password");
		//System.out.println(name + ":" + password);
		req.getSession().setAttribute("USER_IN_SESSION", name);
		req.getRequestDispatcher("/welcome.jsp").forward(req, resp);

	}
}
