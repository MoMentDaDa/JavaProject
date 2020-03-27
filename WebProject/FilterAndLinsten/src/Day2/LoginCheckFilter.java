package Day2;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;

/**
 * @ClassName: CharacterEncondingFilter
 * @Description: 专门用于字符编码处理
 * @author: 汪哒哒
 * @date: 2019年6月16日 下午2:58:40
 */
public class LoginCheckFilter implements javax.servlet.Filter {
	private String encoding;
	private Boolean forceEnconding;
	// 不需要检查的资源
	private String[] unCheckUris = { "/login.jsp", "login" };

	// 初始化过滤器
	public void init(FilterConfig filterConfig) throws ServletException {
		// 获取XML配置信息
		this.encoding = filterConfig.getInitParameter("encoding");
		forceEnconding = Boolean.valueOf("force");

	}

	// 执行过滤器操作
	public void doFilter(ServletRequest reqest, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 先进行类型转换
		HttpServletRequest req = (HttpServletRequest) reqest;
		HttpServletResponse resp = (HttpServletResponse) response;
		// 获取共享数据
		Object user = req.getSession().getAttribute("USER_IN_SESSION");
		// 设置编码
		// 1、应用中没有编码，且自己设置了编码
		// 2、应用中无编码，但是依然使用自己设置的编码，强制使用
		if (hasLength(encoding) && (req.getCharacterEncoding() == null || forceEnconding)) {
			req.setCharacterEncoding(encoding);
			// req.setCharacterEncoding("utf-8");
			// System.out.println("执行过滤器操作1");

		} else if (user == null) {
			resp.sendRedirect("/login.jsp");
			return;
		}
		chain.doFilter(req, resp);// 放行操作
	}

	private boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

	// 销毁过滤器
	public void destroy() {
		System.out.println("销毁过滤器1");
	}

}
