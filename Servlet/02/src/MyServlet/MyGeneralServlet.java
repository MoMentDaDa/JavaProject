package MyServlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName: MyGeneralServlet
 * @Description: 手写MyGeneralServlet
 * @author: MoMent
 * @date: 2020年3月1日 下午7:14:17
 */
@SuppressWarnings("all")
abstract public class MyGeneralServlet implements Servlet, ServletConfig, Serializable {
	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		this.init();
	}

	// 提供一个公共的无参数的初始化init方法，用于子类实现自定义初始化操作
	public void init() {
	}

//向外暴露接口，返回给config参数
	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

//使用抽象类实现服务的必须覆写
	@Override
	abstract public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

//实现config未实现的方法
	@Override
	public String getServletName() {
		return config.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return config.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		return config.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return config.getInitParameterNames();
	}
}