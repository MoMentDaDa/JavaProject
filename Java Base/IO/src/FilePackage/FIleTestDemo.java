package FilePackage;

import java.io.*;

public class FIleTestDemo {

	public static void main(String[] args) {
		/*
		 * static String pathSeparator ��ϵͳ�йص�·���ָ�����Ϊ�˷��㣬������ʾΪһ���ַ����� static char
		 * pathSeparatorChar ��ϵͳ�йص�·���ָ����� static String separator
		 * ��ϵͳ�йص�Ĭ�����Ʒָ�����Ϊ�˷��㣬������ʾΪһ���ַ����� static char separatorChar ��ϵͳ�йص�Ĭ�����Ʒָ�����
		 */
		
		
//File���ֶε�ʹ��		
/*		String pathSeparator = File.pathSeparator;
		char pathSeparatorChar = File.pathSeparatorChar;
		String separator = File.pathSeparator;
		char separatorChar = File.separatorChar;
		System.out.println(pathSeparatorChar + "--------" + pathSeparator);
		System.out.println(separator + "---------" + separatorChar);
		String path1 = "D:\\JAVA\\Java Base\\IO";// ����б�߱�ʶת�壬����ӦΪ˫б�ߣ�Unixʹ��/��б�߱�ʶ�ļ���ַ
		String path2 = "D/JAVA/JAVA Base/IO";// winҲ֧��Unix��ַ����ģʽ
		String path3 = "D" + separatorChar + "JAVA" + separatorChar + "JAVA Base" + separatorChar + "IO";
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);*/
		
		
//��ȡ�ļ���·���ͼ��״̬
		//����File����
/*		File f1=new File("D:\\JAVA\\Java Base\\IO");//�����ļ���
		File f2=new File("D:\\JAVA\\Java Base\\IO","test.txt");//ǰΪ�ļ�·������Ϊ�ļ�����
		System.out.println(f1);
		System.out.println(f2);
		File dir=new File("D:\\JAVA\\Java Base\\IO");
		File f3=new File(dir,"test.txt");//ǰΪFile���͵��ļ�·������Ϊ�ļ���
		System.out.println(f3);*/
		
//��ȡ�ļ������Ŀ¼	
/*		File f1=new File("D:\\JAVA\\Java Base\\IO");
		System.out.println(f1.getAbsolutePath());//
		System.out.println(f1.getAbsoluteFile());
		System.out.println(f1.getName());
		System.out.println(f1.getPath());
		System.out.println(f1.getParent());
		System.out.println(f1.getParentFile());*/
		
		
//����ļ����������	
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
