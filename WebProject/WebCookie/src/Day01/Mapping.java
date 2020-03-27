package Day01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Servlet的映射细节
@WebServlet(value = "/M")
public class Mapping extends HttpServlet {
	private String name;
	// http://192.168.43.57/M?name=will

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html,charset=UTF-8");
		PrintWriter out = resp.getWriter();
		name = req.getParameter("name");
		name = new String(name.getBytes("ISO-8859-1"), "utf-8");
		out.println("你的名字是：" + name);
	}

}
