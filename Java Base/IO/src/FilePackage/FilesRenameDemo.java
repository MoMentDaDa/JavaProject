package FilePackage;

import java.io.*;

public class FilesRenameDemo {
	public static void main(String[] args) {
		// 获取要删除的目录
		File dir = new File("E:\\公共课\\马原基础");
		File[] fs = dir.listFiles();// 通过遍历文件，然后把文件存入fs数组
		// 需要被替换或者删除的文字
		String deleteText = "【关注微信公众号 超才读书少年（chaocaibook）领取更多免费资料】";
		for (File file : fs) {
			if (file.getName().contains(deleteText)) {
				String newFileName = file.getName().replace(deleteText, "");
				file.renameTo(new File(dir, newFileName));
			}
		}
	}
}
