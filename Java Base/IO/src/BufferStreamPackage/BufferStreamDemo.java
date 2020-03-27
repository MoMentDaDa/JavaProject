package BufferStreamPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//�ֽڻ�����
public class BufferStreamDemo {

	public static void main(String[] args) throws IOException {
		//�ֽڻ��������
		BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream("FilesTest/FilesBufferedStream.txt",true));
		bout.write("hello world".getBytes());
		bout.write("hello world".getBytes());
		bout.write("hello world".getBytes());
		bout.close();
		//�ֽڻ���������
		BufferedInputStream bin=new BufferedInputStream(new FileInputStream("FilesTest/FilesBufferedStream.txt"));
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=bin.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		bin.close();
	}

}
