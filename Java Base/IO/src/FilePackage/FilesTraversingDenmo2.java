package FilePackage;

import java.io.*;
import java.util.*;

public class FilesTraversingDenmo2 {
	public static void main(String[] args) {
		String file="D:\\JAVA资料\\Java基础\\笔记";
		File f=new File(file);
		listAllFiles(f);
		
		List<String> parentNames=new ArrayList<String>();
		listAllParent(parentNames,f);
		System.out.println(parentNames);
		Collections.reverse(parentNames);//颠倒list元素
		StringBuffer sb=new StringBuffer(40);
		for(String name:parentNames){
			sb.append(name).append(">");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

	private static void listAllFiles(File f) {
		//第一级文件
		File[] fs=f.listFiles();
		for(File file:fs){
			//打印目录和文件
			System.out.println(fs);
			//如果是目录，递归调用实现遍历
			if(file.isDirectory()){
				listAllFiles(file);
			}
		}		
	}

	private static void listAllParent(List<String> parentNames, File f) {
		if(!"".equals(f.getParentFile().getName())){
			parentNames.add(f.getParentFile().getName());
		}
		if(f.getParentFile().getParentFile()!=null){
			listAllParent(parentNames, f.getParentFile());
		}
		
	}

}
