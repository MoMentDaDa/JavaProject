package FileStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileInputStreamPackageDemo {

	public static void main(String[] args) throws Exception {
		// 1����������Դ���ھ���
		File f = new File("FilesTest/stream.txt");
		// 2�������ļ��ֽ����������󣬲�������Դ��
		InputStream in = new FileInputStream(f);
		// 3������Ķ�ȡ����
		/*
			  �����ȡ�����û�����ݱ㷵��-1,�൱���ļ�ָ��
			 int read()   �Ӹ���������ȡһ���ֽڵ����ݡ� 
			 int read(byte[] b)      �Ӹ���������ȡ��� b.length���ֽڵ�����Ϊ�ֽ����顣
			 int read(byte[] b, int off, int len)   �Ӹ���������ȡ��� len�ֽڵ�����Ϊ�ֽ����顣
		 */
		/*int data = in.read();;
		System.out.println(data);//65 A->65
		System.out.println("--------------------------");*/
		
	/*	byte[] buffer =new byte[10];//
		in.read(buffer);
		System.out.println(Arrays.toString(buffer));//[65, 66, 67, 68, 101, 108, 108, 111, 0, 0] ����Ĳ�0
		String sb=new String(buffer);
		System.out.println(sb);//ABCDello  ��int����ת��Ϊ�ַ�����û�еĻ��������
		System.out.println("--------------------------");*/
		
	/*	byte[] buffer2=new byte[10];
		System.out.println(Arrays.toString(buffer2));
		int ret=in.read(buffer2,2,4);
		System.out.println(Arrays.toString(buffer2));
		String sb2=new String(buffer2);
		System.out.println(sb2);*/
		
	//���û���ģʽһ�ζ�ȡ2���ֽڣ���ȡ�ļ������ļ�
		byte[] buffer3=new byte[2];
		int len=-1;
		while(((len=in.read(buffer3))>0)){
			String sb3=new String(buffer3,0,len);
			System.out.println(sb3);
		}		
		in.close();		
	}
}
