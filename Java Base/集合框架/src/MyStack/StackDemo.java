package MyStack;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		//����Stack��ʵ��ջ�ṹ��Stack�̳���Vector�࣬ʹ���������洢���涨����ͷΪջ��
		Stack s1=new Stack();
		s1.add("C");
		s1.add("B");
		s1.add("A");
		System.out.println(s1);
		System.out.println(s1.peek());//�鿴ջ��Ԫ��
		s1.pop();//ɾ��ջ��Ԫ�أ������ظ�Ԫ��
		System.out.println(s1.peek());
		//ʹ��ArrayDequeʵ�֣����涨����ͷβջ����������Stack�������ͬ
		System.out.println("-------------------");
		ArrayDeque s2=new ArrayDeque();
		s2.add("C");
		s2.add("B");
		s2.add("A");
		System.out.println(s2);
		System.out.println(s2.peek());//�鿴ջ��Ԫ��
		s2.pop();//ɾ��ջ��Ԫ�أ������ظ�Ԫ��
		System.out.println(s2.peek());
	}

}
