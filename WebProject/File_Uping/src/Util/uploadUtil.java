package Util;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class uploadUtil {
	private static final String allowed_IMG_TYPR = "jpg;jpeg;gif;png";

	public static User service(HttpServletRequest req) throws MyLogicException {
		Map<String, String> filesUser = new HashMap<String, String>();// 用于封装用户注册信息
		try {
			req.setCharacterEncoding("utf-8");
			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			if (!isMultipart) {
				return null;
			}
			// 创建FileItemFactory对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024);// 设置缓存大小，默认10KB,如果文件太大，不会存入内存
			factory.getRepository();// 设置临时目录，默认在Tomcat根tmp里面
			// 创建文件上传处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 3);// 设置单次上传最大大小
			upload.setSizeMax(1024 * 1024 * 4);// 设置单次会话可以上传的文件大小，即包括请求内容大小
			// 解析请求
			List<FileItem> items = upload.parseRequest(req);
			// 迭代出每一个FileItems
			for (FileItem item : items) {
				String name = item.getFieldName();// 获取表单控件的name属性值（参数名称）
				if (item.isFormField()) {
					// 表单普通控件
					String value = item.getString("utf-8");// 获取当前普通表单的参数值
					// System.out.println(fileName + value);
					filesUser.put(name, value);
				} else {

					String fileName2 = item.getName();
					// System.out.println(fileName2);//D:\360downloads\wpcache\360wallpaper.jpg
					// 获取当前文件的MIME类型
					String ext = FilenameUtils.getExtension(fileName2);
					String[] allowedIMG = allowed_IMG_TYPR.split(";");
					// 如果文件类型不再其中，
					if (!Arrays.asList(allowedIMG).contains(ext)) {
						throw new MyLogicException("请上传正确的图片格式");
					} else {
						// 表单上传控件，把二进制数据写入到文件中
						String dir = req.getServletContext().getRealPath("/headIMG");
						String uFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName2);
						filesUser.put("UUID", "/headIMG/" + uFileName);
						filesUser.put("realName", FilenameUtils.getName(fileName2));
						item.write(new File(dir, uFileName));
						// System.out.println(item.isInMemory());判断是否在内存中
					}
				}
			}
		} catch (MyLogicException e) {
			throw e;
		} catch (FileSizeLimitExceededException e) {
			throw new MyLogicException("单次文件不可以超过3M哦", e);
		} catch (SizeLimitExceededException e) {
			throw new MyLogicException("单次会话大小不可以超过4M哦", e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return setInfo(filesUser);
	}

	private static User setInfo(Map<String, String> filesUser) {
		User u = new User();
		u.setName(filesUser.get("username"));
		u.setEmail(filesUser.get("email"));
		u.setDirIMG(filesUser.get("UUID"));
		u.setNameIMG(filesUser.get("realName"));
		return u;
	}
}
