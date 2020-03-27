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
		// Ȩ�޼�飬���ּ��
		// 2����ȡ�����ص���Դ��
		String fileName = req.getParameter("fileName");// ��ȡ���ص��ļ���
		fileName = new String(fileName.getBytes("ISO-8859-1"), "utf-8");// �������ļ��������ر���
		// System.out.println(fileName);
		// 3���ӷ������л�ȡ��������Դ�ľ���·��
		String realPath = super.getServletContext().getRealPath("WEB-INF/DownFile/" + fileName);// �����·����ȡ����·��
		// System.out.println(realPath);
		// 4�����ļ�--->����----->�������ʵ��Ϊ����������
		// 5��������Ӧͷ��ʵ�ֲ�ͬ������ı���ʹ򿪲���
		resp.setContentType("application/x-msdownload");
		// �ж����������
		String userAgent = req.getHeader("User-Agent");
		// System.out.println(userAgent);
		if (userAgent.contains("MSIE")) {
			// IE��ʽ
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
			// 5.1 ��IE��
			fileName = new String(fileName.getBytes("utf-8"), "ISO-8895-1");
		}

		resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);// ��������ʱ������
		Files.copy(Paths.get(realPath), resp.getOutputStream());

	}
}
