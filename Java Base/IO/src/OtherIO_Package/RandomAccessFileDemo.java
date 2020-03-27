package OtherIO_Package;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

//��������ļ�
public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
		File f = new File("D:/JAVA/Java Base/IO/FilesTest/RandomAccessFile");
		write(f);
		read(f);
	}

	// �����ȡ�ļ�����
	private static void read(File f) throws IOException {
		RandomAccessFile in = new RandomAccessFile(f, "r");
		System.out.println("�ļ�ָ��λ��:" + in.getFilePointer());// ��ӡ����ļ�ָ��  0
		byte b = in.readByte();
		System.out.println(b);
		System.out.println("�ļ�ָ��λ��:" + in.getFilePointer());//1
		String str = in.readUTF();
		System.out.println(str);
		System.out.println("�ļ�ָ��λ��:" + in.getFilePointer());//18
		in.seek(0);// �����ļ�ָ��λ��
		System.out.println("�ļ�ָ��λ��:" + in.getFilePointer());//0
		in.skipBytes(12);// ��������12���ֽ�
		System.out.println("�ļ�ָ��λ��:" + in.getFilePointer());//12
		int i = in.readInt();
		System.out.println(i);//-425487643 ���������ȡ�Ӷ�ƴ�Ӳ���������
		System.out.println("�ļ�ָ��λ��:" + in.getFilePointer());//16
		in.close();

	}

	// д���ļ�
	private static void write(File f) throws IOException {
		RandomAccessFile out = new RandomAccessFile(f, "rw");
		out.write(65);
		out.writeUTF("���������");// ʹ���޸İ�UTF-8
		out.write(575);
		out.write(4);
		out.writeUTF("Сˮ��");
		out.write(52);
		out.close();
	}

}
