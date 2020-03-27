package Class_Package;
//获取字节码对象：Class对象
public class ClassInstanceDemo {

	public static void main(String[] args) throws Exception {
		//获取Java,until.Date类的字节码对象
		//方式一:使用class属性
		Class<java.util.Date> clazz1=java.util.Date.class;
		//方式二:通过对象的getClass方法获取，getClass是Object类中的方法
		java.util.Date date=new java.util.Date();
		Class<?> clazz2=date.getClass();
		//方式三:通过Class类中的静态方法forName(String className);
		Class<?> clazz3=Class.forName("java.util.Date");
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		

	}

}
