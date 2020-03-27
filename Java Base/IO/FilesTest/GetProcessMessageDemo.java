import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

//获取进程中的数据-编译和运行的代码
public class GetProcessMessageDemo {
	public static void main(String[] args) throws Exception {
		String str="System.out.println(\"你是天边最美的云彩\");";
		eval(str);//调用eval方法
	}

//执行str参数，并在控制台打印出str
	private static void eval(String str) throws Exception {
		//创建StringBuffer进行拼接字符串
		StringBuffer sb=new StringBuffer();
		sb.append("public class Hello{");
		sb.append("public static void main(String[] args){");
		sb.append(str);
//		sb.append(";");
		sb.append("}");
		sb.append("}");
		System.out.println(sb);
		//保存到名为hello的java文件中
		OutputStream out=new FileOutputStream("Hello.java");
		out.write(sb.toString().getBytes());
		out.close();
		//3、调用javac进程来编译Hello.java,将会在文件夹中生成hello类文件
		Process javaProcess=Runtime.getRuntime().exec("javac Hello.java");
		//4、读取javac进程中的错误信息
		InputStream error=javaProcess.getErrorStream();
		byte[] buffer=new byte[1024];
		int len=-1;
		while((len=error.read(buffer))!=-1){
			String message =new String(buffer,0,len);
			System.out.println(message);
		}
		error.close();//关闭错误输入流
		//5、读取流中的数据，即把Hello进程中的数据读入到该进程
		Process HelloProcess=Runtime.getRuntime().exec("java Hello");
		//读取流中数据
		InputStream info=HelloProcess.getInputStream();
		while((len=info.read(buffer))!=-1){
			String message =new String(buffer,0,len);
			System.out.println(message);
		}
		info.close();
		new File("Hello.java").delete();//若没有关闭流进程，文件将不能删除，因为处于引用状态
		new File("Hello.class").delete();
	}

}
