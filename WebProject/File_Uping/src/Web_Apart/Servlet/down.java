package Web_Apart.Servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/file/down")
public class down extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 权限检查，积分检查
		// 2、获取被下载的资源名
		String fileName = req.getParameter("fileName");// 获取下载的文件名
		fileName = new String(fileName.getBytes("ISO-8859-1"), "utf-8");// 对下载文件名进行重编码
		// System.out.println(fileName);
		// 3、从服务器中获取被下载资源的绝对路径
		String realPath = super.getServletContext().getRealPath("WEB-INF/DownFile/" + fileName);// 由相对路径获取绝对路径
		// System.out.println(realPath);
		// 4、将文件--->程序----->浏览器（实质为拷贝操作）
		// 5、设置响应头，实现不同浏览器的保存和打开操作
		resp.setContentType("application/x-msdownload");
		// 判断浏览器类型
		String userAgent = req.getHeader("User-Agent");
		// System.out.println(userAgent);
		if (userAgent.contains("MSIE")) {
			// IE方式
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			// 5.1 非IE，
			fileName = new String(fileName.getBytes("utf-8"), "ISO-8895-1");
		}

		resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);// 设置下载时的名字
		Files.copy(Paths.get(realPath), resp.getOutputStream());

	}
}
