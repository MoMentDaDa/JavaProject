package CookieApply;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
@WebServlet("/cookie/showlogintime")
public class showLastLoginTime extends HttpServlet {
	// 由于日期显示包含空格，但对于Cookie的值是非法的，因为ASCII码表中，character [32]对应的是一个空格，这样是不可以的

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		// 获取网页上所有的Cookie
		Cookie[] cookies = request.getCookies();
		// 判断Cookie的值是否为空
		String cookieValue = null;
		// 如果Cookie的值是空的，那么就是第一次访问
		if (cookies == null) {
			// 创建一个Cookie对象，日期为当前时间
			String curTime = URLEncoder.encode(simpleDateFormat.format(new Date()), "utf-8");
			Cookie cookie = new Cookie("time", curTime);
			System.out.println(simpleDateFormat.format(new Date()));
			// 设置Cookie的生命期
			cookie.setMaxAge(20000);
			// response对象回送Cookie给浏览器
			response.addCookie(cookie);
			printWriter.write("您是第一次登陆啊！" + simpleDateFormat.format(new Date()));
		} else {
			for (int i = 0; i < cookies.length; i++) {
				// 获取到以time为名的Cookie
				if (cookies[i].getName().equals("time")) {
					response.getWriter().write("欢迎回来，你上次访问的时间为：" + URLDecoder.decode(cookies[i].getValue(), "utf-8") + ",当前时间为："
							+ URLDecoder.decode(URLEncoder.encode(simpleDateFormat.format(new Date()), "utf-8"), "utf-8"));
					cookies[i].setValue(URLEncoder.encode(simpleDateFormat.format(new Date()), "utf-8"));
					response.addCookie(cookies[i]);
					// 既然已经找到了就可以break循环了
					break;
				}
			}

		}

	}
}
