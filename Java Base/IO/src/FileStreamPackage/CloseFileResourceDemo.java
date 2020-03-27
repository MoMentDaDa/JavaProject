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

	// 使用1.7的自动资源关闭处理异常
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

	// 传统方式处理异常
	private static void test1() {
		InputStream in = null;
		OutputStream out = null;
		try {
			// 1、创建拷贝源
			File srcFile = new File("FilesTest/stream.txt");
			File desFile = new File("FilesTest/stream_copy2.txt");
			// 2、创建拷贝管道
			in = new FileInputStream(srcFile);
			out = new FileOutputStream(desFile);
			// 3、读取操作
			byte[] buffer = new byte[2];
			int len = -1;
			while ((len = in.read(buffer)) != -1) {
				System.out.println(new String(buffer, 0, len));
				out.write(buffer, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// 4、关闭管道（资源）
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
