package FilePackage;

import java.io.File;
import java.io.FilenameFilter;

//使用FilenameFiltes过滤器实现其未实现的方法，从而实现文件过滤
public class FilenameFilterDemo {

	public static void main(String[] args) {
		File dir = new File("D:/JAVA/Java Base/IO/src/FilePackage/TestFiles");
		File[] fs = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return new File(dir, name).isFile() && name.endsWith(".jpg");
			}
		});
		for (File file : fs) {
			System.out.println(file);
		}

	}

}
