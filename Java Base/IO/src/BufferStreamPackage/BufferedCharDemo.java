package BufferStreamPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//�����ַ�������
public class BufferedCharDemo {

	public static void main(String[] args) throws IOException {
		//�����ַ����������
		BufferedWriter bout=new BufferedWriter(new FileWriter("FilesTest/FileBufferedChar.txt"));
		bout.write("������й���������į�졣");
		bout.newLine();
		bout.write("��ͷ��Ů�ڣ�����˵���ڡ�");
		bout.flush();
		bout.close();
		BufferedReader bin=new BufferedReader(new FileReader("FilesTest/FileBufferedChar.txt"));
	//ʹ�ô�ͳ�ķ�����ȡ
	/*	char[] buffer=new char[1024];
		int len=-1;
		while((len=bin.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		bin.close();*/
	//ʹ�û�������read������ȡ
		String len=null;
		while((len=bin.readLine())!=null){
			System.out.println(len);
		}
		bin.close();
		
		
	}

}
