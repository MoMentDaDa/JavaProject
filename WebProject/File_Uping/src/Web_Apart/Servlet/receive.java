package Web_Apart.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

//�������ѧ����Ϣ
@WebServlet("/file/receive")
public class receive extends HttpServlet {
	private static final String allowed_IMG_TYPR = "jpg;jpeg;gif;png";

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		// �����ͼ����������ʽ�Ƿ�ΪPOST����������Ƿ�Ϊmmultipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			// ����FileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024);// ���û����С��Ĭ��10KB,����ļ�̫�󣬲�������ڴ�
			factory.getRepository();// ������ʱĿ¼��Ĭ����Tomcat��tmp����
			// �����ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			// ��������
			upload.setFileSizeMax(1024*1024*2);// ���õ����ϴ�����С
			List<FileItem> items = upload.parseRequest(req);
			// ������ÿһ��FileItems
			for (FileItem item : items) {
				String fileName = item.getFieldName();// ��ȡ���ؼ���name����ֵ���������ƣ�
				if (item.isFormField()) {
					// ����ͨ�ؼ�
					String value = item.getString("utf-8");// ��ȡ��ǰ��ͨ���Ĳ���ֵ
					System.out.println(fileName + value);
				} else {
					String fileName2 = item.getName();
					System.out.println(fileName + ":" + fileName2);// headimg:C:\Users\������\Desktop\5.jpg
					System.out.println(FilenameUtils.getName(fileName2));// ��ȡ�ļ����� 5.jpg
					System.out.println(FilenameUtils.getBaseName(fileName2));// ��ȡ�ļ��� 5
					System.out.println(FilenameUtils.getExtension(fileName2));// ��ȡ��չ�� jpg
					System.out.println("--------------------------------");
					// ��ȡ��ǰ�ļ���MIME����
					String mimeType = super.getServletContext().getMimeType(fileName2);
					System.out.println(mimeType);
					String ext = FilenameUtils.getExtension(fileName2);
					String[] allowedIMG = allowed_IMG_TYPR.split(";");
					// ����ļ����Ͳ������У�
					if (!Arrays.asList(allowedIMG).contains(ext)) {
						req.setAttribute("errorMsg", "��ѡ����ȷ���ļ�����");
						req.getRequestDispatcher("/jsp/input.jsp").forward(req, resp);
						return;
					} else {
						String dir = super.getServletContext().getRealPath("/headIMG");// D:\JavaProject\WebProject\File_Uping\WebRoot\headIMG
						System.out.println(dir);
						// ���ϴ��ؼ����Ѷ���������д�뵽�ļ���
						item.write(new File(dir,
								UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName2)));
						System.out.println(item.isInMemory());// �ж��Ƿ����ڴ���
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
