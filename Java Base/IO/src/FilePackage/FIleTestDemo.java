package FilePackage;

import java.io.*;

public class FIleTestDemo {

	public static void main(String[] args) {
		/*
		 * static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。 static char
		 * pathSeparatorChar 与系统有关的路径分隔符。 static String separator
		 * 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。 static char separatorChar 与系统有关的默认名称分隔符。
		 */
		
		
//File类字段的使用		
/*		String pathSeparator = File.pathSeparator;
		char pathSeparatorChar = File.pathSeparatorChar;
		String separator = File.pathSeparator;
		char separatorChar = File.separatorChar;
		System.out.println(pathSeparatorChar + "--------" + pathSeparator);
		System.out.println(separator + "---------" + separatorChar);
		String path1 = "D:\\JAVA\\Java Base\\IO";// 单反斜线标识转义，所以应为双斜线，Unix使用/正斜线标识文件地址
		String path2 = "D/JAVA/JAVA Base/IO";// win也支持Unix地址划分模式
		String path3 = "D" + separatorChar + "JAVA" + separatorChar + "JAVA Base" + separatorChar + "IO";
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);*/
		
		
//获取文件的路径和检测状态
		//创建File对象
/*		File f1=new File("D:\\JAVA\\Java Base\\IO");//创建文件夹
		File f2=new File("D:\\JAVA\\Java Base\\IO","test.txt");//前为文件路径，后为文件名称
		System.out.println(f1);
		System.out.println(f2);
		File dir=new File("D:\\JAVA\\Java Base\\IO");
		File f3=new File(dir,"test.txt");//前为File类型的文件路径，后为文件名
		System.out.println(f3);*/
		
//获取文件的相关目录	
/*		File f1=new File("D:\\JAVA\\Java Base\\IO");
		System.out.println(f1.getAbsolutePath());//
		System.out.println(f1.getAbsoluteFile());
		System.out.println(f1.getName());
		System.out.println(f1.getPath());
		System.out.println(f1.getParent());
		System.out.println(f1.getParentFile());*/
		
		
//检测文件的相关属性	
		File f2=new File("D:\\JAVA\\Java Base\\IO");
		System.out.println(f2.canExecute());
		System.out.println(f2.canRead());
		System.out.println(f2.canWrite());
		System.out.println(f2.isHidden());
		System.out.println(f2.lastModified());
		System.out.println(new java.util.Date(f2.lastModified()).toString());
		System.out.println(f2.length());
	}

}
