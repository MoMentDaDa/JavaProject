package ContextLoging;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("all")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 从前端页面获取数据
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("userName=" + userName + "；password=" + password);
		PrintWriter pw = response.getWriter();
		// 校验数据并向客户端输出内容,成功并输出
		/*
			if ("admin".equals(userName) && "123".equals(password)) {
				pw.write("login success..");
			}else {
				pw.write("login failed..");
			}
		*/
		if ("admin".equals(userName) && "123".equals(password)) {
			// 成功并跳转，并显示成功次数
			Object obj = getServletContext().getAttribute("count");// 获取以前存的值 ， 然后在旧的值基础上 + 1
			int totalCount = 0;// 默认就是0次
			if (obj != null) {
				totalCount = (int) obj;
			}
			System.out.println("已知登录成功的次数是：" + totalCount);
			getServletContext().setAttribute("count", totalCount + 1);// 给这个count赋新的值
			// 2. 跳转到成功的界面，设置状态码, 重新定位 状态码
			response.setStatus(302);
			// 定位跳转的位置是哪一个页面,跳转影指明项目路径,否则直接localhost/Views/welcome.html
			response.setHeader("Location", "/02/Views/welcome.html");
		} else {
			pw.write("login failed..");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}