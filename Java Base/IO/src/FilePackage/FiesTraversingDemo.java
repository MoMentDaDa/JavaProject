package FilePackage;

import java.io.*;

//通过递归实现文件和目录的遍历
public class FiesTraversingDemo {
	public static void main(String[] args) {
		File dir = new File("D:\\JAVA资料\\Java基础");
		listAllFiles(dir);

	}

	// 递归方法遍历文件
	private static void listAllFiles(File f) {
		// 第一级文件
		File[] fs = f.listFiles();
		for (File file : fs) {
			// 打印目录和文件
			System.out.println(fs);
			// 如果是目录，递归调用实现遍历
			if (file.isDirectory()) {
				listAllFiles(file);
			}
		}
	}
	// 不使用递归
	/*
	 * private static void listAllFiles(File f) { System.out.println(f);
	 * //第一级子文件 File[] fs = f.listFiles(); for (File file : fs) {
	 * System.out.println(file); //第二季子文件 if (file.isDirectory()) { File[] fs2 =
	 * file.listFiles(); for (File file2 : fs2) { System.out.println(file2);
	 * //第三级子文件 if (file2.isDirectory()) { File[] fs3 = file2.listFiles(); for
	 * (File file3 : fs3) { System.out.println(fs3); } } } } } }
	 */
}
