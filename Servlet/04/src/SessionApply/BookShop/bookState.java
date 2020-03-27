package SessionApply.BookShop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

import CookieApply.Book;

@WebServlet("/session/shopstate")
@SuppressWarnings("all")
public class bookState extends HttpServlet {
	private HashMap<String, Integer> list;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter printWriter = resp.getWriter();
		// 获取到Session对象
		HttpSession httpSession = req.getSession();
		// 得到用户想买书籍的id
		String id = req.getParameter("id");
		if (id.equals("-1")) {
			httpSession.removeAttribute("bookList");
			resp.sendRedirect("/04/session/bookcart");
		} else {
			// 根据书籍的id找到用户想买的书
			Book book = (Book) Book.getAll().get(id);
			printWriter.write("购买的书为：" + book.getId() + book.getName() + "加入成功");
			printWriter.write("<br>");
			if (httpSession.getAttribute("bookList") == null) {
				list = new HashMap<String, Integer>();
				// 把书籍加入到list集合中
				list.put(book.getName(), Integer.valueOf(1));
				// 设置Session属性
				httpSession.setAttribute("bookList", list);
				printWriter.write("<br>");
			} else {
				list = (HashMap<String, Integer>) httpSession.getAttribute("bookList");
				if (list.containsKey(book.getName())) {
					list = change(list, book);
					// list.forEach((key,value)->{System.out.println(key+value);});
				} else {
					list.put(book.getName(), Integer.valueOf(1));
				}
				httpSession.setAttribute("bookList", list);
			}
		}
		printWriter.write("<a href=/04/session/bookcart>" + "查看购物车" + "</a>");
		printWriter.write("<br>");
		printWriter.write("<a href=/04/session/shop>" + "继续购物" + "</a>");
	}

	private HashMap<String, Integer> change(HashMap<String, Integer> list, Book book) {
		for (Entry<String, Integer> key : list.entrySet()) {
			if (key.getKey().equals(book.getName())) {
				int i = key.getValue().intValue();
				list.put(book.getName(), Integer.valueOf(++i));
				return list;
			}
		}
		return null;
	}
}
