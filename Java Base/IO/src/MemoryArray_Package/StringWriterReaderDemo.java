package MemoryArray_Package;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

//�ַ��������ַ����ڴ�����
public class StringWriterReaderDemo {

	public static void main(String[] args) throws IOException {
		//�ַ��������
		StringWriter sWriter =new StringWriter();
		sWriter.write("����������");
		sWriter.write("����");
		System.out.println(sWriter.toString());
		
		//�ַ���������
		StringReader sReader=new StringReader(sWriter.toString());
		char[] buffer=new char[20];
		int len=-1;
		while((len=sReader.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		
	}

}
