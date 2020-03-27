package BufferStreamPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//字节缓冲流
public class BufferStreamDemo {

	public static void main(String[] args) throws IOException {
		//字节缓冲输出流
		BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream("FilesTest/FilesBufferedStream.txt",true));
		bout.write("hello world".getBytes());
		bout.write("hello world".getBytes());
		bout.write("hello world".getBytes());
		bout.close();
		//字节缓冲输入流
		BufferedInputStream bin=new BufferedInputStream(new FileInputStream("FilesTest/FilesBufferedStream.txt"));
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=bin.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		bin.close();
	}

}
