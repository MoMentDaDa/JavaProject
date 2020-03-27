package NetBase;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingDemo {

	public static void main(String[] args) throws Exception {
		//获取平台默认字符集
		System.out.println(System.getProperty("file.encoding"));
		String name="汪大大good18";
		String ret=URLEncoder.encode(name,"GBK");
		System.out.println(ret);
		String del=URLDecoder.decode(ret, "GBK");
		System.out.println(del);
		//使用UTF-8编码和解码
		String ret2=URLEncoder.encode(name,"UTF-8");
		System.out.println(ret2);
		String del2=URLDecoder.decode(ret2, "UTF-8");
		System.out.println(del2);
		
	}

}
