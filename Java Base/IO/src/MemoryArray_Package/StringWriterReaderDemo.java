package MemoryArray_Package;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

//×Ö·û´®Á÷£¨×Ö·û´®ÄÚ´æÁ÷£©
public class StringWriterReaderDemo {

	public static void main(String[] args) throws IOException {
		//×Ö·û´®Êä³öÁ÷
		StringWriter sWriter =new StringWriter();
		sWriter.write("Íô¸çÀ÷º¦²»");
		sWriter.write("À÷º¦");
		System.out.println(sWriter.toString());
		
		//×Ö·û´®ÊäÈëÁ÷
		StringReader sReader=new StringReader(sWriter.toString());
		char[] buffer=new char[20];
		int len=-1;
		while((len=sReader.read(buffer))!=-1){
			System.out.println(new String(buffer,0,len));
		}
		
	}

}
