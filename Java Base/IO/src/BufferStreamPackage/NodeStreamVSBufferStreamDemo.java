package BufferStreamPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//�ֽ����ͻ������ĶԱ�
public class NodeStreamVSBufferStreamDemo {

	public static void main(String[] args) throws IOException {
		File src = new File("FilesTest/Ӣ��΢����02.mp4");// 280681
		File des = new File("desFiles/Ӣ��.mp4");
		testByStreamInt(src, des);//280681
		testByBufferedStream(src, des);//1169
		testByBufferStream(src, des);//203
		testByBuffered4(src, des);// 90

	}

	// ���ýڵ�����һ���ֽ�һ���ֽڵĴ���
	private static void testByStreamInt(File src, File des) throws IOException {
		long begin = System.currentTimeMillis();
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(des);
		int len = -1;// ���ɴ����ֽ�������Ϊ������ֽڸ���������
		while ((len = in.read()) != -1) {
			out.write(len);
		}
		out.close();
		in.close();
		System.out.println(System.currentTimeMillis() - begin);
	}

	// ʹ�û����������ڴ��ļ���һ��һ���ֽڶ�д
	private static void testByBufferedStream(File src, File des) throws IOException {
		long begin = System.currentTimeMillis();
		InputStream in = new BufferedInputStream(new FileInputStream(src));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(des));
		int len = -1;
		while ((len = in.read()) != -1) {
			out.write(len);
		}
		in.close();
		out.close();
		System.out.println(System.currentTimeMillis() - begin);
	}

	// ʹ�ýڵ������Ӵ���һ�ζ�ȡ2048���ֽ�
	private static void testByBufferStream(File src, File des) throws IOException {
		long begin = System.currentTimeMillis();
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(des);
		byte[] buffers = new byte[2048];
		int len = -1;
		while ((len = in.read(buffers)) != -1) {
			out.write(buffers, 0, len);
		}
		in.close();
		out.close();
		System.out.println(System.currentTimeMillis() - begin);
	}

	// ʹ�ýڵ��������ڴ��ļ���ÿ�ζ�д2048���ֽ�,��ʹ�ð�װ�����ж�д
	private static void testByBuffered4(File src, File des) throws IOException {
		long begin = System.currentTimeMillis();
		FileInputStream fin = new FileInputStream(src);
		FileOutputStream fout = new FileOutputStream(des);
		InputStream in = new BufferedInputStream(fin);
		OutputStream out = new BufferedOutputStream(fout);
		int len = -1;
		byte[] buffers = new byte[2048];
		while ((len = in.read(buffers)) != -1) {
			out.write(buffers, 0, len);
		}
		in.close();
		out.close();
		System.out.println(System.currentTimeMillis() - begin);

	}
}
