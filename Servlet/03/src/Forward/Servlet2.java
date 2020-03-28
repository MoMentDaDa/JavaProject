package Forward;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward/s2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("请求之前，servlet1快来了....");
		String data=(String) req.getAttribute("data");
		System.out.println("请求之后，Servlet2接到请求，并访问文件...."+data);
		req.getRequestDispatcher("/WEB-INF/web-inf.html").forward(req, resp);
	}
}