package HelloServlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: HelloServlet3
 * @Description:继承 HttpServlet 类创建Servlet实例
 * @author: MoMent
 * @date: 2020年2月29日 上午11:35:22
 */
@SuppressWarnings("all")
public class HelloServlet3 extends HttpServlet {
	// 只被调用一次，第一次请求Servlet时，创建Servlet的实例，调用构造器
	public HelloServlet3() {
		System.out.println("构造器 HelloServelt()...");
	}

	// 该方法用于初始化Servlet，就是把该Servlet装载入内存，该方法只会被调用一次
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化方法 init()...");
	}

	// 该方法是服务方法，业务逻辑代码写在这，该方法每次都会被调用
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("执行方法主体 service()...");
		System.out.println("hello world");// 在控制台输出
		res.getWriter().println("hello world：" + new java.util.Date().toLocaleString());// 在浏览器返回

	}

	// 销毁该Servlet，从内存中清除，该方法只会被调用一次
	public void destroy() {
		System.out.println("servlet 销毁时调用方法 destroy()...");
	}

	// 常我们浏览器发出的请求都是 http 请求，如果我们在处理请求的时候都是在 service() 方法中，这种方式显然不够明确。那么我们通常是 继承 HttpServlet 类，包含各种请求方式
	// 处理get请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	// 处理 post 请求
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	// 得到ServletConfig对象
	public ServletConfig getServletConfig() {
		return null;
	}

	// 该方法得到Servlet配置信息
	public String getServletInfo() {
		return null;
	}
}
