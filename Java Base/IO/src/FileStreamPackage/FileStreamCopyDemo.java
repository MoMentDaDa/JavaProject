package FileStreamPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamCopyDemo {
//ʹ���ֽ�������ļ��Ŀ�������
	public static void main(String[] args) throws IOException {
	//1����������Դ
		File srcFile=new File("FilesTest/stream.txt");
		File desFile =new File("FilesTest/stream_copy.txt");
	//2�����������ܵ�
		InputStream in=new FileInputStream(srcFile);
		OutputStream out=new FileOutputStream(desFile);
	//3����ȡ����
		byte[] buffer=new byte[2];
		int len=-1;
		while((len=in.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
			out.write(buffer, 0, len);
		}			
	//4���رչܵ�����Դ��
		in.close();
		out.close();
	}
}
