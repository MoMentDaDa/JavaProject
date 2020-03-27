package FileReaderPackage;

import java.util.Arrays;

//测试字符编码
public class EncodingDemo {

	public static void main(String[] args) throws Exception {
		String Message = "汪哥";
		byte[] data = Message.getBytes("UTF-8");
		System.out.println(Arrays.toString(data));// [-26, -79, -86, -27, -109,
													// -91]

		// 解码操作:byte[] --->String
		// 由于服务器会使用自己解码方式,ISO-8859-1
		String ret = new String(data, "ISO-8859-1");
		System.out.println(ret);// ?±????

		// 解决方案便是两次转码
		data = ret.getBytes("ISO-8859-1");
		System.out.println(Arrays.toString(data));// [-26, -79, -86, -27, -109,
													// -91]
		ret = new String(data, "UTF-8");
		System.out.println(ret);// 汪哥
	}

}
