package FileStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamCopyDemo {
//使用字节流完成文件的拷贝操作
	public static void main(String[] args) throws IOException {
	//1、创建拷贝源
		File srcFile=new File("FilesTest/stream.txt");
		File desFile =new File("FilesTest/stream_copy.txt");
	//2、创建拷贝管道
		InputStream in=new FileInputStream(srcFile);
		OutputStream out=new FileOutputStream(desFile);
	//3、读取操作
		byte[] buffer=new byte[2];
		int len=-1;
		while((len=in.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
			out.write(buffer, 0, len);
		}			
	//4、关闭管道（资源）
		in.close();
		out.close();
	}
}
