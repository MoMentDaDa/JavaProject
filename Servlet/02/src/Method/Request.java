package Method;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: CommonMethods
 * @Description: 演示req常用方法
 * @author: MoMent
 * @date: 2020年3月2日 下午3:27:02
 */
@SuppressWarnings("all")
public class Request extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*	
			// 1. 获取请求头的方法演示
			System.out.println("localhost:" + req.getHeader("Host"));
			System.out.println("" + req.getIntHeader("DNT"));
			// 获取所有头信息,并迭代显示
			Enumeration<String> headerNames = req.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String name = (String) headerNames.nextElement();
				String value = req.getHeader(name);
				System.out.println(name + "=" + value);
		
			}
		*/
		// 2. 获取到的是客户端提交上来的数据
		// 表单Post方式
		req.setCharacterEncoding("UTF-8");// 设置req字符编码的格式
		// 通过html的name属性，获取到值
		System.out.println(req.getParameter("username"));
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("gender"));
		// 复选框和下拉框有多个值，获取到多个值
		System.out.println(Arrays.toString(req.getParameterValues("hobbies")));
		System.out.println(Arrays.toString(req.getParameterValues("address")));
		System.out.println(req.getParameter("textarea")); // 获取到文本域的值
		System.out.println(req.getParameter("aaa"));// 得到隐藏域的值
		Enumeration<String> parameterNames = req.getParameterNames(); // 获取所有的参数，得到一个枚举集合
		while (parameterNames.hasMoreElements()) {
			String name = (String) parameterNames.nextElement();
			String value = req.getParameter(name);
			System.out.println(name + "=" + value);

		}
		Map<String, String[]> map = req.getParameterMap(); // 获取所有的参数，得到一个Map集合
		for (String name : map.keySet()) {
			String[] values = map.get(name);
			System.out.println(name + ":" + Arrays.toString(values));
		}
		// 表单get方式,即浏览器直接通过请求字符串的形式传递数据，常见方式有超链接和重定向
		// 通过超链接方式
		System.out.println("超链接的方式：" + req.getParameter("username1"));

		// 防盗链
		// 获取到网页是从哪里来的
		String referer = req.getHeader("Referer");
		// 如果不是从我的首页来或者从地址栏直接访问的，
		if (referer == null || !referer.contains("localhost/02/Views/Index.html")) {
			// 回到首页去
			resp.sendRedirect("/02/Views/Index.html");
			return;
		}
		// 能执行下面的语句，说明是从我的首页点击进来的，那没问题，照常显示
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().write("路飞做了XXXXxxxxxxxxxxxxxxxx");
	}
}
