package FileStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CloseFileResourceDemo {
	public static void main(String[] args) {
		test1();
		test2();
	}

	// ʹ��1.7���Զ���Դ�رմ����쳣
	private static void test2() {
		File srcFile = new File("FilesTest/stream.txt");
		File desFile = new File("FilesTest/stream_copy1.txt");
		try (
				InputStream in = new FileInputStream(srcFile); 
				OutputStream out = new FileOutputStream(desFile);
			) {
				byte[] buffer = new byte[2];
				int len = -1;
				while ((len = in.read(buffer)) != -1) {
					System.out.println(new String(buffer, 0, len));
					out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ͳ��ʽ�����쳣
	private static void test1() {
		InputStream in = null;
		OutputStream out = null;
		try {
			// 1����������Դ
			File srcFile = new File("FilesTest/stream.txt");
			File desFile = new File("FilesTest/stream_copy2.txt");
			// 2�����������ܵ�
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(desFile);
			// 3����ȡ����
			byte[] buffer = new byte[2];
			int len = -1;
			while ((len = in.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, len));
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 4���رչܵ�����Դ��
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
