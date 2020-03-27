package ServletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@SuppressWarnings("all")
public class GenericServletConfig extends GenericServlet {
	private ServletContext servletContext;

	@Override
	public void service(ServletRequest req, ServletResponse response) throws ServletException, IOException {
		ServletConfig config = this.getServletConfig();
		// 为Servlet之间的通讯设置数据，格式为 key=value 模式
		config.getServletContext().setAttribute("myValue", "testCommunication");
		config.getServletContext().setAttribute("myValue2", "testCommunication2");
		// 获取整个站点的配置信息
		System.out.println("全站配置参数" + config.getServletContext().getInitParameter("webConfig"));
		
		System.out.println(config);
		// 设置响应格式
		response.setContentType("text/html;charset=UTF-8");
		// 获取一个打印输出流
		PrintWriter out = response.getWriter();
		// 获取servlet的名字
		String sName = config.getServletName();
		// 获取参数的所有名字，即key值数组
		Enumeration<String> initNames = config.getInitParameterNames();
		// 向页面打印输出信息
		out.println("Servlet的名字是：" + config.getServletName() + "<br>");
		while (initNames.hasMoreElements()) {
			String name = initNames.nextElement();
			out.println("参数 " + name + "的值为：" + config.getInitParameter(name) + "<br>");
		}

		out.flush();
		out.close();

	}

}
