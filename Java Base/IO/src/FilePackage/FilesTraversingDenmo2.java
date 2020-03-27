package FilePackage;

import java.io.*;
import java.util.*;

public class FilesTraversingDenmo2 {
	public static void main(String[] args) {
		String file="D:\\JAVA����\\Java����\\�ʼ�";
		File f=new File(file);
		listAllFiles(f);
		
		List<String> parentNames=new ArrayList<String>();
		listAllParent(parentNames,f);
		System.out.println(parentNames);
		Collections.reverse(parentNames);//�ߵ�listԪ��
		StringBuffer sb=new StringBuffer(40);
		for(String name:parentNames){
			sb.append(name).append(">");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}

	private static void listAllFiles(File f) {
		//��һ���ļ�
		File[] fs=f.listFiles();
		for(File file:fs){
			//��ӡĿ¼���ļ�
			System.out.println(fs);
			//�����Ŀ¼���ݹ����ʵ�ֱ���
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
