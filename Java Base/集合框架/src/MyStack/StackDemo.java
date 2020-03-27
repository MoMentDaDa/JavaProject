package MyStack;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		//利用Stack类实现栈结构，Stack继承于Vector类，使用数组来存储，规定数组头为栈底
		Stack s1=new Stack();
		s1.add("C");
		s1.add("B");
		s1.add("A");
		System.out.println(s1);
		System.out.println(s1.peek());//查看栈顶元素
		s1.pop();//删除栈顶元素，并返回该元素
		System.out.println(s1.peek());
		//使用ArrayDeque实现，但规定数组头尾栈顶，方法和Stack类基本相同
		System.out.println("-------------------");
		ArrayDeque s2=new ArrayDeque();
		s2.add("C");
		s2.add("B");
		s2.add("A");
		System.out.println(s2);
		System.out.println(s2.peek());//查看栈顶元素
		s2.pop();//删除栈顶元素，并返回该元素
		System.out.println(s2.peek());
	}

}
