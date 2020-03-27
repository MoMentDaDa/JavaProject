package OtherIO_Package;
//Java格式化输出
public class PrintFormatDemo {

	public static void main(String[] args) {
		String name="汪";
		int age=17;
		//传统输出方法
		System.out.println("姓名:"+name+",年龄："+age);
		String str="姓名："+name+",年龄："+age;
		System.out.println(str);
			
		//格式化输出方式
		String format="姓名:%s,年龄:%d";
		Object[] data={"汪",17};
		System.out.printf(format,data);
		System.out.println();
		//简化方式
		System.out.printf("姓名:%s,年龄:%d","wang",18);
		

	}

}
