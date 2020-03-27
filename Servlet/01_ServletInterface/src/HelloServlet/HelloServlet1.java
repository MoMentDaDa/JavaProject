package HelloServlet;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



/**
 * @ClassName: HelloServlet1
 * @Description: 通过实现Servlet顶层接口创建Servlet
 * @author: MoMent
 * @date: 2020年2月29日 上午11:33:46
 */
@SuppressWarnings("all")
public class HelloServlet1 implements Servlet {
	// 只被调用一次，第一次请求Servlet时，创建Servlet的实例，调用构造器
	public HelloServlet1() {
		System.out.println("构造器 HelloServelt()...");
	}

	// 该方法用于初始化Servlet，就是把该Servlet装载入内存，该方法只会被调用一次
	public void init(ServletConfig config) throws ServletException {
		System.out.println("初始化方法 init()...");
	}

	// 得到ServletConfig对象
	public ServletConfig getServletConfig() {
		return null;
	}

	// 该方法是服务方法，业务逻辑代码写在这，该方法每次都会被调用
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("执行方法主体 service()...");
		System.out.println("hello world");// 在控制台输出
		// 在浏览器返回
		res.getWriter().println("hello world：" + new java.util.Date().toLocaleString());
	}

	// 该方法得到Servlet配置信息
	public String getServletInfo() {
		return null;
	}

	// 销毁该Servlet，从内存中清除，该方法只会被调用一次
	public void destroy() {
		System.out.println("servlet 销毁时调用方法 destroy()...");
	}
}
