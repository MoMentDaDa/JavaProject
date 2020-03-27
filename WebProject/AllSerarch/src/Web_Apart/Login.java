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
 * @author: ������
 * @date: 2019��6��13�� ����11:15:13
 */
/**
 * @ClassName: Login
 * @Description: TODO
 * @author: ������
 * @date: 2019��6��13�� ����11:15:21
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

	// �û���¼����
	private void loginServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��ȡ�������

		String token_in_session = (String) req.getSession().getAttribute("TOKEN_IN_SESSION");
		String token = req.getParameter("token");
		//System.out.println(token_in_session);
		//System.out.println(token);
		// �ж���֤���Ƿ��Ѿ�ʹ��
		if (token.equals(token_in_session) && token_in_session != null) {
			// �ж���֤������
			String randomCode = req.getParameter("random");
			String RANDOM_IN_SESSION = (String) req.getSession().getAttribute("RANDOMCONDE_IN_SESSION");
			//System.out.println(RANDOM_IN_SESSION);
			//System.out.println(randomCode);
			if (!randomCode.equalsIgnoreCase(RANDOM_IN_SESSION)) {
				req.setAttribute("errorMsg", "����֤���������ѹ���");
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
		// ����ҵ������
		User user = dao.getUserName(name);
		// ������תģ��
		// ����˻��Ƿ����
		if (user == null) {
			req.setAttribute("errorMsg", "���û�������");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}
		if (!user.getPassword().equals(password)) {
			// ��������Ƿ����
			req.setAttribute("errorMsg", "�������");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}

		// �ѵ�ǰ�û��浽Session��
		req.getSession().setAttribute("USER_IN_SEESSION", user);
		resp.sendRedirect("/mouse");

	}

// �û��ǳ�����
	private void login_out_Servlet(HttpServletRequest req, HttpServletResponse resp) {
		// ��ʽ1��ɾ��session��keyΪUSER_IN_SESSION������
		// req.getSession().removeAttribute("USER_IN_SESSION");
		// ��ʽ2��ֱ��ɾ��session����
		req.getSession().invalidate();
		try {
			resp.sendRedirect("/login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// ���������֤��ͼƬ
	private void randomServlet(HttpServletRequest req, HttpServletResponse resp) {
		// ��������ַ�
		String randomCode = UUID.randomUUID().toString().substring(0, 5);
		// ����������뵽session��
		req.getSession().setAttribute("RANDOMCONDE_IN_SESSION", randomCode);
		// ����ͼƬ����
		int width = 70;
		int height = 40;
		int imageType = BufferedImage.TYPE_INT_RGB;
		BufferedImage image = new BufferedImage(width, height, imageType);
		// �����������
		Graphics g = image.getGraphics();
		g.setColor(Color.green);
		// ����һ��ʵ�ľ���
		g.fillRect(1, 1, width - 2, height - 2);

		// ����������뵽ͼ���У�
		g.setColor(Color.pink);// �����������ɫ
		Font font = new Font("����", Font.BOLD, 16); // ����������ʽ
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height); // ���Ʊ���
		g.setFont(font); // ��������ʹ�С
		g.drawString(randomCode, 10, 28);
		// ������Ƹ�����
		g.setColor(Color.red);
		Random r = new Random();
		for (int i = 0; i < 100; i++) {
			g.fillRect(r.nextInt(width), r.nextInt(height), 2, 2);
		}
		// �رջ���
		g.dispose();
		// ��ͼ�������ķ�ʽ�����ȥ
		try {
			ImageIO.write(image, "jpg", resp.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* �÷�����Ҫ�����ǻ��������ɵ���ɫ */
	public Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255)
			s = 255;
		if (e > 255)
			e = 255;
		int r, g, b;
		r = s + random.nextInt(e - s); // �������RGB��ɫ�е�rֵ
		g = s + random.nextInt(e - s); // �������RGB��ɫ�е�gֵ
		b = s + random.nextInt(e - s); // �������RGB��ɫ�е�bֵ
		return new Color(r, g, b);
	}

}
