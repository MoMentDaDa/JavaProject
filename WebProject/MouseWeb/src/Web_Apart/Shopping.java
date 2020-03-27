package Web_Apart;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Dao.Mouse;
import JDBC_Apart.Impl.MouseImpl;
import Shoping_Apart.CartItem;
import Shoping_Apart.ShoppingCart;

@WebServlet("/mouse/shop")
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static private MouseImpl dao;

	// 初始化dao对象
	public void init() throws ServletException {
		dao = new MouseImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		// 检查用户是否已经登录
		Object user = req.getSession().getAttribute("USER_IN_SEESSION");
		if (user == null) {
			req.setAttribute("errorMsg", "亲，请你先登录");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
		} else {
			if ("save".equals(cmd)) {
				this.saveServlet(req, resp);
			} else if ("see".equals(cmd)) {
				this.seeServlet(req, resp);
			} else if ("delete".equals(cmd)) {
				this.deleteServlet(req, resp);
			} else if ("edit".equals(cmd)) {
				this.editServlet(req, resp);
			} else if ("update".equals(cmd)) {
				this.updateServlet(req, resp);
			}
		}
	}

	private void updateServlet(HttpServletRequest req, HttpServletResponse resp) {
		Integer num = new Integer(req.getParameter("num"));
		String id = req.getParameter("id");
		ShoppingCart car = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCAR_IN_SESSION");
		CartItem item = car.getOneItems(id);
		item.setNum(num);
		this.seeServlet(req, resp);

	}

	private void editServlet(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		ShoppingCart car = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCAR_IN_SESSION");
		CartItem item = car.getOneItems(id);
		req.setAttribute("item", item);
		try {
			req.getRequestDispatcher("/WEB-INF/shop/edit.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	private void deleteServlet(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		ShoppingCart car = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCAR_IN_SESSION");
		car.delete(id);
		this.seeServlet(req, resp);
	}

	private void seeServlet(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("html/text;charset=utf8");
		resp.setCharacterEncoding("utf-8");
		try {
			// 1、接受请求参数，封装对象 try { ShoppingCart car = (ShoppingCart)
			ShoppingCart car = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCAR_IN_SESSION");

			// 2、调用业务方法，处理请求
			if (car == null) {

				req.setAttribute("null", "购物车为是空的呢，快点去购物吧");
				req.getRequestDispatcher("/WEB-INF/shop/cart_list.jsp").forward(req, resp);
			} else {
				// System.out.println(car);
				req.getSession().getAttribute("SHOPPINGCAR_IN_SESSION");
				// System.out.println("this is list");
				req.getRequestDispatcher("/WEB-INF/shop/cart_list.jsp").forward(req, resp);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// 保存到购物车
	private void saveServlet(HttpServletRequest req, HttpServletResponse resp) {
		Integer num = new Integer(req.getParameter("num"));
		String id = req.getParameter("id");
		Mouse m = dao.get(Integer.valueOf(id));
		// 创建一个商品对象
		CartItem item = new CartItem();
		item.setId(id);
		item.setNum(num);
		item.setName(m.getName());
		String price = m.getPrice();
		String newPrice = "";
		if (price != null && !"".equals(price)) {
			for (int i = 0; i < price.length(); i++) {
				if (price.charAt(i) >= 48 && price.charAt(i) <= 57) {
					newPrice += price.charAt(i);
				}
			}
			BigDecimal p = new BigDecimal(newPrice);
			item.setPrice(p);
			ShoppingCart car = (ShoppingCart) req.getSession().getAttribute("SHOPPINGCAR_IN_SESSION");
			if (car == null) {
				car = new ShoppingCart();
				car.saveItem(item);
			} else {
				car.saveItem(item);
			}
			try {
				req.getSession().setAttribute("SHOPPINGCAR_IN_SESSION", car);
				req.getRequestDispatcher("/WEB-INF/shop/info.jsp").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
