package CookieApply;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showbooks/datils")
@SuppressWarnings("all")
public class goodDetails extends HttpServlet {
	private Cookie temp;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = resp.getWriter();
		String id = req.getParameter("id");
		Cookie[] cookies = req.getCookies();
		temp = fingCookie(cookies);
		// 判断和获取
		if (!id.equals("-1")) {
			if (cookies == null) {
				String curHistoryValue = makeHistory(null, id);
				Cookie cookie = new Cookie("bookHistory", curHistoryValue);
				cookie.setMaxAge(30000);
				resp.addCookie(cookie);
				// System.out.println(curHistoryValue);
			} else {
				String curHistoryValue = makeHistory(temp.getValue(), id);
				temp.setMaxAge(30000);
				temp.setValue(curHistoryValue);
				resp.addCookie(temp);
			}

		}
		if (id.equals("-1")) {
			if (temp != null) {
				temp.setMaxAge(0);
				resp.addCookie(temp);
			}
			resp.sendRedirect("/04/showbooks");
		} else {
			// 由于book的id和商品的id是一致的。获取到用户点击的书
			Book book = (Book) Book.getAll().get(id);
			// 输出书的详细信息
			printWriter.write("书的编号是：" + book.getId() + "<br/>");
			printWriter.write("书的名称是：" + book.getName() + "<br/>");
			printWriter.write("书的作者是：" + book.getAuthor() + "<br/>");
			printWriter.write("<br/>" + "<a href=/04/showbooks>" + "返回" + "</a>");
		}

	}

	private Cookie fingCookie(Cookie[] cookies) {
		for (int i = 0; cookies != null && i < cookies.length; i++) {
			if (cookies[i].getName().equals("bookHistory")) {
				return cookies[i];
			}
		}
		return null;
	}

	private String makeHistory(String bookHistory, String id) {
		if (bookHistory == null) {
			return id;
		}
		// 如果Cookie的值不是null的，那么就分解Cookie的得到之前的id。
		String[] strings = bookHistory.split("\\_");

		// 为了增删容易并且还要判断id是否存在于该字符串内-----我们使用LinkedList集合装载分解出来的id
		List list = Arrays.asList(strings);
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.addAll(list);
		if (linkedList.contains(id)) {
			linkedList.remove(id);
			linkedList.addFirst(id);
		} else {
			if (linkedList.size() >= 3) {
				linkedList.removeLast();
				linkedList.addFirst(id);
			} else {
				linkedList.addFirst(id);
			}
		}
		StringBuffer stringBuffer = new StringBuffer();
		// 遍历LinkedList集合，添加个下划线“_”
		for (String s : linkedList) {
			stringBuffer.append(s + "_");
		}
		// 最后一个元素后面就不需要下划线了
		return stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();

	}
}
