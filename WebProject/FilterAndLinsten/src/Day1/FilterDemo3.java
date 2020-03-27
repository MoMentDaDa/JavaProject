package Day1;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo3 implements javax.servlet.Filter {
	// 初始化过滤器
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化过滤器3");

	}

	// 执行过滤器操作
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("执行过滤器操作3");
		chain.doFilter(req, resp);// 放行操作
	}

	// 销毁过滤器
	public void destroy() {
		System.out.println("销毁过滤器3");
	}

}
