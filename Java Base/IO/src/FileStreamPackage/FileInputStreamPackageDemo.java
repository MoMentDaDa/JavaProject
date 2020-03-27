package FileStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileInputStreamPackageDemo {

	public static void main(String[] args) throws Exception {
		// 1、创建输入源（挖井）
		File f = new File("FilesTest/stream.txt");
		// 2、创建文件字节输入流对象，并连接在源上
		InputStream in = new FileInputStream(f);
		// 3、具体的读取操作
		/*
			  如果读取到最后没有数据便返回-1,相当于文件指针
			 int read()   从该输入流读取一个字节的数据。 
			 int read(byte[] b)      从该输入流读取最多 b.length个字节的数据为字节数组。
			 int read(byte[] b, int off, int len)   从该输入流读取最多 len字节的数据为字节数组。
		 */
		/*int data = in.read();;
		System.out.println(data);//65 A->65
		System.out.println("--------------------------");*/
		
	/*	byte[] buffer =new byte[10];//
		in.read(buffer);
		System.out.println(Arrays.toString(buffer));//[65, 66, 67, 68, 101, 108, 108, 111, 0, 0] 多余的补0
		String sb=new String(buffer);
		System.out.println(sb);//ABCDello  把int类型转换为字符串，没有的会输出乱码
		System.out.println("--------------------------");*/
		
	/*	byte[] buffer2=new byte[10];
		System.out.println(Arrays.toString(buffer2));
		int ret=in.read(buffer2,2,4);
		System.out.println(Arrays.toString(buffer2));
		String sb2=new String(buffer2);
		System.out.println(sb2);*/
		
	//利用缓存模式一次读取2个字节，读取文件所有文件
		byte[] buffer3=new byte[2];
		int len=-1;
		while(((len=in.read(buffer3))>0)){
			String sb3=new String(buffer3,0,len);
			System.out.println(sb3);
		}		
		in.close();		
	}
}
