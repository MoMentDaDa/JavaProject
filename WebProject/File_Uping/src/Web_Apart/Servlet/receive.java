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

//保存更新学生信息
@WebServlet("/file/receive")
public class receive extends HttpServlet {
	private static final String allowed_IMG_TYPR = "jpg;jpeg;gif;png";

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		// 解析和检查请求，请求方式是否为POST，请求编码是否为mmultipart/form-data
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (!isMultipart) {
			return;
		}
		try {
			// 创建FileItemFactory对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024);// 设置缓存大小，默认10KB,如果文件太大，不会存入内存
			factory.getRepository();// 设置临时目录，默认在Tomcat根tmp里面
			// 创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求
			upload.setFileSizeMax(1024*1024*2);// 设置单次上传最大大小
			List<FileItem> items = upload.parseRequest(req);
			// 迭代出每一个FileItems
			for (FileItem item : items) {
				String fileName = item.getFieldName();// 获取表单控件的name属性值（参数名称）
				if (item.isFormField()) {
					// 表单普通控件
					String value = item.getString("utf-8");// 获取当前普通表单的参数值
					System.out.println(fileName + value);
				} else {
					String fileName2 = item.getName();
					System.out.println(fileName + ":" + fileName2);// headimg:C:\Users\汪哒哒\Desktop\5.jpg
					System.out.println(FilenameUtils.getName(fileName2));// 获取文件名称 5.jpg
					System.out.println(FilenameUtils.getBaseName(fileName2));// 获取文件名 5
					System.out.println(FilenameUtils.getExtension(fileName2));// 获取扩展名 jpg
					System.out.println("--------------------------------");
					// 获取当前文件的MIME类型
					String mimeType = super.getServletContext().getMimeType(fileName2);
					System.out.println(mimeType);
					String ext = FilenameUtils.getExtension(fileName2);
					String[] allowedIMG = allowed_IMG_TYPR.split(";");
					// 如果文件类型不再其中，
					if (!Arrays.asList(allowedIMG).contains(ext)) {
						req.setAttribute("errorMsg", "请选择正确的文件类型");
						req.getRequestDispatcher("/jsp/input.jsp").forward(req, resp);
						return;
					} else {
						String dir = super.getServletContext().getRealPath("/headIMG");// D:\JavaProject\WebProject\File_Uping\WebRoot\headIMG
						System.out.println(dir);
						// 表单上传控件，把二进制数据写入到文件中
						item.write(new File(dir,
								UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName2)));
						System.out.println(item.isInMemory());// 判断是否在内存中
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
