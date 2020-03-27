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
		Map<String, String> filesUser = new HashMap<String, String>();// ���ڷ�װ�û�ע����Ϣ
		try {
			req.setCharacterEncoding("utf-8");
			boolean isMultipart = ServletFileUpload.isMultipartContent(req);
			if (!isMultipart) {
				return null;
			}
			// ����FileItemFactory����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024);// ���û����С��Ĭ��10KB,����ļ�̫�󣬲�������ڴ�
			factory.getRepository();// ������ʱĿ¼��Ĭ����Tomcat��tmp����
			// �����ļ��ϴ�������
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 3);// ���õ����ϴ�����С
			upload.setSizeMax(1024 * 1024 * 4);// ���õ��λỰ�����ϴ����ļ���С���������������ݴ�С
			// ��������
			List<FileItem> items = upload.parseRequest(req);
			// ������ÿһ��FileItems
			for (FileItem item : items) {
				String name = item.getFieldName();// ��ȡ���ؼ���name����ֵ���������ƣ�
				if (item.isFormField()) {
					// ����ͨ�ؼ�
					String value = item.getString("utf-8");// ��ȡ��ǰ��ͨ���Ĳ���ֵ
					// System.out.println(fileName + value);
					filesUser.put(name, value);
				} else {

					String fileName2 = item.getName();
					// System.out.println(fileName2);//D:\360downloads\wpcache\360wallpaper.jpg
					// ��ȡ��ǰ�ļ���MIME����
					String ext = FilenameUtils.getExtension(fileName2);
					String[] allowedIMG = allowed_IMG_TYPR.split(";");
					// ����ļ����Ͳ������У�
					if (!Arrays.asList(allowedIMG).contains(ext)) {
						throw new MyLogicException("���ϴ���ȷ��ͼƬ��ʽ");
					} else {
						// ���ϴ��ؼ����Ѷ���������д�뵽�ļ���
						String dir = req.getServletContext().getRealPath("/headIMG");
						String uFileName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(fileName2);
						filesUser.put("UUID", "/headIMG/" + uFileName);
						filesUser.put("realName", FilenameUtils.getName(fileName2));
						item.write(new File(dir, uFileName));
						// System.out.println(item.isInMemory());�ж��Ƿ����ڴ���
					}
				}
			}
		} catch (MyLogicException e) {
			throw e;
		} catch (FileSizeLimitExceededException e) {
			throw new MyLogicException("�����ļ������Գ���3MŶ", e);
		} catch (SizeLimitExceededException e) {
			throw new MyLogicException("���λỰ��С�����Գ���4MŶ", e);
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
