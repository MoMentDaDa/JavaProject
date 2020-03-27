package BufferStreamPackage;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//字节流和缓冲流的对比
public class NodeStreamVSBufferStreamDemo {

	public static void main(String[] args) throws IOException {
		File src = new File("FilesTest/英语微考点02.mp4");// 280681
		File des = new File("desFiles/英语.mp4");
		testByStreamInt(src, des);//280681
		testByBufferedStream(src, des);//1169
		testByBufferStream(src, des);//203
		testByBuffered4(src, des);// 90

	}

	// 利用节点流，一个字节一个字节的传输
	private static void testByStreamInt(File src, File des) throws IOException {
		long begin = System.currentTimeMillis();
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(des);
		int len = -1;// 即可代表字节数，即为读入的字节个数和数据
		while ((len = in.read()) != -1) {
			out.write(len);
		}
		out.close();
		in.close();
		System.out.println(System.currentTimeMillis() - begin);
	}

	// 使用缓冲流，从内存文件中一个一个字节读写
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

	// 使用节点流，从磁盘一次读取2048个字节
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

	// 使用节点流，从内存文件中每次读写2048个字节,再使用包装流进行读写
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
