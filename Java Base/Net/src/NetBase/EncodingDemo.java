package NetBase;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EncodingDemo {

	public static void main(String[] args) throws Exception {
		//��ȡƽ̨Ĭ���ַ���
		System.out.println(System.getProperty("file.encoding"));
		String name="�����good18";
		String ret=URLEncoder.encode(name,"GBK");
		System.out.println(ret);
		String del=URLDecoder.decode(ret, "GBK");
		System.out.println(del);
		//ʹ��UTF-8����ͽ���
		String ret2=URLEncoder.encode(name,"UTF-8");
		System.out.println(ret2);
		String del2=URLDecoder.decode(ret2, "UTF-8");
		System.out.println(del2);
		
	}

}
