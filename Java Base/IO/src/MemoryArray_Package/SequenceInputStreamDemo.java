package MemoryArray_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

//˳����/�ͺϲ���
public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		//����˳��������
		SequenceInputStream in=new SequenceInputStream(new FileInputStream("FilesTest/FileBufferedChar.txt"), new FileInputStream("FilesTest/stream.txt"));
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=in.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}

	}

}
