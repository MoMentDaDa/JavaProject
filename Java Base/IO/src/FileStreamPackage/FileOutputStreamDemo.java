package FileStreamPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
	// 1������Ŀ����󣨱�ʾ���ļ����棩
		File target = new File("FilesTest/stream.txt");// ����ļ������ڻ��Զ������ļ������ǲ����Զ�����Ŀ¼
	// 2�������ļ��ֽ����������ˮ�ܣ�
		// ����׳��ļ�û���ҵ����쳣����Ϊ�����Զ�����Ŀ¼���׳��쳣,�÷����Ḳ�ǵ�ǰ���ݣ�׷��ʹ��new
		// FileOutputStream(target��true);
		FileOutputStream out = new FileOutputStream  (target);
	// 3����������������������ݣ��������ַ�ʽ
		/*
		 * void write(int b);��һ���ֽ�д�����ļ� void write(byte[] b); ������b�������ֽ�д�����ļ���
		 * void write(byte[] b,int,off.int len); //�������off��ʼ������Ϊlen���ֽ�д���ļ�
		 */
		out.write(65);// ���ļ�д��A
		out.write("ABCD".getBytes());
		out.write("HelloWrold".getBytes(), 1, 4);
		out.close();
	}

}
