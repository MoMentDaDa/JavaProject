package FileStreamPackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
	// 1、创建目标对象（表示把文件保存）
		File target = new File("FilesTest/stream.txt");// 如果文件不存在会自动创建文件，但是不能自动创建目录
	// 2、创建文件字节输出流对象（水管）
		// 这会抛出文件没有找到的异常，因为不能自动创建目录，抛出异常,该方法会覆盖当前数据，追加使用new
		// FileOutputStream(target，true);
		FileOutputStream out = new FileOutputStream  (target);
	// 3、具体输出操作（往外数据），有三种方式
		/*
		 * void write(int b);把一个字节写出到文件 void write(byte[] b); 把数组b中所有字节写出到文件中
		 * void write(byte[] b,int,off.int len); //把数组从off开始，长度为len个字节写入文件
		 */
		out.write(65);// 向文件写出A
		out.write("ABCD".getBytes());
		out.write("HelloWrold".getBytes(), 1, 4);
		out.close();
	}

}
