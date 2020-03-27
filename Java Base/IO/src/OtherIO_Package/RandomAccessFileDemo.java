package OtherIO_Package;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//随机访问文件
public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("D:/JAVA/Java Base/IO/FilesTest/RandomAccessFile");
		write(f);
		read(f);
	}

	// 随机读取文件数据
	private static void read(File f) throws IOException {
		RandomAccessFile in = new RandomAccessFile(f, "r");
		System.out.println("文件指针位置:" + in.getFilePointer());// 打印输出文件指针  0
		byte b = in.readByte();
		System.out.println(b);
		System.out.println("文件指针位置:" + in.getFilePointer());//1
		String str = in.readUTF();
		System.out.println(str);
		System.out.println("文件指针位置:" + in.getFilePointer());//18
		in.seek(0);// 设置文件指针位置
		System.out.println("文件指针位置:" + in.getFilePointer());//0
		in.skipBytes(12);// 设置跳过12个字节
		System.out.println("文件指针位置:" + in.getFilePointer());//12
		int i = in.readInt();
		System.out.println(i);//-425487643 由于随机读取从而拼接产生的乱码
		System.out.println("文件指针位置:" + in.getFilePointer());//16
		in.close();

	}

	// 写入文件
	private static void write(File f) throws IOException {
		RandomAccessFile out = new RandomAccessFile(f, "rw");
		out.write(65);
		out.writeUTF("汪哥棒棒哒");// 使用修改版UTF-8
		out.write(575);
		out.write(4);
		out.writeUTF("小水村");
		out.write(52);
		out.close();
	}

}
