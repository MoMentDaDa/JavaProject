package Class_Package;
//��ȡ�ֽ������Class����
public class ClassInstanceDemo {

	public static void main(String[] args) throws Exception {
		//��ȡJava,until.Date����ֽ������
		//��ʽһ:ʹ��class����
		Class<java.util.Date> clazz1=java.util.Date.class;
		//��ʽ��:ͨ�������getClass������ȡ��getClass��Object���еķ���
		java.util.Date date=new java.util.Date();
		Class<?> clazz2=date.getClass();
		//��ʽ��:ͨ��Class���еľ�̬����forName(String className);
		Class<?> clazz3=Class.forName("java.util.Date");
		System.out.println(clazz1);
		System.out.println(clazz2);
		System.out.println(clazz3);
		

	}

}
