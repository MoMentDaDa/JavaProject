import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//��ȡ�����е�����-��������еĴ���
public class GetProcessMessageDemo {
	public static void main(String[] args) throws Exception {
		String str="System.out.println(\"��������������Ʋ�\");";
		eval(str);//����eval����
	}

//ִ��str���������ڿ���̨��ӡ��str
	private static void eval(String str) throws Exception {
		//����StringBuffer����ƴ���ַ���
		StringBuffer sb=new StringBuffer();
		sb.append("public class Hello{");
		sb.append("public static void main(String[] args){");
		sb.append(str);
//		sb.append(";");
		sb.append("}");
		sb.append("}");
		System.out.println(sb);
		//���浽��Ϊhello��java�ļ���
		OutputStream out=new FileOutputStream("Hello.java");
		out.write(sb.toString().getBytes());
		out.close();
		//3������javac����������Hello.java,�������ļ���������hello���ļ�
		Process javaProcess=Runtime.getRuntime().exec("javac Hello.java");
		//4����ȡjavac�����еĴ�����Ϣ
		InputStream error=javaProcess.getErrorStream();
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=error.read(buffer))!=-1){
			String message =new String(buffer,0,len);
			System.out.println(message);
		}
		error.close();//�رմ���������
		//5����ȡ���е����ݣ�����Hello�����е����ݶ��뵽�ý���
		Process HelloProcess=Runtime.getRuntime().exec("java Hello");
		//��ȡ��������
		InputStream info=HelloProcess.getInputStream();
		while((len=info.read(buffer))!=-1){
			String message =new String(buffer,0,len);
			System.out.println(message);
		}
		info.close();
		new File("Hello.java").delete();//��û�йر������̣��ļ�������ɾ������Ϊ��������״̬
		new File("Hello.class").delete();
	}

}
