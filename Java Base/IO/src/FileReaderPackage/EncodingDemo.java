package FileReaderPackage;

import java.util.Arrays;

//�����ַ�����
public class EncodingDemo {

	public static void main(String[] args) throws Exception {
		String Message = "����";
		byte[] data = Message.getBytes("UTF-8");
		System.out.println(Arrays.toString(data));// [-26, -79, -86, -27, -109,
													// -91]

		// �������:byte[] --->String
		// ���ڷ�������ʹ���Լ����뷽ʽ,ISO-8859-1
		String ret = new String(data, "ISO-8859-1");
		System.out.println(ret);// ?��????

		// ���������������ת��
		data = ret.getBytes("ISO-8859-1");
		System.out.println(Arrays.toString(data));// [-26, -79, -86, -27, -109,
													// -91]
		ret = new String(data, "UTF-8");
		System.out.println(ret);// ����
	}

}
