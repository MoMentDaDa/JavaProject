package LambdaPackage;

import java.util.*;

public class ScopeTesterDeno {
	int var1 = 0;// ʵ������
	static int var3 = 10;// ��̬����

	public void test() {
		String[] data = { "Tom", "Mike", "Mary", "Linda", "Jack" };
		List<String> names = Arrays.asList(data);
		char var2 = ',';// �ֲ�����
		// var2='';���д��뱨��������ı�var2���ձ�����ֵ
		// ʹ��Lambda���ʽ
		names.forEach((name) -> {
			var1++;// ���ʲ��޸�ʵ������var1
			var3++;
			System.out.println(this.var1 + ":" + name + var2 + var3);// ͨ��this����ʵ������var1�����ʾֲ�����var2
		});
	}

	public static void main(String[] args) {
		new ScopeTesterDeno().test();
	}
}
