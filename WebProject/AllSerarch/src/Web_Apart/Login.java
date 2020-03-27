package Web_Apart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBC_Apart.Dao.User_Dao;
import JDBC_Apart.Impl.User_Impl;
import JDBC_Apart.Object.User;

/**
 * @ClassName: Login
 * @Description: TODO
 * @author: 汪哒哒
 * @date: 2019年6月13日 上午11:15:13
 */
/**
 * @ClassName: Login
 * @Description: TODO
 * @author: 汪哒哒
 * @date: 2019年6月13日 上午11:15:21
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private User_Dao dao;

	@Override
	public void init() throws ServletException {
		dao = new User_Impl();
	}

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String cmd = req.getParameter("cmd");
		if ("login".equals(cmd)) {
			this.loginServlet(req, resp);
		} else if ("login_Out".equals(cmd)) {
			this.login_out_Servlet(req, resp);
		} else if ("random".equals(cmd)) {
			this.randomServlet(req, resp);

		}
	}

	// 用户登录处理
	private void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求参数

		String token_in_session = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		String token = req.getParameter("token");
		//System.out.println(token_in_session);
		//System.out.println(token);
		// 判断验证码是否已经使用
		if (token.equals(token_in_session) && token_in_session != null) {
			// 判断验证码错与否
			String randomCode = req.getParameter("random");
			String RANDOM_IN_SESSION = (String) req.getSession().getAttribute("RANDOMCONDE_IN_SESSION");
			//System.out.println(RANDOM_IN_SESSION);
			//System.out.println(randomCode);
			if (!randomCode.equalsIgnoreCase(RANDOM_IN_SESSION)) {
				req.setAttribute("errorMsg", "亲验证码错误或者已过期");
				req.getRequestDispatcher("/login.jsp").forward(req, resp);
				return;
			}
		} else {
			resp.sendRedirect("/login.jsp");
			return;
		}
		String name = req.getParameter("usename");
		String password = req.getParameter("password");
		//System.out.println(name + password);
		// 调用业务处理方法
		User user = dao.getUserName(name);
		// 控制跳转模块
		// 检查账户是否存在
		if (user == null) {
			req.setAttribute("errorMsg", "该用户不存在");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		if (!user.getPassword().equals(password)) {
			// 检查密码是否存在
			req.setAttribute("errorMsg", "密码错误");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}

		// 把当前用户存到Session中
		req.getSession().setAttribute("USER_IN_SEESSION", user);
		resp.sendRedirect("/mouse");

	}

// 用户登出处理
	private void login_out_Servlet(HttpServletRequest req, HttpServletResponse resp) {
		// 方式1、删除session中key为USER_IN_SESSION的属性
		// req.getSession().removeAttribute("USER_IN_SESSION");
		// 方式2：直接删除session对象
		req.getSession().invalidate();
		try {
			resp.sendRedirect("/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// 用于输出验证码图片
	private void randomServlet(HttpServletRequest req, HttpServletResponse resp) {
		// 生成随机字符
		String randomCode = UUID.randomUUID().toString().substring(0, 5);
		// 把随机数放入到session中
		req.getSession().setAttribute("RANDOMCONDE_IN_SESSION", randomCode);
		// 创建图片对象
		int width = 70;
		int height = 40;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);
		// 创建画板对象
		Graphics g = image.getGraphics();
		g.setColor(Color.green);
		// 绘制一个实心矩形
		g.fillRect(1, 1, width - 2, height - 2);

		// 把随机数放入到图画中，
		g.setColor(Color.pink);// 设置随机数颜色
		Font font = new Font("楷体", Font.BOLD, 16); // 定义字体样式
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height); // 绘制背景
		g.setFont(font); // 设置字体和大小
		g.drawString(randomCode, 10, 28);
		// 随机绘制干扰线
		g.setColor(Color.red);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}
		// 关闭画板
		g.dispose();
		// 把图像以流的方式保存出去
		try {
			ImageIO.write(image, "jpg", resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* 该方法主要作用是获得随机生成的颜色 */
	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r, g, b;
		r = s + random.nextInt(e - s); // 随机生成RGB颜色中的r值
		g = s + random.nextInt(e - s); // 随机生成RGB颜色中的g值
		b = s + random.nextInt(e - s); // 随机生成RGB颜色中的b值
		return new Color(r, g, b);
	}

}
