package LambdaPackage;

import java.util.*;

public class ScopeTesterDeno {
	int var1 = 0;// 实例变量
	static int var3 = 10;// 静态变量

	public void test() {
		String[] data = { "Tom", "Mike", "Mary", "Linda", "Jack" };
		List<String> names = Arrays.asList(data);
		char var2 = ',';// 局部变量
		// var2='';该行代码报错，不允许改变var2最终变量的值
		// 使用Lambda表达式
		names.forEach((name) -> {
			var1++;// 访问并修改实例变量var1
			var3++;
			System.out.println(this.var1 + ":" + name + var2 + var3);// 通过this访问实例变量var1，访问局部变量var2
		});
	}

	public static void main(String[] args) {
		new ScopeTesterDeno().test();
	}
}
