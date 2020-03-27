package Cookie;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
@WebServlet("/cookie/s1")
public class Servlet1 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置response的编码
		response.setContentType("text/html;charset=UTF-8");
		// 创建Cookie对象，指定名称和值
		Cookie cookie = new Cookie("username", "wangdada");
		// 向浏览器给一个Cookie
		response.addCookie(cookie);
		// 关闭浏览器后，cookie 就没有了。正值 ： 表示 在这个数字过后，cookie 将会失效。负值： 关闭浏览器，那么cookie 就失效， 默认值是 -1，以秒计算,0为删除
		cookie.setMaxAge(2000);
		// 网上说是要对字符进行编码，但是实际测试发现，可以不用进行转码，如果进行了编码，那取出来也一定得进行转码
		/*	Cookie cookie2 = new Cookie("country", "中国");
			response.addCookie(cookie2);
			cookie2.setMaxAge(2000);
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					String cookieName = c.getName();
					String cookieValue = c.getValue();
					response.getWriter().write(cookieName + ":" + cookieValue + "<br>");
				}
			}*/

		// 修改，一是set方法，二是同名覆盖,同名覆盖value、maxAge之外的所有属性都要与原Cookie相同。否则浏览器将视为不同的Cookie，不予覆盖，导致删除修改失败
		/*response.getWriter().write("原值：" + request.getCookies()[1].getValue() + "<br>");
		request.getCookies()[1].setValue("美国");
		response.addCookie(request.getCookies()[1]);// 一定不要忘记添加到浏览器中);
		response.getWriter().write("这是set修改：" + request.getCookies()[1].getValue() + "<br>");
		*/
		
		/*response.getWriter().write("原值：" + request.getCookies()[1].getValue() + "<br>");
		Cookie cookie3 = new Cookie("country", "印度");
		response.addCookie(cookie3);
		response.getWriter().write("这是同名覆盖修改后的：" + request.getCookies()[1].getValue() + "<br>");*/

		// 删除Cookie,直接将生命设置为0即可，删除也得遵循上面的原则
		/*Cookie[] cookies = request.getCookies();
		Cookie delete = cookies[1];
		delete.setMaxAge(0);
		response.addCookie(request.getCookies()[1]);
		if (request.getCookies()[1] == null) {
			response.getWriter().write("删除成功" + "<br>");
		}*/

		// 路径,查看是否能够获得s2中的cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				String cookieName = c.getName();
				String cookieValue = c.getValue();
				response.getWriter().write(cookieName + ":" + cookieValue + "<br>");
			}
		}

	}
}
